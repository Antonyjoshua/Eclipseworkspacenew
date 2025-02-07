package DB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBC_Connection {

	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String port = "3306";
//		Connection: To establish a connection with the database.
//		DriverManager: To manage database drivers and establish the connection.
//		Statement: To execute SQL queries.
//		ResultSet: To hold the data retrieved by an SQL query.
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/antony", "root",
				"Antony@100aj");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select * from employee_details where id=3");
//        rs.next(): Moves the cursor to the next row in the ResultSet. Returns false when no more rows are available.
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=in");
        rs.next();
		//while (rs.next()) {
			driver.findElement(By.id("username")).sendKeys(rs.getString("Location"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("Emp_name"));
//			System.out.println(rs.getString("Location"));
//			System.out.println(rs.getInt("age"));
		

	}
}
