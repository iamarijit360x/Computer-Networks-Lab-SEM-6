import java.io.*;
import java.net.*;
import java.util.Date;

public class TimeClient
{	
	public static void main(String args[]) throws IOException
	{
		Socket timeSock=null;
		ObjectInputStream timein=null;
		
		try
		{
			timeSock=new Socket("localhost",1313);
		}
		catch(UnknownHostException e)
		{
			System.out.println("Host not found");
		}

		catch(IOException e)
		{
			System.out.println("Error While connecting host");
		}
			
		
		timein=new ObjectInputStream(timeSock.getInputStream());
		Date servDate=null;
		try
		{
			servDate=(Date)timein.readObject();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("not Date class");
		}
		System.out.println("Server Date:"+servDate);

	}
}