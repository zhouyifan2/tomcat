package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Request implements ServletRequest{
	private InputStream input;
	private String uri;

	public Request(InputStream input) {
		this.input=input;
	}


	public void prase() {
		StringBuffer request=new StringBuffer(2048);
		int i;
		byte[] buffer=new byte[2048];
		try {
			i=input.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i=-1;
		}
		for(int j=0;j<i;j++){
			request.append((char)buffer[j]);
		}
		System.out.println(request.toString());
		uri=parseUri(request.toString());
		
	}
	
	private String parseUri(String requestString){
		int index1,index2;
		index1=requestString.indexOf(' ');
		if(index1!=-1){
			index2=requestString.indexOf(' ',index1+1);
			if(index2>index1){
				return requestString.substring(index1+1,index2);
			}
		}
		
		return null;
	}


	public String getUri() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public long getContentLengthLong() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<Locale> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getParameter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] getParameterValues(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRealPath(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCharacterEncoding(String arg0)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

}
