package src.threadcoreknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-23 08:20
 **/
public class MyUncatchExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncatchExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程"+t.getName(),e);
        System.out.println("捕获器"+name+"捕获了线程"+t.getName()+e);
    }
}
