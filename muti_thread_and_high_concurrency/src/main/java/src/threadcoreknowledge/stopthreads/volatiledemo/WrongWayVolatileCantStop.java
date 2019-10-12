package src.threadcoreknowledge.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 陷入阻塞时，volatile是无法停止线程的，此例中，生产者的速度很快（num<10000满足，太小了不行），消费者慢，所以阻塞队列满了以后，生产者会阻塞，阻塞再storage.put方法中，所以没有办法进入while循环判断
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-12 16:25
 **/
public class WrongWayVolatileCantStop {

        public static void main(String[] args)throws InterruptedException{
            ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
            Producer producer  = new Producer(storage);
            Thread producerThread = new Thread(producer);
            producerThread.start();

            Thread.sleep(1000);

            Consumer consumer = new Consumer(storage);
            while(consumer.needMoreNums()){
                System.out.println(consumer.storage.take()+"被消费了");
                Thread.sleep(100);
            }

            System.out.println("消费者不需要更多数据");

            //生产者停止
            producer.canceled = true;
        }

}

class  Producer implements  Runnable{

       BlockingQueue storage;
      volatile boolean canceled = false;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while(num<10000 && !canceled){
                if(num % 100 == 0){
                    System.out.println(num+"被放入阻塞队列");
                    storage.put(num);
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者结束运行");
        }

    }
}

class  Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if(Math.random() > 0.95){
            return  false;
        }
        return  true;
    }
}
