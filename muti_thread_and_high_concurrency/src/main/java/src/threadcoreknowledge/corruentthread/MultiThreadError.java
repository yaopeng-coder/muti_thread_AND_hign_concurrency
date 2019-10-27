package src.threadcoreknowledge.corruentthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-23 09:00
 **/
public class MultiThreadError implements Runnable {

    private int index = 0;
    static MultiThreadError instance = new MultiThreadError();
    private AtomicInteger realIndex = new AtomicInteger();
    private  AtomicInteger errorIndex = new AtomicInteger();
    private boolean[] marked = new boolean[10000000];


    CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
       Thread t2 =  new Thread(instance);
       t1.start();
       t2.start();
       t1.join();
       t2.join();
       System.out.println("计算值"+instance.index);
        System.out.println("真实值"+instance.realIndex.get());
        System.out.println("错误值"+instance.errorIndex.get());

    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            marked[0] = true;

            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance){
                if(marked[index] && marked[index - 1]){
                    System.out.println("出错误"+index);
                    errorIndex.incrementAndGet();
                }
                marked[index]=true;
            }

        }
    }
}
