package org.lucky.producerConsumer;

import java.util.Date;
import java.util.concurrent.Callable;

public class ConsumerTask implements Callable<String> {

	private String task;
	
	ConsumerTask(String task){
		this.task = task;
	}
	
	@Override
	public String call() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new Date() + Thread.currentThread().getName() + "consumed:" + task);
		return "Future" + task;
	}

}
