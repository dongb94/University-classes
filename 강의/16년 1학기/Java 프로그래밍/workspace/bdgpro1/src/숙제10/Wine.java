package ¼÷Á¦10;

class Wine{
	private String manufacturer, name, country, region, kind;
	private int year, grade;
	Wine(String m, String n, String c, String r, String k, int y, int g){
		manufacturer=m;
		name=n;
		country=c;
		region=r;
		kind=k;
		year=y;
		grade=g;
	}
	Wine(String m, String n){
		manufacturer=m;
		name=n;
	}
}