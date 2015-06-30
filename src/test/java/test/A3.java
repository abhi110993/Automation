package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class A3 {

	static String url = "jdbc:mysql://10.0.1.86/";
	static String dbName = "tatoc";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "tatocuser"; 
	static String password = "tatoc01";




	//	Read more: http://mrbool.com/how-to-connect-with-mysql-database-using-java/25440#ixzz3e422qGt3


	public static void main(String... s) throws Exception {
			WebDriver wd=new FirefoxDriver();
			wd.navigate().to("http://10.0.1.86/tatoc/advanced/query/gate");
			String ss=wd.findElement(By.xpath("//div[@id='symboldisplay']")).getText();
			System.out.println(ss);
			int mainid=0;
			String name=null ;
			String passkey = null ;

		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			Statement st = conn.createStatement();
			
	/*		 SELECT * FROM Customers
			 WHERE Country='Mexico';
		*/	
			
			ResultSet res = st.executeQuery("SELECT * FROM  identity");


			ResultSetMetaData metaData = res.getMetaData();
			int count = metaData.getColumnCount(); //number of column
			String columnName[] = new String[count];

			for (int i = 1; i <= count; i++)
			{
			System.out.println(metaData.getColumnLabel(i)); 
			}
			while (res.next()) {

				int id = res.getInt("id");
				String msg = res.getString("Symbol");
				if(ss.equalsIgnoreCase(msg)){
					mainid=id;
					System.out.println(id + "\t" + msg);
				}
				//System.out.println(id + "\t" + msg);
			}
			ResultSet res1 = st.executeQuery("SELECT * FROM  credentials");
			ResultSetMetaData metaData2 = res1.getMetaData();
			int count2 = metaData.getColumnCount(); //number of column
			for (int i = 1; i <= count2; i++)
			{
			System.out.println(metaData2.getColumnLabel(i)); 
			}
			while (res1.next()) {

				int id = res1.getInt("id");
if(mainid==id){
				name = res1.getString("name");
				passkey = res1.getString("PassKey");
			}}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(mainid + "\t" + name+"\t"+passkey);
	
		
		wd.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		wd.findElement(By.xpath("//input[@id='passkey']")).sendKeys(passkey);;
		wd.findElement(By.xpath("//input[@id='submit']")).click();
		

	}
}