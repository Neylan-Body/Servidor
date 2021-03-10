package servidor;

//import java.awt.List;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class server {

	private static IPBroadcast IP;
	private static ServerSocket server;
	private static DatagramSocket dS;

	public server() {
	}

	public static void main(String[] args) {

		try {
			byte[] b = InetAddress.getByName("localhost").getAddress();

		} catch (UnknownHostException e1) {

			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			dS = new DatagramSocket(50001);

			while (true) {

				byte[] by = new byte[255];

				DatagramPacket packet = new DatagramPacket(by, by.length);

				dS.receive(packet);

				System.out.println(new String(by, 0, by.length));
				System.out.println(packet.getAddress());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IPBroadcast getIPBroadcast() {
		if (IP == null) {
			IP = new IPBroadcast();
		}
		return IP;
	}
}
