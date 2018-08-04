package org.lucky.Executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.testExecutorTiming();
	}

	public void testExecutorTiming(){
		System.out.println(new Date());
		Collection<Future<Integer>> future = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i=1;i < 4; i++){
			future.add(executor.submit(() -> passTime(5)));
		}
		AtomicBoolean isDone = new AtomicBoolean(true);
		while(!isDone(future, isDone).get()){
			//Do something
			System.out.println("Waiting" + new Date());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//int count = 0;
		/*future.forEach(e -> {
			try {
				e.get();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});*/
		System.out.println(new Date());
		executor.shutdown();
		System.out.println(new Date());
	}
	
	private AtomicBoolean isDone(Collection<Future<Integer>> future, AtomicBoolean done){
		done.set(true);
		for(Future<?> fut : future){
			
			if(!fut.isDone())
				done.set(false);
		}
		return done;
	}
	
	public int passTime(int secs){
		try {
			Thread.sleep(secs * 1000);
			System.out.println("Have passed Time:" + secs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secs;
	}
}
