package rmi;

import java.applet.*;
import java.awt.*;
import java.net.InetAddress;
import java.rmi.*;

public class Test extends Applet {

  private String s;

  public void init() {

    try { 
      Remote r = Naming.lookup("rmi://"+InetAddress.getLocalHost().getHostAddress()+"/TestRMI");

      if (r instanceof Information) {
       s = ((Information) r).getInformation();
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