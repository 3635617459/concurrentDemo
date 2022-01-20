import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" *******************come in Callable");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}
/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author hfn89
 * @Date 2022/1/20 14:59
 * @Version 1.0
 * java
 * 多线程中，第3种获得多线程的方式
 **/
public class CallableDemo {
    public static void main(String[] args)throws InterruptedException, ExecutionException
    {
        // 两个线程，一个main线程，一个是AA futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();
        //int result02 = futureTask.get();

        System.out.println(Thread.currentThread().getName()  + "*****************");
        int result01=100;
        int result02 = futureTask.get();// 要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成

        System.out.println("********result: "+(result01+result02));
    }
}
