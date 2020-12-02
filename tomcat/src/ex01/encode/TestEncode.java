package ex01.encode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TestEncode { 
	public static void main(String[] args) throws IOException {
		String path=System.getProperty("user.dir")+File.separator;
		File file = new File(path,"webroot/tets.txt"); 
		FileInputStream input=null;
		FileOutputStream output=null;
		try {
			input=new FileInputStream(file);
			output=new FileOutputStream(path+"webroot/copy.txt");
			byte[] b=new byte[10];
			int n=input.read(b);
			while(n!=-1){
				output.write(b);
				n=input.read(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (input!=null) {
				input.close();
			}
			if (output!=null) {
				output.close();
			}
			
		}
		
	}
	
	@Test
	public void test(){
		String path=System.getProperty("user.dir")+File.separator;
		File file = new File(path,"webroot/tets.txt"); 
		try {
			FileReader reader=new FileReader(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
