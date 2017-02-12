package com.geekidentity.test;

class Candy {
	static {
		System.out.println("loading Candy");
	}
}

class Gum {
	static {
		System.out.println("loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("loading Cookie");
	}
}
public class SweetShop {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class<SweetShop> clazz = SweetShop.class;
		System.out.println(clazz.newInstance().getClass().getModifiers());
	}
}
