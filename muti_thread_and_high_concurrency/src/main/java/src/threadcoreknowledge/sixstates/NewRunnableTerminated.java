package src.threadcoreknowledge.sixstates;

/**
 * 展示线程的new,runnable,terminated状态，即使是正在运行，也是runnable，而不是running
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-13 19:52
 **/
public class NewRunnableTerminated implements  Runnable{

    @Override
    public void run() {
        for(int i = 0; i<1000;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(10);
        System.out.println(thread.getState());
        Thread.sleep(100);
        System.out.println(thread.getState());

    }
}
