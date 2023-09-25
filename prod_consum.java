import java.util.*;

 class Consumer implements Runnable{
    List<Integer> Buffer = null;
    private int i=0;
    final int max = 10;
    Consumer(List<Integer> Buffer){
        this.Buffer = Buffer;
    }
    public void consume(int i)throws InterruptedException{
        synchronized (Buffer){
            while (Buffer.isEmpty()){
                System.out.println("Consumer is waiting due to buffer is full");
                Buffer.wait();
            }
        }
        Buffer.remove(i);
        System.out.println("Consumer consuming");
        Thread.sleep(350);
        synchronized (Buffer){
            Buffer.notify();

        }
    }
    @Override
    public void run() {
        try {
            while (true){
                i++;
                consume(i);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}





class Producer implements  Runnable{
    List<Integer> Buffer = null;
    private int i=0;
    final int max = 10;
    Producer(List<Integer> Buffer){
        this.Buffer = Buffer;
    }
    public void produce(int i)throws InterruptedException{
        synchronized (Buffer){
            while (Buffer.size()==max){
                System.out.println("producer is waiting due to buffer is full");
                Buffer.wait();
            }
        }
        Buffer.add(i);
        System.out.println("producer producing");
        Thread.sleep(350);
        synchronized (Buffer){
            Buffer.notify();

        }
    }
    @Override
    public void run() {
       try {
           while (true){
               i++;
               produce(i);
           }
       }
       catch (Exception e){
           System.out.println(e);
       }
    }
}



public class PCProblem {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        Thread p = new Thread(new Producer(B));
        Thread c = new Thread(new Consumer(B));
        p.start();
        c.start();
    }
}
