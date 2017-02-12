package com.geekidentity.jvm;

public class VolatileStopThread extends Thread {
	private boolean stop = false;
	public void stopMe() {
		stop = true;
	}
	@Override
	public void run() {
		@SuppressWarnings("unused")
		int i = 0;
		while (!stop) {
			i++;
		}
		System.out.println("stop thread");
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileStopThread thread = new VolatileStopThread();
		thread.start();
		Thread.sleep(1000);
		thread.stopMe();
		Thread.sleep(1000);
	}
}
