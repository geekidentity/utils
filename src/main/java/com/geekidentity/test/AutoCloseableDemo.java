package com.geekidentity.test;

public class AutoCloseableDemo {
	public static void main(String[] args) {
		try(Resource res = new Resource()) {
			res.doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Resource implements AutoCloseable {
	
	void doSomething() {
		System.out.println("desomething");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("resource is closed");
	}
	
}
