package com.geekidentity.es;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Get;
import io.searchbox.core.Index;

public class JestTest {
	private JestClient client = ESFactory.getClient();
	public static void main(String[] args) {
		
	}
	@Test
	@Ignore
	public void indexBulk() throws IOException {
		String indexName = "news";
		Bulk.Builder builder = new Bulk.Builder();
		News news1 = new News(1,"title1", "content1");
		Index index = new Index.Builder(news1).index(indexName).type(indexName).build();
		builder.addAction(index);
		JestResult result = client.execute(builder.build());
		System.out.println(result.getJsonString());
	}
	
	@Test
	public void getTest() throws IOException {
		Get get = new Get.Builder("news", "1").build();
		JestResult result = client.execute(get);
		System.out.println(result.getJsonString());
	}
	
}
