package com.geekidentity.thinkingInJava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

class NullRobotProxyhandler implements InvocationHandler {
	private String nullName;
	private Robot proxied = new NRobot();
	
	private class NRobot implements Null, Robot {
		@Override
		public String name() {
			return nullName;
		}
		@Override
		public String model() {
			return nullName;
		}
		@Override
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}

public class NullRobot {
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{Null.class, Robot.class}, new NullRobotProxyhandler());
	}
	public static void main(String[] args) {
		Robot[] robots = {new SnowRemovalRobot("Snow geek"),
				newNullRobot(SnowRemovalRobot.class)};
		for (Robot robot : robots) {
			Robot.Test.test(robot);
		}
	}
}
