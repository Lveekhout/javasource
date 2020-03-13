import java.io.*;
import java.net.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
https://systembash.com/a-simple-java-udp-server-and-udp-client/
*/
class UDPServer
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		while(true)
		{
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			System.out.printf("[%s][%4s] %s\n", dataFormat.format(new Date()), receivePacket.getLength(), new String(receivePacket.getData(), 0, receivePacket.getLength()));
//			while (receivePacket.getLength()==1024) {
//				serverSocket.receive(receivePacket);
//				System.out.printf("[%s][%4s] %s\n", dataFormat.format(new Date()), receivePacket.getLength(), new String(receivePacket.getData(), 0, receivePacket.getLength()));
//			}
		}
	}
}