import java.net.*;
import java.io.*;

public class MultiCastClient
{
	public static void main(String args[]) throws IOException
	{
		MulticastSocket clntSock=new MulticastSocket(1414);
		InetAddress grp=InetAddress.getByName("224.0.1.0");
		clntSock.joinGroup(grp);
		for(int i=0;i<=10;i++)
		{
			byte[] buf=new byte[256];
			DatagramPacket packet=new DatagramPacket(buf,buf.length);
			clntSock.receive(packet);
			String r=new String(packet.getData());
			System.out.println(r);
		}
		clntSock.leaveGroup(grp);
		clntSock.close();
		

	}
}