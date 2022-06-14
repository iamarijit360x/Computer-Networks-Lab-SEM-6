import java.net.*;
import java.io.*;

public class StringServer
{
	public static void main(String args[]) throws IOException
	{
		String FromClnt,OuttoClnt;
		ServerSocket servSock=new ServerSocket(2345);
		while(true)
		{
			Socket clntSock=servSock.accept();

			BufferedReader dsin=new BufferedReader(new InputStreamReader(clntSock.getInputStream()));
			DataOutputStream dout=new DataOutputStream(clntSock.getOutputStream());
		
			FromClnt = dsin.readLine();

			OuttoClnt=FromClnt.toUpperCase()+'\n';
			dout.writeBytes(OuttoClnt);
		
		
		}
	}
}