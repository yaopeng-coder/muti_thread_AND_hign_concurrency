package src.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-15 19:39
 **/
public class WaitNotifyPrintOddEvenWait {

    //1.先去获取锁，只要以获得，马上打印
    //2.打印完去唤醒其他线程，然后自己休眠

    private static int count;
    private static final Object lock = new Object();

    public static void main(String[] args) {
            new Thread(new printRunnable(),"偶线程").start();
            new Thread(new printRunnable(),"奇线程").start();

    }

    static class printRunnable implements Runnable{
        @Override
        public void run() {
            while(count < 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"打印"+count++);
                    lock.notify();
                    if(count < 100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }

        }
    }
}
