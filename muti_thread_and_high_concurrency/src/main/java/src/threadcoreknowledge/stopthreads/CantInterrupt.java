package src.threadcoreknowledge.stopthreads;

/**
 * try catch 不把循环体包括进去，sleep方法会清除中断标志位，导致线程不能中断
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 08:56
 **/
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {

            Runnable runnable = ()->{

                int num = 0;
                while(num<10000 && !Thread.currentThread().isInterrupted()){
                    if(num % 100 == 0){
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
            Thread.sleep(5000);
            thread.interrupt();

    }
}
