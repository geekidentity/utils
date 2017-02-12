package com.geekidentity.jvm;

public class XmxXms {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		byte[] b = new byte[13*1024*1024];
		System.out.println("Xmx=" + Runtime.getRuntime().maxMemory()/1024/1024 + "M");
		System.out.println("free mem=" + Runtime.getRuntime().freeMemory()/1024/1024 + "M");
		System.out.println("total mem=" + Runtime.getRuntime().totalMemory()/1024/1024 + "M");
	}
}
