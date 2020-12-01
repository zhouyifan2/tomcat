package ex01.encode;

import java.io.UnsupportedEncodingException;

public class TestEncode { 
	public static void main(String[] args) {
		String name="你好";
		try {
			byte[] b=name.getBytes("UTF-8");
			name=new String(b,"UTF-8");
			System.out.println(name);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("你好");

	}

}
