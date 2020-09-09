/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Containers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;
import main.MainClass;

/**
 *
 * @author Anton
 */
public class DrawInfo extends JPanel{
     @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        Graphics2D g2D = (Graphics2D) g; 
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        int x = this.getWidth();
        int y = 15;
        g2D.setColor(Color.WHITE);
        g2D.fillOval(x/16, y, 10, 10);
        g2D.setColor(Color.BLACK);
        g2D.drawOval(x/16, y, 10, 10);
        g2D.drawString("Al\u00B3\u207A",x/16 + 20, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getAlAmount()/1000.0+")",x/16 + 45, y+11);
           
        g.setColor(Color.BLACK);
        g.fillOval(x/4+20, y , 10, 10);
        g.drawOval(x/4+20, y , 10, 10);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        g2D.drawString("Fe\u00B3\u207A", x/4+20 + 20, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getFe3Amount()/1000.0+")",x/4+20+ 50, y+11);
        
        
        g.fillOval(x/2+10,y, 10, 10);
        g.drawOval(x/2+10,y, 10, 10);
        g.setColor(Color.WHITE);
        g.fillOval(x/2 +10 + 3,y + 3, 4, 4);
        g.setColor(Color.BLACK);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        g2D.drawString("Fe\u00B2\u207A", x/2 +10 + 20, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getFe2Amount()/1000.0+")",x/2 + 10+50, y+11);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x/4*3, y, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(x/4*3, y, 10, 10);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        g2D.drawString("Mg\u00B2\u207A", x/4*3 + 20, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getMgAmount()/1000.0+")",x/4*3 + 55, y+11);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        int xp = this.getWidth()/16;
        int yp = 40;
        float k = 1.5f;
        int[] xPoints = {xp,(int)((54-18)/k)+xp, (int) (54/k)+xp, (int)((54-18)/k)+xp, xp, xp-(int)(18/k)};
        int[] yPoints = {yp,yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp, 2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp,2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp};
        Polygon p = new Polygon(xPoints,yPoints,6);
        g2D.setColor(Color.WHITE);        
        g2D.fillPolygon(p);
        g2D.setColor(Color.BLACK);
        g2D.drawPolygon(p);
        g2D.drawString("1", xp+60, yp+24);
        
        xp = (int) (this.getWidth()/32*14);
        int[] xPoints2 = {xp,(int)((54-18)/k)+xp, (int) (54/k)+xp, (int)((54-18)/k)+xp, xp, xp-(int)(18/k)};
        int[] yPoints2 = {yp,yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp, 2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp,2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp};
        Polygon p2 = new Polygon(xPoints2,yPoints2,6);
        
        
        g2D.setColor(Color.LIGHT_GRAY);        
        g2D.fillPolygon(p2);
        g2D.setColor(Color.BLACK);
        g2D.drawPolygon(p2);
        g2D.drawString("2", xp+60, yp+24);
        
        xp = this.getWidth()/16*13;
        
        int[] xPoints3 = {xp,(int)((54-18)/k)+xp, (int) (54/k)+xp, (int)((54-18)/k)+xp, xp, xp-(int)(18/k)};
        int[] yPoints3 = {yp,yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp, 2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp,2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp};
        Polygon p3 = new Polygon(xPoints3,yPoints3,6);
        g2D.setColor(Color.DARK_GRAY);        
        g2D.fillPolygon(p3);
        g2D.setColor(Color.BLACK);
        g2D.drawPolygon(p3);
        g2D.drawString("3", xp+60, yp+24);
        
    }
}
