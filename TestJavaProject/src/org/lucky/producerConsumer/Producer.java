package org.lucky.producerConsumer;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	private BlockingQueue<? super String> queue;

	public Producer(BlockingQueue<? super String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i < 10 ; i++){
			try {
				System.out.println("Producing Message"+ i);
				queue.put("Message" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
