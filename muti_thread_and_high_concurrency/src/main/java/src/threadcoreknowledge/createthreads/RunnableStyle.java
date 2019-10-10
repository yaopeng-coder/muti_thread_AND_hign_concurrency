package src.threadcoreknowledge.createthreads;

/**
 * 用Runnable接口方式实现线程
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-10 21:22
 **/
public class RunnableStyle implements Runnable{

    @Override
    public void run() {
        System.out.println("我是实现了Runnable接口");
    }

    public static void main(String[] args){
        new Thread(new RunnableStyle()).start();
        System.out.println("我是main线程");
    }
}
