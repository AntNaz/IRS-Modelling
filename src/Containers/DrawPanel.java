/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Containers;


//import static Containers.MainWindow.scrollGraph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import main.MainClass;

/**
 *
 * @author Anton
 */
public class DrawPanel extends JPanel  implements MouseWheelListener {
    private static double k = 0.6;
    private static int xPoint;
    private static int yPoint;
    private static int xPointDragged;
    private static int yPointDragged;
    private static int xPoint2;
    private static int yPoint2;

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }
    
    

    public void setPanelSize(){
        setPreferredSize(new Dimension((int) (MainClass.getY()*2*54*k+100), (int)(MainClass.getX()*35*k)));
        setSize(new Dimension((int) (MainClass.getY()*2*54*k+100), (int)(MainClass.getX()*35*k)));
        
        revalidate();
        
    }
    public static double getK(){
        return k;
    }
    public static void setK(){
        k=0.5;
    }
    public int getXPoint(){
            return xPoint;
        }
    public int getYPoint(){
            return yPoint;
        }
//    @Override
//    public void setBackground(Color bg) {
//        super.setBackground(Color.white); //To change body of generated methods, choose Tools | Templates.
//    }
    private static int newX;
    private static int newY;
    public static void setZeroPosition(){
       MainWindow.getScrollGraph().getViewport().setViewPosition(new Point(0,0));
       MainWindow.getScrollGraph().revalidate();
    }
    
    
    Point newViewportPosition = new Point();
      public DrawPanel() {
        addMouseWheelListener(this);
        addMouseMotionListener(new MouseMotionListener() {
        public void mouseMoved(MouseEvent e) {
            xPoint = (int) e.getX();
            yPoint = (int) e.getY();
////            if (xPoint<0) xPoint = 0;
////            if (yPoint<0) yPoint = 0;
        }
            @Override
            public void mouseDragged(MouseEvent e) {
                xPointDragged = (int) e.getX();
                yPointDragged = (int) e.getY();
//                
                Point viewportPosition = MainWindow.getScrollGraph().getViewport().getViewPosition();
                newX = (int)(viewportPosition.getX() + xPoint - xPointDragged);
                newY = (int)(viewportPosition.getY() + yPoint - yPointDragged);
                if (newX<0) newX = 0;
                if (newY<0) newY = 0;
                newViewportPosition.setLocation(newX, newY); 
                MainWindow.getScrollGraph().getViewport().setViewPosition(newViewportPosition);
                MainWindow.getScrollGraph().revalidate();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
      
  @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
            xPoint = (int) e.getX();
            yPoint = (int) e.getY();
        
            System.out.println(xPoint + "  " + yPoint);
        if (e.getWheelRotation()<0) {
            if (k<2) {
                k=(k*1.1);
                System.out.println(k);
                Point viewportPosition = MainWindow.getScrollGraph().getViewport().getViewPosition();
                Point newViewportPosition = new Point(
                           (int)(viewportPosition.getX() + xPoint*1.1 - xPoint),
                           (int)(viewportPosition.getY() + yPoint*1.1 - yPoint)
                            
                 );
                MainWindow.getScrollGraph().getViewport().setViewPosition(newViewportPosition);
                
                MainWindow.getScrollGraph().revalidate();
                xPoint = (int) (xPoint*1.1);
                yPoint = (int) (yPoint*1.1);
           }
            
            
        }
        if (e.getWheelRotation()>0) {
            
            if (k>0.5) {
            k=(k/1.1);
           
            System.out.println(k);
                Point viewportPosition = MainWindow.getScrollGraph().getViewport().getViewPosition();
                Point newViewportPosition = new Point(
                        (int)(viewportPosition.getX() + xPoint/1.1 - xPoint),
                        (int)(viewportPosition.getY() + yPoint/1.1 - yPoint)
                );
                 MainWindow.getScrollGraph().getViewport().setViewPosition(newViewportPosition);
                 
                 MainWindow.getScrollGraph().revalidate();
                 xPoint = (int) (xPoint/1.1);
                yPoint = (int) (yPoint/1.1);
             }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        if (MainClass.getMatrix()[0][0] != null) {
            setPanelSize();
            Graphics2D g2D = (Graphics2D) g; 
        
            for (int i = 0; i<MainClass.getX(); i++){
                for (int j = 0; j<MainClass.getY()*2; j++) {
                    
                    // Отрисовываем шестиугольники для чётных и нечётных строк.
                    if (i%2==0&&j%2==0&&j>1&&j<MainClass.getY()*2-1&&i<MainClass.getX()-2){
                        int[] x = {(int)(MainClass.getMatrix()[i][j].getX()*k),(int)(MainClass.getMatrix()[i][j+1].getX()*k),(int)(MainClass.getMatrix()[i+1][j].getX()*k),(int)(MainClass.getMatrix()[i+2][j+1].getX()*k),(int)(MainClass.getMatrix()[i+2][j].getX()*k),(int)(MainClass.getMatrix()[i+1][j-1].getX()*k)};
                        int[] y = {(int)(MainClass.getMatrix()[i][j].getY()*k),(int)(MainClass.getMatrix()[i][j+1].getY()*k),(int)(MainClass.getMatrix()[i+1][j].getY()*k),(int)(MainClass.getMatrix()[i+2][j+1].getY()*k),(int)(MainClass.getMatrix()[i+2][j].getY()*k),(int)(MainClass.getMatrix()[i+1][j-1].getY()*k)};
                        Polygon p = new Polygon(x,y,6);
                        
                        int idColor = MainClass.getMatrix()[i][j].getId()+MainClass.getMatrix()[i][j+1].getId()+MainClass.getMatrix()[i+1][j].getId()+MainClass.getMatrix()[i+2][j+1].getId()+MainClass.getMatrix()[i+2][j].getId()+MainClass.getMatrix()[i+1][j-1].getId()+10000;
                        
                        
                        String stringColor = Integer.toString(idColor);
                        if (Character.getNumericValue(stringColor.charAt(4))>3) g2D.setColor(Color.WHITE);
                        else if ((Character.getNumericValue(stringColor.charAt(1))+Character.getNumericValue(stringColor.charAt(2)))>3) g2D.setColor(Color.DARK_GRAY);
                        else g2D.setColor(Color.LIGHT_GRAY);
                        g2D.fillPolygon(p);
                        g2D.setColor(Color.BLACK);
                        g2D.drawPolygon(p);  
                    }
                    if (i%2==1&&j%2==0&&i<MainClass.getX()-2&&j<MainClass.getY()*2-2) {
                        int[] x = {(int)(MainClass.getMatrix()[i][j].getX()*k),(int)(MainClass.getMatrix()[i][j+1].getX()*k),(int)(MainClass.getMatrix()[i+1][j+2].getX()*k),(int)(MainClass.getMatrix()[i+2][j+1].getX()*k),(int)( MainClass.getMatrix()[i+2][j].getX()*k),(int)(MainClass.getMatrix()[i+1][j+1].getX()*k)};
                        int[] y = {(int)(MainClass.getMatrix()[i][j].getY()*k),(int)(MainClass.getMatrix()[i][j+1].getY()*k),(int)(MainClass.getMatrix()[i+1][j+2].getY()*k),(int)(MainClass.getMatrix()[i+2][j+1].getY()*k),(int)( MainClass.getMatrix()[i+2][j].getY()*k),(int)(MainClass.getMatrix()[i+1][j+1].getY()*k)};
                        int idColor = MainClass.getMatrix()[i][j].getId()+MainClass.getMatrix()[i][j+1].getId() + MainClass.getMatrix()[i+1][j+2].getId() +  MainClass.getMatrix()[i+2][j+1].getId() + MainClass.getMatrix()[i+2][j].getId() + MainClass.getMatrix()[i+1][j+1].getId() +10000;
                        String stringColor = Integer.toString(idColor);
                        Polygon p = new Polygon(x,y,6);
                        
                        if (Character.getNumericValue(stringColor.charAt(4))>3) g2D.setColor(Color.WHITE);
                        else if (Character.getNumericValue(stringColor.charAt(1))+Character.getNumericValue(stringColor.charAt(2))>3) g2D.setColor(Color.DARK_GRAY);
                        else g2D.setColor(Color.LIGHT_GRAY);
                        g2D.fillPolygon(p);
                        g2D.setColor(Color.BLACK);
                        g2D.drawPolygon(p);  
                    }
                    
                    // Дорисовываем горизонтальные линии по границам сетки.
                    if((i%2==0&&j==0)||(i%2==1&&j==MainClass.getY()*2-2)){
                        g2D.drawLine((int)(MainClass.getMatrix()[i][j].getX()*k), (int)(MainClass.getMatrix()[i][j].getY()*k), (int)(MainClass.getMatrix()[i][j+1].getX()*k), (int)(MainClass.getMatrix()[i][j+1].getY()*k));
                    }

                }
            }
            // Дорисовываем последние две диагональные линии на сетке.
            g2D.drawLine((int)(MainClass.getMatrix()[0][1].getX()*k), (int)(MainClass.getMatrix()[0][1].getY()*k), (int)(MainClass.getMatrix()[1][0].getX()*k), (int)(MainClass.getMatrix()[1][0].getY()*k));
            g2D.drawLine((int)(MainClass.getMatrix()[MainClass.getX()-2][MainClass.getY()*2-1].getX()*k), (int)(MainClass.getMatrix()[MainClass.getX()-2][MainClass.getY()*2-1].getY()*k), (int)(MainClass.getMatrix()[MainClass.getX()-1][MainClass.getY()*2-2].getX()*k), (int)(MainClass.getMatrix()[MainClass.getX()-1][MainClass.getY()*2-2].getY()*k));
//
//
//            Ниже представлен рабочий код для отрисовки шестиугольников линиями. От данного решения пришлось уйти, 
//            т.к. возникла необходимость заполнять шестиугольники разным цветом.

//            for (int i = 0; i<MainClass.getX(); i++){
//                for (int j = 0; j<MainClass.getY()*2-1; j++) {
//                    if (j%2==0){
//                        g.drawLine((int) (MainClass.getMatrix()[i][j].getX()*k), (int) (MainClass.getMatrix()[i][j].getY()*k), (int) (MainClass.getMatrix()[i][j+1].getX()*k), (int) (MainClass.getMatrix()[i][j+1].getY()*k));
//                    }                    
//                    if ((i%2==0)&&(j<MainClass.getY()*2)) {
//                        g.drawLine((int) (MainClass.getMatrix()[i][j+1].getX()*k), (int) (MainClass.getMatrix()[i][j+1].getY()*k), (int) (MainClass.getMatrix()[i+1][j].getX()*k), (int) (MainClass.getMatrix()[i+1][j].getY()*k));
//                    }
//                    if ((i%2==1)&&(j<MainClass.getY()*2)&&(i<MainClass.getX()-1)){
//                        g.drawLine((int) (MainClass.getMatrix()[i][j].getX()*k), (int) (MainClass.getMatrix()[i][j].getY()*k), (int) (MainClass.getMatrix()[i+1][j+1].getX()*k), (int) (MainClass.getMatrix()[i+1][j+1].getY()*k));
//                    }
//                }
//            }


for (int i = 0; i<MainClass.getX(); i++) {
    for (int j = 0; j<MainClass.getY()*2; j++) {
        if (MainClass.getMatrix()[i][j].getName().equals("Al\u00B3\u207A")) { //Al3+
            g.setColor(Color.WHITE);
            g.fillOval((int) (MainClass.getMatrix()[i][j].getX()*k-4), (int) (MainClass.getMatrix()[i][j].getY()*k-4), 10, 10);
            g.setColor(Color.BLACK);
            g.drawOval((int) (MainClass.getMatrix()[i][j].getX()*k-4), (int) (MainClass.getMatrix()[i][j].getY()*k-4), 10, 10);
        }
        if (MainClass.getMatrix()[i][j].getName().equals("Fe\u00B3\u207A")) { //Fe3+
            g.setColor(Color.BLACK);
            g.fillOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
            g.drawOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
        }
        if (MainClass.getMatrix()[i][j].getName().equals("Fe\u00B2\u207A")) { // Fe2+
            g.setColor(Color.BLACK);
            //g.drawOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
            g.fillOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
            g.drawOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
            g.setColor(Color.WHITE);
            g.fillOval((int)(MainClass.getMatrix()[i][j].getX()*k)+3-4, (int)(MainClass.getMatrix()[i][j].getY()*k)+3-4, 4, 4);
            
        }
        if (MainClass.getMatrix()[i][j].getName().equals("Mg\u00B2\u207A")) { //Mg2+
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
            g.setColor(Color.BLACK);
            g.drawOval((int)(MainClass.getMatrix()[i][j].getX()*k)-4, (int)(MainClass.getMatrix()[i][j].getY()*k)-4, 10, 10);
        }
    }
}
        }
        else setPreferredSize(new Dimension(0,0));
        
        repaint();
        
    }
    
     
   
}
