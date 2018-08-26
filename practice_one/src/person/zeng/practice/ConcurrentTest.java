package person.zeng.practice;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ConcurrentTest {
	private static final Integer count = 10;
	public static void main(String[] args) throws Exception {
		ThreadFactory factory = new ThreadFactory() {
			public Thread newThread(Runnable r) {
				 Thread t = new Thread(r);
				 return t;
			}
		};
		CyclicBarrier barrier = new CyclicBarrier(count);
		ExecutorService serive = Executors.newFixedThreadPool(10,factory);
		for(int i=0;i<count;i++) {
			serive.submit(new task(barrier));
		}
		serive.shutdown();
		if(serive.isTerminated()) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class task implements Runnable{
	CyclicBarrier barrier;
	public task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName()+"start");
		try {
			barrier.await();
			System.out.println(Thread.currentThread().getName()+"end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

