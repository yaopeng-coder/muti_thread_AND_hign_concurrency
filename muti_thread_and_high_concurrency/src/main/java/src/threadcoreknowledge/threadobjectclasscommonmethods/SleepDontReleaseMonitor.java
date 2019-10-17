package src.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-17 18:55
 **/
public class SleepDontReleaseMonitor  implements Runnable{

    public static void main(String[] args){
            Runnable runnable = new SleepDontReleaseMonitor();
            new Thread(runnable).start();
            new Thread(runnable).start();
    }
    @Override
    public void run() {
        syn();
    }

    private synchronized  void syn() {
        System.out.println(Thread.currentThread().getName()+"获取到了锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"苏醒");
    }
}
