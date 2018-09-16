import java.io.*;
import java.sql.*;

public class AddRecord {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root",""); // JDBC 연결
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			int id = 0;
			stmt.executeUpdate("insert into book (id, title, publisher, author) values("+ id++ +",'" + getMySQLString("엄마를 부탁해") + "','" + getMySQLString("창비") + "','" + getMySQLString("신경숙") + "');"); // 레코드 추가
			stmt.executeUpdate("insert into book (id, title, publisher, author) values("+ id++ +",'" + getMySQLString("덕혜옹주") + "','" + getMySQLString("다산책방") + "','" + getMySQLString("권비영") + "');"); // 레코드 추가
			stmt.executeUpdate("insert into book (id, title, publisher, author) values("+ id++ +",'" + getMySQLString("1Q84") + "','" + getMySQLString("문학동네") + "','" + getMySQLString("무라카미 하루키") + "');"); // 레코드 추가
			printTable(stmt);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	// MySQL에서 문자집합으로 인코딩한 문자열 반환
	private static String getMySQLString(String str) {
		String r=null;
		try {
			 r = new String(str.getBytes(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			System.out.println("지원되지 않는 인코딩 타입");
		}
		return r;
	}
	// 자바에서 사용하는 문자집합으로 인코딩한 문자열 반환
	private static String getJavaString(String str) {
		String r=null;
		try {
			r = new String(str.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("지원되지 않는 인코딩 타입");
		}
		return r;
	}
	// 레코드의 각 열의 값 화면에 출력
	private static void printTable(Statement stmt) {
		ResultSet srs;
		System.out.printf("%4s\t|%30s\t\t|%30s\t\t|%10s\n", "id","title", "publisher", "author");
		try {
			srs = stmt.executeQuery("select * from book");
			while (srs.next()) {
				System.out.printf("%4s\t|%30s\t|%30s\t|%10s\n", new String(srs.getString("id")), getJavaString(srs.getString("title")), getJavaString(srs.getString("publisher")), getJavaString(srs.getString("author")));
			}
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
}
