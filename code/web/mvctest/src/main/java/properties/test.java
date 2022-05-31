package properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String file = br.readLine();
		
		while(true) {
			if(file.indexOf(".") == -1 || file.startsWith(".") || file.endsWith(".")) {
				System.out.println("파일이 오류입니다");
				file = br.readLine();
			}else {
				int p = file.indexOf(".");
				String f = file.substring(0, p);
				String e = file.substring(p+1);
				System.out.println("파일 압부분 : " + f);
				System.out.println("파일 확장자 : " + e);
				break;
			}
		}
	}

}
