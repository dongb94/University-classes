package network2;

import java.io.*;
import java.net.*;

public class HTTP_Header {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				URLConnection uc = u.openConnection();
				String contentType = uc.getContentType(); // ����Ʈ Ÿ��
				int contentLength = uc.getContentLength();// ����Ʈ ����
				String contentEncoding = uc.getContentEncoding(); // ����Ʈ ���ڵ� ���
				long date = uc.getDate(); // �˻�(�о� ��) ��¥
				long lastModified = uc.getLastModified(); // ����Ʈ�� ���������� ������ ��¥
				long expiration = uc.getExpiration(); // ������
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
