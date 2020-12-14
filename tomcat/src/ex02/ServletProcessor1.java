package ex02;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor1 {


	public void process(Request request, Response response){
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/")+1);
		URLClassLoader loader=null;
		try {
			URL[] urls=new URL[1];
			URLStreamHandler stremHanler=null;
			File classpath=new File(Constants.WEB_ROOT);
			String repository=(new URL("file",null,classpath.getCanonicalPath()+File.separator)).toString();
		    urls[0]=new URL(null,repository,stremHanler);
		    loader=new URLClassLoader(urls);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Class myClass=null;
		try {
			myClass=loader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		
		Servlet servlet=null;
		try {
			servlet=(Servlet) myClass.newInstance();
			
			//ServletRequest r=(ServletRequest)request;
			servlet.service((ServletRequest)request, (ServletResponse)response);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
