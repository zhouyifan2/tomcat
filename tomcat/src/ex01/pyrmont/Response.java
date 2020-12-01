package ex01.pyrmont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Response {

	private static int BUFFER_SIZE=1024;
	Request request;
	OutputStream output;
	public Response(OutputStream output) {
		this.output=output;
	}

	public void setRequest(Request request) {
		this.request=request;
		
	}

	public void sendStaticResource() throws IOException {
		byte[] bytes=new byte[BUFFER_SIZE];
		FileInputStream fis=null;
		try {
		   String childpath=request.getUri();
		   childpath=childpath==null?"/index.html":childpath;
		   File file = new File(HttpServer.WEB_ROOT,childpath);
		   if(file.exists()){
				fis=new FileInputStream(file);
				int ch=fis.read(bytes, 0, BUFFER_SIZE);
				while(ch!=-1){
				   output.write(bytes,0,ch);
				   ch=fis.read(bytes, 0, BUFFER_SIZE);
				 }
			}else{
				String errorMessage="HTTP/1.1 404 File Not Find\r\n"+
			                        "Content-Type:text/html\r\n"+
						            "Content-Length:23\r\n"+
			                        "\r\n"+
						            "<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());				
			}			
	    }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }finally{
		  if(fis!=null){
			  fis.close();
		  }
		 
	  }
	}
}
