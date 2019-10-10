package src.threadcoreknowledge.createthreads;

/**
 * 用Thread方式实现线程
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-10 21:26
 **/
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("我继承了thread类");
    }

    public static void main(String[] args){
        new ThreadStyle().start();
        System.out.println("我是主线程");
    }
}
