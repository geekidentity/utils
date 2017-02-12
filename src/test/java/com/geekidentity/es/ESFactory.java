package com.geekidentity.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

public class ESFactory {
	private static String host = "http://localhost:9200";
	private static JestClient client;
	
	public static JestClient getClient() {
		if (client == null) {
			JestClientFactory factory = new JestClientFactory();
			factory.setHttpClientConfig(new HttpClientConfig.Builder(host).multiThreaded(true).build());
			client = factory.getObject();
			return client;
		}
		return client;
	}
}
