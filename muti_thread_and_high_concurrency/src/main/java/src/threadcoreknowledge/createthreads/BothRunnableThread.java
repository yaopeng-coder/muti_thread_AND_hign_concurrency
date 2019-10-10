package src.threadcoreknowledge.createthreads;

/**
 * 同时使用thread和runnable接口
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-10 21:47
 **/
public class BothRunnableThread {

    /**
     * 首先Thread的run方法被重写，然后虽然传入了runnable对象，没有执行它
     * @param args
     */
    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是实现Runnable接口");
            }
        }){
            @Override
            public void run() {
                System.out.println("我是继承Thread类");
            }
        }.start();
    }
}
