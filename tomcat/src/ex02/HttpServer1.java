package ex02;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class HttpServer1 {
	public static final String WEB_ROOT=
			System.getProperty("user.dir")+File.separator+
			"webroot";
	
	private static final String SHUTDOWN_COMMAND="/SHUTDOWN";
    
	private boolean shutdown=false;
	
	public static void main(String[] args) throws IOException{
		System.out.println(HttpServer1.WEB_ROOT);
		HttpServer1 server=new HttpServer1();
		server.await();
	}
	
	public void await() throws IOException{
		ServerSocket serverSocket=null;
		int port=8088;
		try {
			serverSocket=new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!shutdown){
			Socket socket=null;
			InputStream input=null;
			OutputStream output=null;
			try {
				socket=serverSocket.accept();
				input=socket.getInputStream();
				output=socket.getOutputStream();
				//create Request project and parse
				Request request=new Request(input);
				request.prase();
				
				//create Response object
				Response response=new Response(output);
				response.setRequest(request);
				
				if(request.getUri().startsWith("/servlet/")){
					ServletProcessor1 processor=new ServletProcessor1();
					processor.process(request,response);
				}else{
					StaticResourceProcessor processor=new StaticResourceProcessor();
					processor.process(request,response);
				}
				socket.close();
				if(request.getUri()==null){
					shutdown=false;
				}else{
					shutdown=request.getUri().equals(SHUTDOWN_COMMAND);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(input!=null){
					input.close();
				}
				if(output!=null){
					output.close();
				}
			}
			
		}
		
	}
}
