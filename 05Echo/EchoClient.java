import java.net.*;
import java.io.*;
public class EchoClient{
	public static void main(String[] args) throws IOException{
		if ((args.length < 2) || (args.length > 3))
			throw new IllegalArgumentException("Parameter(s): <server> <word> [<port>]");
		String server = args[0];
		byte[] byteBuffer = args[1].getBytes();
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		Socket sock = new Socket(server,servPort);
		System.out.println("Connected to server...........Sending Echo String");
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		out.write(byteBuffer);
	
		int totalBytesRevd = 0;
		int bytesRevd;
		while( totalBytesRevd < byteBuffer.length )
		{
			if ((bytesRevd = in.read(byteBuffer,totalBytesRevd, byteBuffer.length - totalBytesRevd)) == -1)
				throw new SocketException("Connection closed prematurely");
			totalBytesRevd += bytesRevd;
		}
		System.out.println("Received:" + new String(byteBuffer));
		sock.close();
}

}