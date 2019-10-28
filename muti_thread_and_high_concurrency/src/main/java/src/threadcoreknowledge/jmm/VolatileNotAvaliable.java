package src.threadcoreknowledge.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示volatile不能保证原子性
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-28 17:30
 **/
public class VolatileNotAvaliable implements Runnable{

    volatile  int a  = 1;

    AtomicInteger realA= new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new VolatileNotAvaliable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((VolatileNotAvaliable)runnable).a);
        System.out.println(((VolatileNotAvaliable)runnable).realA);



    }

    @Override
    public void run() {

        for(int i = 0; i< 10000; i++){
            a++;
            realA.getAndIncrement();
        }

    }
}
