package com.newer.spider;

public class Film {
	// �ֶ�
	private String name;//��Ӱ��
	private String director;// ����
	private String screenwriter;// ���
	private String actors;// ��Ա
	private String types;// ����
//	private String country;// ����
//	private String language;// ����
	private String data;// ��ӳʱ��
	private String length;// Ƭ��

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
		return name+"���ݣ�" + director + ", ��磺" + screenwriter
				+ ", ���ݣ�" + actors + ", ���ͣ�" + types + ", ��ӳʱ�䣺" + data
				+ ", Ƭ����" + length+"\n" ;
	}
	
	
	
	

}
