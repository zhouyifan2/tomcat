package ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;


public class Response implements ServletResponse{
   
	private static int BUFFER_SIZE=1024;
	Request request;
	OutputStream output;
	PrintWriter writer;
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
		    File file = new File(Constants.WEB_ROOT,childpath);
		    fis=new FileInputStream(file);
			int ch=fis.read(bytes, 0, BUFFER_SIZE);
			while(ch!=-1){
			    output.write(bytes,0,ch);
			    ch=fis.read(bytes, 0, BUFFER_SIZE);
		   }			
	    }catch (Exception e) {  
		  e.printStackTrace();
		  String errorMessage="HTTP/1.1 404 File Not Find\r\n"+
                  "Content-Type:text/html\r\n"+
		            "Content-Length:23\r\n"+
                  "\r\n"+
		            "<h1>File Not Found</h1>";
            output.write(errorMessage.getBytes());		
	  }finally{
		  if(fis!=null){
			  fis.close();
		  }
	  }
	}
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
        writer=new PrintWriter(output,true);
		return writer;
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBufferSize(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterEncoding(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLength(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLengthLong(long l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentType(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocale(Locale locale) {
		// TODO Auto-generated method stub
		
	}

}
