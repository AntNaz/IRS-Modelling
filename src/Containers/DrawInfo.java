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
        g2D.fillOval(40, y, 10, 10);
        g2D.setColor(Color.BLACK);
        g2D.drawOval(40, y, 10, 10);
        g2D.drawString("Al\u00B3\u207A",60, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getAlAmount()/1000.0+")",88, y+11);
           
        g.setColor(Color.BLACK);
        g.fillOval(x/4+20, y , 10, 10);
        g.drawOval(x/4+20, y , 10, 10);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        g2D.drawString("Fe\u00B3\u207A", x/4+20 + 20, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getFe3Amount()/1000.0+")",x/4+20+ 53, y+11);
        
        
        g.fillOval(x/2+x/9-42,y, 10, 10);
        g.drawOval(x/2+x/9-42,y, 10, 10);
        g.setColor(Color.WHITE);
        g.fillOval(x/2 +x/9-39,y + 3, 4, 4);
        g.setColor(Color.BLACK);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        g2D.drawString("Fe\u00B2\u207A", x/2 +x/9-22, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getFe2Amount()/1000.0+")",x/2+x/9+11, y+11);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x-130, y, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(x-130, y, 10, 10);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        g2D.drawString("Mg\u00B2\u207A", x-130+20, y+11);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 16 ));
        g2D.drawString("("+MainClass.getMgAmount()/1000.0+")",x-130+58, y+11);
        g2D.setFont(new Font( "SansSerif", Font.BOLD, 16 ));
        int xp = this.getWidth()/16;
        int yp = 50;
        g2D.setColor(Color.LIGHT_GRAY);
        g2D.drawLine(20, yp-13, this.getWidth()-20, yp-13);
        float k = 2f;
        int[] xPoints = {xp,(int)((54-18)/k)+xp, (int) (54/k)+xp, (int)((54-18)/k)+xp, xp, xp-(int)(18/k)};
        int[] yPoints = {yp,yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp, 2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp,2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp};
        Polygon p = new Polygon(xPoints,yPoints,6);
        g2D.setColor(Color.WHITE);        
        g2D.fillPolygon(p);
        g2D.setColor(Color.BLACK);
        g2D.drawPolygon(p);
        g2D.setFont(new Font( "Times New Roman", Font.PLAIN, 12 ));
        g2D.drawString("Преобладает Al", xp+40, yp+20);
        
        xp = (int) (this.getWidth()/2-70);
        int[] xPoints2 = {xp,(int)((54-18)/k)+xp, (int) (54/k)+xp, (int)((54-18)/k)+xp, xp, xp-(int)(18/k)};
        int[] yPoints2 = {yp,yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp, 2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp,2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp};
        Polygon p2 = new Polygon(xPoints2,yPoints2,6);
        
        
        g2D.setColor(Color.LIGHT_GRAY);        
        g2D.fillPolygon(p2);
        g2D.setColor(Color.BLACK);
        g2D.drawPolygon(p2);
        g2D.drawString("Нет преобладающих", xp+40, yp+15);
        g2D.drawString("элементов", xp+40, yp+27);
        
        xp = this.getWidth()-160;
        
        int[] xPoints3 = {xp,(int)((54-18)/k)+xp, (int) (54/k)+xp, (int)((54-18)/k)+xp, xp, xp-(int)(18/k)};
        int[] yPoints3 = {yp,yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp, 2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp,2*(int) (36*Math.sin(Math.toRadians(60))/k)+yp, (int) (36*Math.sin(Math.toRadians(60))/k)+yp};
        Polygon p3 = new Polygon(xPoints3,yPoints3,6);
        g2D.setColor(Color.DARK_GRAY);        
        g2D.fillPolygon(p3);
        g2D.setColor(Color.BLACK);
        g2D.drawPolygon(p3);
        g2D.drawString("Преобладает Fe", xp+40, yp+20);
        
    }
}
