package src.threadcoreknowledge.startthread;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-11 10:42
 **/
public class StartAndRunThread {
    public static void main(String[] args){
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        runnable.run();

        new Thread(runnable).start();
    }




}
