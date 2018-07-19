package com.newer.spider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Task implements Runnable {

	private String src;
	public Task(String src) {
		this.src = src;
	}

	@Override
	public void run() {
		try {
			Document doc = Jsoup.connect(src).get();
			Elements info = doc.select("#info");
			//爬取网站上相应的信息
			String name=doc.select("span[property=v:itemreviewed]").text();
			String director = info.select(".attrs").get(0).text();
			String screenwriter=info.select(".attrs").get(1).text();
			String actors=info.select(".attrs").get(2).text();
			String types=info.select("span[property=v:genre]").text();
//			String country=info.select(".p1").text();
//			String language=info.select(".pl"));
			
			String data=info.select("span[property=v:initialReleaseDate]").text();
			String length=info.select("span[property=v:runtime]").text();
			Film film=new Film(name,director, screenwriter, actors, types, data, length);
			FileOutputStream out=new FileOutputStream("info.txt",true);//将信息写入文档中
			out.write(film.toString().getBytes());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
