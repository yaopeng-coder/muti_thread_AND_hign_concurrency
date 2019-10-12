package src.threadcoreknowledge.stopthreads;

/**
 *
 * 模拟军队领取武器，五个军队，每个十个人,如果用stop，会造成脏数据
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 15:01
 **/
public class StopThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i<5;i++){
            System.out.println("第"+i+"个军队开始领取武器");
            for(int j = 0;j<10;j++){
                System.out.println("第"+j+"个士兵开始领取武器");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("第"+i+"个军队已经领取完武器");
        }
    }


    public static void main(String[] args)throws InterruptedException{
            Thread thread = new Thread(new StopThread());
            thread.start();
            Thread.sleep(200);
            thread.stop();

    }
}
