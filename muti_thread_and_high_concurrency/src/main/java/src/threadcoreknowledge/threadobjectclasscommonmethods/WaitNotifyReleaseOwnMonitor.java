package src.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-14 08:34
 **/
public class WaitNotifyReleaseOwnMonitor {

    public static Object resourceA = new Object();
    public static Object resourceB = new Object();


    public static void main(String[] args){
            new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadA已经获取到resourceA锁");
                    synchronized (resourceB){
                        System.out.println("ThreadA已经获取到resourceB锁");
                        try {
                            System.out.println("ThreadA释放resourceA锁");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadB已经获取到resourceA锁");
                    System.out.println("ThreadB想要获取到resourceB锁");
                    synchronized (resourceB){
                        System.out.println("ThreadB已经获取到resourceB锁");

                    }
                }
            }
        }).start();
    }
}
