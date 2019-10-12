package src.threadcoreknowledge.stopthreads;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 09:21
 **/
public class RunThrowException implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("gogogo");
                throwInMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {

            Thread thread = new Thread(new RunThrowException());
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
    }
}
