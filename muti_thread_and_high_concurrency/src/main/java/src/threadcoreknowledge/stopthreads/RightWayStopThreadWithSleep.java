package src.threadcoreknowledge.stopthreads;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 08:21
 **/
public class RightWayStopThreadWithSleep {


    public static void main(String[] args)throws InterruptedException {
        Runnable runnable = () -> {

            int num = 0;
            try {
                while(!Thread.currentThread().isInterrupted()&&num<300){
                    if(num % 100 == 0){
                        System.out.println(num+ "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我会被执行吗");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
