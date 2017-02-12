package com.geekidentity.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

interface Processor<T, E extends Exception> {
	void process(List<T> resultCollector) throws E;
}

@SuppressWarnings("serial")
class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
	List<T> processorAll() throws E {
		List<T> resultCollector = new ArrayList<T>();
		for (Processor<T, E> processor : this) {
			processor.process(resultCollector);
		}
		return resultCollector;
	}
}

@SuppressWarnings("serial")
class Failure1 extends Exception {}

class Processor1 implements Processor<String, Failure1> {
	static int count = 3;
	@Override
	public void process(List<String> resultCollector) throws Failure1 {
		if (count-- > 1) {
			resultCollector.add("Hep!");
		} else {
			resultCollector.add("Ho!");
		}
		if (count < 0) {
			throw new Failure1();
		}
	}
}

@SuppressWarnings("serial")
class Failure2 extends Exception {}

public class ThrowGenericException {
	
}
