package src.threadcoreknowledge.stopthreads;

/**
 * 如果循环中睡眠，则不需要判断他的状态
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 08:35
 **/
public class RightWayStopThreafWithSleepEveryLoop {
    public static void main(String[] args)throws InterruptedException {
        Runnable runnable = () -> {

            int num = 0;
            try {
                while(!Thread.currentThread().isInterrupted()&&num<30000){
                    if(num % 100 == 0){
                        System.out.println(num+ "是100的倍数");
                    }
                    num++;
                    Thread.sleep(2);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
