package src.threadcoreknowledge.jmm;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 重排序演示
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-27 20:22
 **/
public class OutOfOrderException {

    private  static  int x = 0;
    private  static  int y = 0;
    private  static  int a = 0;
    private  static  int b = 0;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;

        for(;;){
            i++;

            x = 0;
            y = 0;
            a = 0;
            b = 0;

            //CountDownLatch用来让线程同时执行的，参数1代表执行了latch.await()方法后需要执行一次countdown才能继续往下执行
            CountDownLatch latch = new CountDownLatch(1);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                x = b;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
                y = a;
            }
        });

        thread1.start();
        thread2.start();

        latch.countDown();
        thread1.join();
        thread2.join();

        String result = "第"+i+"次"+"("+x+","+y+")";


        if ( x ==0  && y == 0){
            System.out.println(result);
            break;
        }
        System.out.println(result);

       }
    }






}
