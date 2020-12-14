package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ResponseFacade implements ServletResponse{

	private ServletResponse response=null;
	
	public ResponseFacade(Response response){
		this.response=response;
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
		// TODO Auto-generated method stub
		return null;
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
