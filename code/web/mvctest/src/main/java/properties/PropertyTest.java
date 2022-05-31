package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

public class PropertyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream fis = null;
		File file = new File("jdbc.properties");
		
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		 Iterator keyIter = prop.keySet().iterator(); 
	        while( keyIter.hasNext() ) { 
	            String key = (String)keyIter.next();  //키 추출 
	            String value = prop.getProperty(key); //키에 따른 값 추출 
	            System.out.println(key + "=" + value); 
	        } 
	        
	        
	        
	        Connection con = null; 
	        PreparedStatement pstmt = null; 
	        ResultSet rs = null; 
	        String sql = ""; 
	        String driver = ""; 
	        String url = ""; 
	        String account = ""; 
	        String password=""; 
	         
	        driver = prop.getProperty("driver"); 
	        url = prop.getProperty("url"); 
	        account = prop.getProperty("account"); 
	        password = prop.getProperty("password"); 

	        try{ 
	            Class.forName(driver); 
	            con = DriverManager.getConnection(url, account, password); 
	            sql = " SELECT count(*) cnt FROM information_schema.tables "
	            		+ " where table_schema = 'javadb' "; 
	            pstmt = con.prepareStatement(sql); 
	            rs = pstmt.executeQuery(); 
	            if (rs.next()){ 
	                System.out.print(account + " 계정의 테이블 갯수: "); 
	                System.out.println(rs.getInt("cnt")); 
	            } 
	        }catch(Exception e){ 
	            System.out.println(e); 
	        } finally {
	        	if(rs != null) {
	        		try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        	if(pstmt != null) {
	        		try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        	if(con != null) {
	        		try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        }
	        

		
	}

}
