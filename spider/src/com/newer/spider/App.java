package com.newer.spider;

public class App {
	public static void main(String[] args) {

		for (int i = 0; i <= 9; i++) {
			Spider spider = new Spider("https://movie.douban.com/top250?start="
					+ i * 25 + "&filter=");
			spider.start();
		}
		System.out.println("ÏÂÔØÍê³É");
	}

}
