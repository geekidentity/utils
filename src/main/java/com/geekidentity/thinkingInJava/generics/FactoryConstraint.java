package com.geekidentity.thinkingInJava.generics;

interface FacotryI<T> {
	T create();
}

class Foo2<T> {
	@SuppressWarnings("unused")
	private T x;
	public <F extends FacotryI<T>> Foo2(F factory) {
		x = factory.create();
	}
}

class IntegerFactory implements FacotryI<Integer> {
	@Override
	public Integer create() {
		return new Integer(0);
	}
}

class Widget {
	public static class Factory implements FacotryI<Widget> {
		@Override
		public Widget create() {
			return new Widget();
		}
	}
}

public class FactoryConstraint {
	public static void main(String[] args) {
		new Foo2<Integer>(new IntegerFactory());
		new Foo2<Widget>(new Widget.Factory());
	}
}
