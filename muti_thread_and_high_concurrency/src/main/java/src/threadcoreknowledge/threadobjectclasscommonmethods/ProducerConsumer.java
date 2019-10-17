package src.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-14 09:06
 **/
public class ProducerConsumer {

    public static void main(String[] args) {
        LinkedList<Date> LinkedList = new LinkedList<>();

        EventStorage storage = new EventStorage();

        Producer producer  = new Producer(storage);
        Consumer consumer  = new Consumer(storage);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(producer);
        Thread thread3 = new Thread(consumer);
        Thread thread4 = new Thread(consumer);
        thread1.setName("生产者1");
        thread2.setName("生产者2");
        thread3.setName("消费者1");
        thread4.setName("消费者2");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}


    class Producer implements  Runnable{
        private EventStorage storage;
        private  Integer account ;

        public Producer(EventStorage storage) {
            this.storage = storage;
            this.account = 0;
        }


        public void run() {
            for(int i = 0; i<100;i++){
                synchronized (this){
                    if(account == 3){
                        break;
                    }else{
                    account++;
                    storage.put();
                    System.out.println(account);
                    }
                }
            }
        }
    }


    class Consumer implements  Runnable{
        private EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }


        public void run() {
            for(int i = 0; i<100;i++){
                storage.take();
            }
        }
    }


    class EventStorage{
        private Integer max_size;
        private LinkedList<Date> linkedList;

        public EventStorage() {
            this.max_size = 10;
            this.linkedList = new LinkedList<>();
        }

        public synchronized void put(){
            while(linkedList.size()>= max_size){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            linkedList.add(new Date());
            System.out.println(Thread.currentThread().getName()+"生产了一个产品，目前有"+linkedList.size()+"个产品");
            notifyAll();

        }


        public synchronized void take(){
            while(linkedList.size()<=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            linkedList.poll();
            System.out.println(Thread.currentThread().getName()+"消费了一个产品，还剩"+linkedList.size()+"个产品");
            notifyAll();
        }
    }



