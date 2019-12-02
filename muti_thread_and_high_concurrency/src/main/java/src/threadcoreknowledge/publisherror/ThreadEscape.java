package src.threadcoreknowledge.publisherror;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：     构造函数中新建线程
 */
public class ThreadEscape {

    private Map<String, String> states;

    public ThreadEscape() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "周一");
                states.put("2", "周二");
                states.put("3", "周三");
                states.put("4", "周四");
            }
        }).start();
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadEscape multiThreadsError6 = new ThreadEscape();
       // Thread.sleep(1000);
        System.out.println(multiThreadsError6.getStates().get("1"));
    }
}
