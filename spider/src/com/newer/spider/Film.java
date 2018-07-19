package com.newer.spider;

public class Film {
	// 字段
	private String name;//电影名
	private String director;// 导演
	private String screenwriter;// 编剧
	private String actors;// 演员
	private String types;// 类型
//	private String country;// 国家
//	private String language;// 语言
	private String data;// 上映时间
	private String length;// 片长

	public Film(String name,String director, String screenwriter, String actors,
		 String types, String data,
			String length) {
		super();
		this.name=name;
		this.director = director;
		this.screenwriter = screenwriter;
		this.actors = actors;
		this.types = types;
		this.data = data;
		this.length = length;
	}



	@Override
	public String toString() {
		return name+"导演：" + director + ", 编剧：" + screenwriter
				+ ", 主演：" + actors + ", 类型：" + types + ", 上映时间：" + data
				+ ", 片长：" + length+"\n" ;
	}
	
	
	
	

}
