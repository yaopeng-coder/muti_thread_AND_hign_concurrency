package src.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-13 21:57
 **/
public class Wait {

    public  static Object object = new Object();

     static  class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"开始运行");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"重新获得锁");
            }
        }
    }
   static  class  Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
            Thread thread1 = new Thread1();
            thread1.start();
            Thread.sleep(50);
            Thread thread2 = new Thread2();
            thread2.start();

    }
}
