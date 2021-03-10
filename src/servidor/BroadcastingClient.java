package servidor;
import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class BroadcastingClient  {
	
	private static IPBroadcast IP;
    private static DatagramSocket socket = null;
    
 
    public static void main(String[] args) throws IOException {
    	
    	 
    	      System.out.println(getIPBroadcast().IP());

    	    	  broadcast("Neylan", InetAddress.getByName(getIPBroadcast().IP().toString().
      					substring(1, (getIPBroadcast().IP().toString()).length())));
    
    }
 
    public static void broadcast(
      String broadcastMessage, InetAddress address) throws IOException {

    	
        socket = new DatagramSocket();
        socket.setBroadcast(true);
        
        InetAddress a = InetAddress.getByName("192.168.23.2");
        byte[] buffer = broadcastMessage.getBytes();
        

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 50001);
//        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, a, 50001);
        socket.send(packet);
        socket.close();
 
        
    }
    
    public static IPBroadcast getIPBroadcast() {
    	
    	if(IP==null)
    	{
    		IP = new IPBroadcast();
    	}
    	
    	return IP;
    }
    
}
    