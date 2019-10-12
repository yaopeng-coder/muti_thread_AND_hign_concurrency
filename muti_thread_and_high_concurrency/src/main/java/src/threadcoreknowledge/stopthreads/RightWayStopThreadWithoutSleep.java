package src.threadcoreknowledge.stopthreads;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-11 11:38
 **/
public class RightWayStopThreadWithoutSleep implements Runnable {
    @Override
    public void run() {
        int num = 0;
        while(!Thread.currentThread().isInterrupted() & num < Integer.MAX_VALUE / 2)
        {
            if(num % 10000 == 0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("我会执行吗");
    }

    public static void main(String[] args)throws InterruptedException{
       Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
       thread.start();
       Thread.sleep(1000);
       thread.interrupt();

    }
}
