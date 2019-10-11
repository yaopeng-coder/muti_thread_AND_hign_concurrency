package src.threadcoreknowledge.createthreads.wrongways;

/**
 * 匿名内部类
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-11 10:01
 **/
public class AnnoymousInnerClassDemo {

    public static void main(String[] args){

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
