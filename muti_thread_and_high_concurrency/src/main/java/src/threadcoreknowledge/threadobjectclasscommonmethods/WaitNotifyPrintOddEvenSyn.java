package src.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-15 19:30
 **/
public class WaitNotifyPrintOddEvenSyn {

    private  static int count;

    private static final Object lock = new Object();

    public static void main(String[] args){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(count < 100){
                        synchronized (lock){
                            if((count & 1) == 0){
                                System.out.println(Thread.currentThread().getName()+"打印"+count++);
                            }
                        }
                    }

                }
            },"偶数线程").start();

           new Thread(new Runnable() {
               @Override
               public void run() {
                   while(count < 100){
                       synchronized (lock){
                           if((count & 1) == 1){
                               System.out.println(Thread.currentThread().getName()+"打印"+count++);
                           }
                       }
                   }
               }
           },"奇数").start();
    }
}
