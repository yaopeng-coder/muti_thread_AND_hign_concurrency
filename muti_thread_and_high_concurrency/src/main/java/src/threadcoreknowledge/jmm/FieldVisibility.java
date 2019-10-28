package src.threadcoreknowledge.jmm;




/**
 *
 * 演示可见性问题
 * @program: muti_thread_AND_hign_concurrency
 * @author: yaopeng
 * @create: 2019-10-28 08:31
 **/
public class FieldVisibility {

    int a = 1;
    int b = 2;

    private void change() {
        a = 3;
        b = a ;

    }

    private  void printlnNumeber() {

        System.out.println("a="+a+",b="+b);
    }

    public static void main(String[] args){
          for(;;){
              FieldVisibility fieldVisibility = new FieldVisibility();

              Thread thread1 = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      fieldVisibility.change();
                  }
              });
              Thread thread2 = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      fieldVisibility.printlnNumeber();
                  }
              });
              thread1.start();
              thread2.start();

          }
    }




}
