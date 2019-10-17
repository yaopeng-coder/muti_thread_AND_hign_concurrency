package src.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-17 19:14
 **/
public class SleepInterrupted implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        //Thread.sleep(40);
        thread.interrupt();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){

            if(!Thread.currentThread().isInterrupted()){
            System.out.println(new Date());
            }else{
                System.out.println("我被中断");
            }
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了");
                e.printStackTrace();
            }*/


        }
    }
}


