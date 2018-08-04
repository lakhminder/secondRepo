package org.lucky.producerConsumer;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		
		Thread singleProducer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));		
		
		singleProducer.start();
		consumer.start();
		
	}

}
