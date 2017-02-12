package com.geekidentity.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkerPool {
	public static void main(String[] args) throws InterruptedException {
		RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandlerImpl();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4,10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),
				threadFactory, rejectedHandler);
		MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		for (int i = 0; i < 10; i++) {
			executorPool.execute(new WorkerThread("cmd " + i));
		}
		Thread.sleep(5000);
		executorPool.shutdown();
		Thread.sleep(5000);
		monitor.shutdown();
	}
}
