package servidor;

import java.io.IOException;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class Broad {
	
	 public static void main(String[] args) throws IOException {
	 Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
	    while (en.hasMoreElements()) {
	      NetworkInterface ni = en.nextElement();
	      //System.out.println(" Display Name = " + ni.getDisplayName());

	      List<InterfaceAddress> list = ni.getInterfaceAddresses();
	      Iterator<InterfaceAddress> it = list.iterator();

	      while (it.hasNext()) {
	        InterfaceAddress ia = it.next();
	        System.out.println(" Broadcast = " + ia.getBroadcast());
	        
	        
	      }
	    }
	 }
}
