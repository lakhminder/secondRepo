package org.lucky.producerConsumer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class Consumer implements Runnable{

	private BlockingQueue<String> queue;	
	
	public Consumer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1), new ThreadFactory() {
				int counter = 0;
				@Override
				public Thread newThread(Runnable r) {
					// TODO Auto-generated method stub
					return new Thread(r,"ConsumerThread" + counter++);
				}
			}, new RejectedExecutionHandler() {
				
				@Override
				public void rejectedExecution(Runnable r, ThreadPoolExecutor poolExecutor) {
					try {
						System.out.println(new Date() + "Rejected:" + r);
						poolExecutor.getQueue().put(r);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}) ;
			Collection<Future<String>> col = new ArrayList<>();
			while(!queue.isEmpty()){
				String consumerTask = queue.take();
				System.out.println(new Date() + "Consuming" + consumerTask);
				col.add(executor.submit(new ConsumerTask(consumerTask)));
			}
			executor.shutdown();
			for(Future fut : col){
				try {
					System.out.println(fut.get());
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
}
