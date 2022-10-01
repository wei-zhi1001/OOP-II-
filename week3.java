import java.lang.*;
class myThread implements Runnable{
    static int tickets=10000;
    static int st;
    int tgold;
    //亂數賣
    myThread(int s){
        tgold=0;
        st=(int)(Math.random()*4)+1;
    }
    public void run(){
        while (stealgold()) {
            tgold+=st;
        }
        System.out.println(Thread.currentThread().getName()+"共賣出"+tgold+"張高鐵票");
    }
    private synchronized static boolean stealgold() { //synchronized 鎖上
        if ((tickets-st)>0) {
            tickets-=st;
            return true;
            
        } else {
            return false;
        }
    }
}
public class week3{
    public static void main(String[] args) {
        myThread t1=new myThread(4);
        myThread t2=new myThread(4);
        myThread t3=new myThread(4);
        myThread t4=new myThread(4);
        Thread T1=new Thread(t1,"售票機A");
        Thread T2=new Thread(t2,"售票機B");
        Thread T3=new Thread(t3,"售票機C");
        Thread T4=new Thread(t4,"售票機D");
        T1.start();
        T2.start();
        T3.start();
        T4.start();
    }
}