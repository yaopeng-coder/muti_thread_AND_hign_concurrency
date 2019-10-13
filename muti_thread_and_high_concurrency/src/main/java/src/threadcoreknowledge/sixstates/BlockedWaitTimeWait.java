package src.threadcoreknowledge.sixstates;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-13 21:05
 **/
public class BlockedWaitTimeWait implements Runnable{

    public static void main(String[] args) throws InterruptedException {
            BlockedWaitTimeWait runnable = new BlockedWaitTimeWait();
            Thread thread1 = new Thread(runnable);
            thread1.start();
            Thread thread2 = new Thread(runnable);
            thread2.start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(thread1.getState());
            System.out.println(thread2.getState());
            Thread.sleep(1500);
            System.out.println(thread1.getState());
            //注意，wait会让出锁，所以thread2得到锁
            System.out.println(thread2.getState());
    }

    @Override
    public void run() {
       syn();
    }

    synchronized void  syn(){
        try {
            Thread.sleep(1000);

            //wait会让出锁
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
