
package ¼÷Á¦10;
class Song{
	private String title, artist, album, composer[], year, track;
	Song(){
	}
	Song(String title, String artist, String album, String[] composer, String year, String track){
		this.title=title;
		this.artist=artist;
		this.album=album;
		this.composer=composer;
		this.year=year;
		this.track=track;
	}
	void show(){
		System.out.println("titel="+title);
		System.out.println("artist="+artist);
		System.out.println("album="+album);
		System.out.print("composer=");
		for(String i:composer)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("year="+year);
		System.out.println("track="+track);
	}
}
public class Ex4_1 {
	public static void main(String[] args) {
		String composers[]={"composer1","composer2"};
		Song music=new Song("Dancing Queen","ABBA","Dancing Queen",composers,"2000","1");
		music.show();
	}
}
