package src.threadcoreknowledge.uncaughtexception;

/**
 * 子线程抛出的异常主线程catch不住
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-22 20:27
 **/
public class CantCatchDirectly implements Runnable {


    public static void main(String[] args) throws InterruptedException {

        try{
            new Thread(new CantCatchDirectly(),"Mythread-0").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"Mythread-1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"Mythread-2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"Mythread-3").start();
            Thread.sleep(300);
        }catch(RuntimeException e){
            System.out.println("catch exception");

        }


    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
