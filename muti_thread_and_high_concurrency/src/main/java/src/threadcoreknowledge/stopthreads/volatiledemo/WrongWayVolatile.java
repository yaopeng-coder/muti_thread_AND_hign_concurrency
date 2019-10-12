package src.threadcoreknowledge.stopthreads.volatiledemo;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 15:26
 **/
public class WrongWayVolatile implements Runnable {

    private  volatile boolean cancel = false;
    @Override
    public void run() {
        int num = 0;
        try {
            while(num < 10000 && !cancel){
                if(num % 100 == 0){
                    System.out.println(num+"被100整除");
                }
                Thread.sleep(1000);
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("qqqq");
        }
    }

    public static void main(String[] args) throws InterruptedException {
            WrongWayVolatile runnable = new WrongWayVolatile();
            Thread thread  = new Thread(runnable);
            thread.start();
            Thread.sleep(2220);
            runnable.cancel = true;
    }
}
