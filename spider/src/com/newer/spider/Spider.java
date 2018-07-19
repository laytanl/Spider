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
	ExecutorService pool;//多线程处理
	
	public Spider(String url) {
		this.url = url;

	}

	public void start() {
		// 发送 HTTP
		try {
			Document doc = Jsoup.connect(url).get();
			Elements items = doc.select(".grid_view .item");
			pool=Executors.newCachedThreadPool();
			// 遍历
			for (int i = 0; i < items.size(); i++) {
				// 一部影片
				Element item = items.get(i);
				String src=item.select("a[href]").first().attr("href");
				pool.execute(new Task(src));//进入每部影片的链接进行爬取
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
