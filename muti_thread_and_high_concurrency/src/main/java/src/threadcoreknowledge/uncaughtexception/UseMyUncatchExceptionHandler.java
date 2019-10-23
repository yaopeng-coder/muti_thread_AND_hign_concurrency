package src.threadcoreknowledge.uncaughtexception;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-23 08:24
 **/
public class UseMyUncatchExceptionHandler implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        Thread.setDefaultUncaughtExceptionHandler(new MyUncatchExceptionHandler("捕获器1"));

        new Thread(new UseMyUncatchExceptionHandler(),"Mythread-0").start();
        Thread.sleep(300);
        new Thread(new UseMyUncatchExceptionHandler(),"Mythread-1").start();
        Thread.sleep(300);
        new Thread(new UseMyUncatchExceptionHandler(),"Mythread-2").start();
        Thread.sleep(300);
        new Thread(new UseMyUncatchExceptionHandler(),"Mythread-3").start();
        Thread.sleep(300);



    }

    @Override
    public void run() {


            throw new RuntimeException();

    }
}
