import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeServer
{	
	public static void main(String args[]) throws IOException
	{
		ServerSocket servSock=null;
		try
		{
			servSock=new ServerSocket(1313);
		}
		catch(IOException e)
		{
			System.out.println("Unable to listen on port 1313");
		}

		Socket clntSock=null;
		 
		for(;;)
		{
			try
			{
				clntSock=servSock.accept();
			}
			
			catch(IOException e)
			{
				System.out.println("Unable to accept");
			}
			
			ObjectOutputStream timeout=new ObjectOutputStream(clntSock.getOutputStream());
			timeout.writeObject(new Date());
			timeout.close();
			clntSock.close();
			
		}

	}
}