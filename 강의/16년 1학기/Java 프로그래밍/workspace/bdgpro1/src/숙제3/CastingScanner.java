package ¼÷Á¦3;

public class CastingScanner {
	public static void main(String[] arge){
		boolean tr=true;
		
		short number = (byte) 150;

		System.out.println(number);
		float f = 123L;
		long a = 12; 
		int num = 65666; // 65666 = 65536 +135
		byte bNum =(byte) num;
		System.out.println(bNum);
		System.out.println(bNum & 0xff);
		System.out.println(a & 0xff);
		System.out.println(-126 & 0xff);
		int i = 129;
		byte b = (byte)i;
		System.out.println(b);
		System.out.println(b & 0xff);
		System.out.println(64 & 077);
		char c = '3';
		System.out.println( (int)c );
		 byte u = (byte)011;
         short s = (short)0x11;
         int y = 14;
         long l = 160L;
         System.out.println( u + s + y + l );
	}

}
