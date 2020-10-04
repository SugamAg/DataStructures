package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sugamagarwal
 */


class Producer {

    List<Integer> list;
    int size;
    Random random;
    public Producer(List<Integer> list, int size) {
        this.list = list;
        this.size = size;
        random = new Random();
    }

    public void produce() throws InterruptedException {
        synchronized (list) {
            if (size == list.size()){
                System.out.println("List full.. go in wait");
                list.wait();
            }
            int e = random.nextInt();
            System.out.println("Produced"+ e);
            list.add(e);
            list.notify();
        }
    }
}

class Consumer {
    List<Integer> list;
    int size;

    public Consumer(List<Integer> list, int size) {
        this.list = list;
        this.size = size;
    }

    public void consume() throws InterruptedException {
        synchronized (list) {
            if(list.size() == 0){
                System.out.println("List empty.. go in wait");
                list.wait();
            }
            System.out.println("Consumed" + list.remove(0));
            list.notify();
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Object lock = new Object();
        Producer producer = new Producer(list, 2);
        Consumer consumer = new Consumer(list, 2);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        producer.produce();
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        consumer.consume();
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
       t1.start();
       t2.start();
       t1.join();
       t2.join();
    }

}
