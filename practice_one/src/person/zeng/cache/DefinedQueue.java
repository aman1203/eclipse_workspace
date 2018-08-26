package person.zeng.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Administrator
 *
 */
public class DefinedQueue {
	static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	static Random rand = new Random();
	private static final int count=10;
	public static void main(String[] args) throws Exception{
		ExecutorService service = Executors.newFixedThreadPool(count);
		for(int i=0;i<count;i++) {
			service.submit(new Task(queue, rand));
		}
		new Thread(new Consumer(queue)).start();
	}
}
/**
 * 生产消息的线程
 * @author Administrator
 *
 */
class Task implements Runnable{
	private ConcurrentLinkedQueue<String> queue;
	private Random rand;
	public Task(ConcurrentLinkedQueue<String> queue,Random rand ) {
		this.queue = queue;
		this.rand = rand;
	}
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while(true) {
			try {
				Thread.sleep(rand.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(System.currentTimeMillis()-start<=3000) {
				queue.offer(Thread.currentThread().getName()+"生产一个");
			}
			
		}
	}
}

class Consumer implements Runnable{
	private ConcurrentLinkedQueue<String> queue;
	private  final int time = 30000;//时间毫秒
	private  final int size = 500;//条数
	
	public Consumer(ConcurrentLinkedQueue<String> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		while(true) {
			List<String> list = new ArrayList<String>();
			if(queue.size()>=size) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("队列中消息条数为："+queue.size());
				//一次性拿出20条数据
				for(int i=0;i<size;i++) {
					list.add(queue.poll());
				}
				lastTime = System.currentTimeMillis();
				
				System.out.println("消费"+list.size()+"条数据");
			}
			
			if(queue.size()<size&&queue.size()>=1) {
				long intenal = (System.currentTimeMillis()-lastTime);
				long x = intenal%5000;
				if(intenal!=0&&x==0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("倒计时开始....."+intenal/5000);
				}
				//从最后一次消费到现在时间已经到了
				if((System.currentTimeMillis()-lastTime)>=time) {
					System.out.println("队列中消息条数为："+queue.size());
					for(int i=queue.size();i>0;i--) {
						list.add(queue.poll());
					}
					lastTime = System.currentTimeMillis();
					System.out.println("消费"+list.size()+"条数据");
				}
			}
		}
	}
}
