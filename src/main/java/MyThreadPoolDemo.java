import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
  *@ClassName MyThreadPoolDemo
  *@Description TODO
  *@Author hfn89
  *@Date 2022/1/20 16:18
  *@Version 1.0
  *第4中获得/使用java多线程的方式，线程池
**/  
public class MyThreadPoolDemo
{
    public static void main(String[] args)
    {
        // Array Arrays 数组
        // Collection Collections 集合
        // Executor Executors 线程池
        //List<String> list = Arrays.asList("a", "b", "c");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程。
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程。
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程。

        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try
        {
            for (int i = 1; i <=10 ; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
