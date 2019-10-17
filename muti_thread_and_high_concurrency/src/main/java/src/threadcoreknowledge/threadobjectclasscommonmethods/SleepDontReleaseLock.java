package src.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-17 18:58
 **/
public class SleepDontReleaseLock implements Runnable {

    private static  final Lock lock = new ReentrantLock();


    public static void main(String[] args){

        Runnable runnable = new SleepDontReleaseMonitor();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"获取到了lock");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
