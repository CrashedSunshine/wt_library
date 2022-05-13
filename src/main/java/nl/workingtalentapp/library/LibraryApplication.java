package nl.workingtalentapp.library;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
	        
	    SpringApplication.run(LibraryApplication.class, args);
	
		 Connection conn = null;
	      Statement stmt = null;
	      try {
	         try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	         } catch (Exception e) {
	            System.out.println(e);
	      }
	         conn = (Connection) DriverManager.getConnection("jdbc:mysql://wtlibrary.crhg1nwftpeb.us-east-1.rds.amazonaws.com:3306/wt_books?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password");
	         System.out.println("Connection is created successfully:");
	         stmt = (Statement) conn.createStatement();
	         String query1 = "INSERT INTO roles(name) VALUES('ROLE_USER');";
	         stmt.executeUpdate(query1);
	         String query2 = "INSERT INTO roles(name) VALUES('ROLE_MODERATOR');";
	         stmt.executeUpdate(query2);
	         String query3 = "INSERT INTO roles(name) VALUES('ROLE_ADMIN');";
	         stmt.executeUpdate(query3);
	         System.out.println("Record is inserted in the table successfully..................");
	         } catch (SQLException excep) {
	            excep.printStackTrace();
	         } catch (Exception excep) {
	            excep.printStackTrace();
	         } finally {
	            try {
	               if (stmt != null)
	                  conn.close();
	            } catch (SQLException se) {}
	            try {
	               if (conn != null)
	                  conn.close();
	            } catch (SQLException se) {
	               se.printStackTrace();
	            }  
	         }
	         System.out.println("Please check it in the MySQL Table......... ……..");

	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://wtlibrary.s3-website.eu-central-1.amazonaws.com/"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	
	

}