package com.geekidentity.lucene;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneTest {
	public static void main(String[] args) throws Throwable {
		Article article = new Article(1, "geek", "geekidentity is very good");
		//创建索引库
		Path path = FileSystems.getDefault().getPath("./index");
		Directory directory = FSDirectory.open(path);
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, conf);
		Document doc = new Document();
		FieldType fieldType = new FieldType();
		fieldType.setStored(true);
		doc.add(new Field("id", article.getId().toString(), new FieldType(fieldType)));
		doc.add(new Field("title", article.getTitle().toString(), new FieldType(fieldType)));
		doc.add(new Field("content", article.getContent().toString(), new FieldType(fieldType)));
		indexWriter.addDocument(doc);
		indexWriter.close();
	}
	
	public void search() throws IOException {
		IndexSearcher indexSearcher = null;
		indexSearcher.search(null, 2);
	}
}
