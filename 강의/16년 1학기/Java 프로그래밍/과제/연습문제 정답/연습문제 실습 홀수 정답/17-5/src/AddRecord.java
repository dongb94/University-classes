import java.io.*;
import java.sql.*;

public class AddRecord {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root",""); // JDBC ����
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); // SQL�� ó���� Statement ��ü ����
			int id = 0;
			stmt.executeUpdate("insert into book (id, title, publisher, author) values("+ id++ +",'" + getMySQLString("������ ��Ź��") + "','" + getMySQLString("â��") + "','" + getMySQLString("�Ű��") + "');"); // ���ڵ� �߰�
			stmt.executeUpdate("insert into book (id, title, publisher, author) values("+ id++ +",'" + getMySQLString("��������") + "','" + getMySQLString("�ٻ�å��") + "','" + getMySQLString("�Ǻ�") + "');"); // ���ڵ� �߰�
			stmt.executeUpdate("insert into book (id, title, publisher, author) values("+ id++ +",'" + getMySQLString("1Q84") + "','" + getMySQLString("���е���") + "','" + getMySQLString("����ī�� �Ϸ�Ű") + "');"); // ���ڵ� �߰�
			printTable(stmt);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}
	// MySQL���� ������������ ���ڵ��� ���ڿ� ��ȯ
	private static String getMySQLString(String str) {
		String r=null;
		try {
			 r = new String(str.getBytes(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			System.out.println("�������� �ʴ� ���ڵ� Ÿ��");
		}
		return r;
	}
	// �ڹٿ��� ����ϴ� ������������ ���ڵ��� ���ڿ� ��ȯ
	private static String getJavaString(String str) {
		String r=null;
		try {
			r = new String(str.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("�������� �ʴ� ���ڵ� Ÿ��");
		}
		return r;
	}
	// ���ڵ��� �� ���� �� ȭ�鿡 ���
	private static void printTable(Statement stmt) {
		ResultSet srs;
		System.out.printf("%4s\t|%30s\t\t|%30s\t\t|%10s\n", "id","title", "publisher", "author");
		try {
			srs = stmt.executeQuery("select * from book");
			while (srs.next()) {
				System.out.printf("%4s\t|%30s\t|%30s\t|%10s\n", new String(srs.getString("id")), getJavaString(srs.getString("title")), getJavaString(srs.getString("publisher")), getJavaString(srs.getString("author")));
			}
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}
}
