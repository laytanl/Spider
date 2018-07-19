package com.newer.spider;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Spider {

	String url;
	ExecutorService pool;//���̴߳���
	
	public Spider(String url) {
		this.url = url;

	}

	public void start() {
		// ���� HTTP
		try {
			Document doc = Jsoup.connect(url).get();
			Elements items = doc.select(".grid_view .item");
			pool=Executors.newCachedThreadPool();
			// ����
			for (int i = 0; i < items.size(); i++) {
				// һ��ӰƬ
				Element item = items.get(i);
				String src=item.select("a[href]").first().attr("href");
				pool.execute(new Task(src));//����ÿ��ӰƬ�����ӽ�����ȡ
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
