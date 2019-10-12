package src.threadcoreknowledge.stopthreads;

/**
 * 正确处理异常的第二种方法，有底层方法自己处理，但是要恢复中断位
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 09:35
 **/
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("处理日志");
                    break;
                }
                System.out.println("gogog");
                throwExceptionInMethod();
            }

    }

    private void throwExceptionInMethod(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws InterruptedException{
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
