import java.io.*;
import java.net.*;
import java.util.Date;

public class MultiCastServer
{
	public static void main(String args[]) throws IOException,InterruptedException
	{
		DatagramSocket servSock=new DatagramSocket(6969);
		InetAddress group=InetAddress.getByName("224.0.1.0");
		for(;;)
		{
			byte[] buf = new Date().toString().getBytes();
			
			DatagramPacket packet=new DatagramPacket(buf,buf.length,group,1414);
			servSock.send(packet);
			Thread.sleep(1000);
		}
		
	}
}