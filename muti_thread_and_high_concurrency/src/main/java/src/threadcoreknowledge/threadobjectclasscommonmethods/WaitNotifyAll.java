package src.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-14 08:17
 **/
public class WaitNotifyAll  {
    private static final Object ResourceA = new Object() ;

    public static void main(String[] args) throws InterruptedException {
            Thread thread1 = new Thread1();
            Thread thread2 = new Thread2();

            Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (ResourceA){
                        ResourceA.notifyAll();
                        System.out.println(Thread.currentThread().getName()+"执行Notifyall");
                    }
                }
            });
            thread1.start();
            thread2.start();
            Thread.sleep(100);
            thread3.start();
    }

    static class Thread1 extends  Thread{
        @Override
        public void run() {
            synchronized (ResourceA){
                System.out.println(Thread.currentThread().getName()+"拿到锁了");
                try {
                    ResourceA.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"又拿到锁");
            }
        }
    }

    static class Thread2 extends  Thread{

        @Override
        public void run() {
            synchronized (ResourceA){
                System.out.println(Thread.currentThread().getName()+"也拿到锁");
                try {
                    ResourceA.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"又拿到锁");
            }
        }
    }
}
