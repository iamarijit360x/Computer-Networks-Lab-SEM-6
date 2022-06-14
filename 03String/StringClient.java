import java.net.*;
import java.io.*;

public class StringClient
{
	public static void main(String args[]) throws IOException
	{
		String s,ms;
		System.out.print("Enter Sentence:");
		BufferedReader infromUser=new BufferedReader(new InputStreamReader(System.in));
		
		Socket stringSock=new Socket("localhost",2345);
		
		DataOutputStream dos=new DataOutputStream(stringSock.getOutputStream());
		BufferedReader FromServer=new BufferedReader(new InputStreamReader(stringSock.getInputStream()));
		
		dos.writeBytes(infromUser.readLine()+'\n');
		
		ms=FromServer.readLine();
		
		System.out.println("From Server:"+ms);
		stringSock.close();
	}
}