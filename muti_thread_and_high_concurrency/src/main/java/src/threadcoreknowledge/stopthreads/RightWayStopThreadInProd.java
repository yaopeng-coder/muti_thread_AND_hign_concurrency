package src.threadcoreknowledge.stopthreads;

/**
 * 处理异常最佳方式一抛出异常，由run处理，run方法不能再抛出
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 09:35
 **/
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("gogog");
                throwExceptionInMethod();
            } catch (InterruptedException e) {
                System.out.println("处理日志");
                e.printStackTrace();
            }
        }

    }

    private void throwExceptionInMethod() throws InterruptedException{

        Thread.sleep(2000);
    }

    public static void main(String[] args)throws InterruptedException{
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
