package RMI_SERVER;

import java.applet.*;
import java.awt.*;
import java.net.InetAddress;
import java.rmi.*;

import RMI_INTERFACE.Information;

public class Test extends Applet {

  private String s;

  public void init() {

    try { 
      Remote r = Naming.lookup("rmi://"+InetAddress.getLocalHost().getHostAddress()+"/TestRMI");

      if (r instanceof Information) {
       s = ((Information) r).getInformation("Bonjour");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void paint(Graphics g) {
    super.paint(g);
    g.drawString("chaine retournée = "+s,20,20);
  }
}