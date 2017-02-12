package com.geekidentity.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SensitiveWord {
	
	private Map<String, Object> sensitiveWordMap;
	public void addSensitiveWordToHashMap(Set<String> keyWorkSet) {
		sensitiveWordMap = new HashMap<>(keyWorkSet.size());////初始化敏感词容器，减少扩容操作 
		String key = null;
		Iterator<String> iterator = keyWorkSet.iterator();
		while (iterator.hasNext()) {
			key = iterator.next();//关键词
			for (int i = 0; i < key.length(); i++) {
				char keyChar = key.charAt(i);
				Object wordMap = sensitiveWordMap.get(keyChar);
				
				if (wordMap != null) {//如果存在该key，直接赋值
					
				}
			}
		}
	}
}
