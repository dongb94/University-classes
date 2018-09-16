package network2;

import java.io.*;
import java.net.*;

public class HTTP_Header {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				URLConnection uc = u.openConnection();
				String contentType = uc.getContentType(); // 컨텐트 타입
				int contentLength = uc.getContentLength();// 컨텐트 길이
				String contentEncoding = uc.getContentEncoding(); // 컨텐트 인코딩 방식
				long date = uc.getDate(); // 검색(읽어 온) 날짜
				long lastModified = uc.getLastModified(); // 컨텐트가 마지막으로 수정된 날짜
				long expiration = uc.getExpiration(); // 만기일
				System.out.println("contentType :\t  " + contentType);
				System.out.println("contentLength :\t  " + contentLength);
				System.out.println("contentEncoding : " + contentEncoding);
				System.out.println("date : \t\t  " + date);
				System.out.println("lastModified :\t  " + lastModified);
				System.out.println("expiration :\t  " + expiration);
			} catch (MalformedURLException ex) {
				System.err.println(args[0] + " is not a parseable URL");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
