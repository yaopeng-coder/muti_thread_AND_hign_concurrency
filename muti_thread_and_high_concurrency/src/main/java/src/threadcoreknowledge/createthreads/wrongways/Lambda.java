package src.threadcoreknowledge.createthreads.wrongways;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-11 10:06
 **/
public class Lambda {
    public static void main(String[] args){
        new Thread( () -> System.out.println(Thread.currentThread().getName())).start();

    }
}
