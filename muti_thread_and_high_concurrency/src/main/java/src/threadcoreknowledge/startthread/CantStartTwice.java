package src.threadcoreknowledge.startthread;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-11 10:51
 **/
public class CantStartTwice {

    public static void main(String[] args){
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }


}
