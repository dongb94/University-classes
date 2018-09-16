import java.io.*;
import java.sql.*;
public class DeleteRecord {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root",""); // JDBC 연결
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			stmt.executeUpdate("delete from book where title='"+ getMySQLString("IQ84") +"' and author='" + getMySQLString("김아무개") +"'"); // 레코드 삭제
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
