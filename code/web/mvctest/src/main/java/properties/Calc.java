package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		File file = new File("calc.properties");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		
		int su1 = Integer.parseInt(prop.getProperty("su1"));
		int su2 = Integer.parseInt(prop.getProperty("su2"));
		
		System.out.println("su1 + su2 = " + Math.addExact(su1, su2));
		System.out.println("su1 - su2 = " + Math.subtractExact(su1, su2));
		System.out.println("su1 * su2 = " + Math.multiplyExact(su1, su2));
		System.out.println("su1 / su2 = " + Math.floorDiv(su1, su2));
	}

}
