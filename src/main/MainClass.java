/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Containers.DrawPanel;
import Containers.MainWindow;
import Containers.PanelResults;
import Objects.DoublePoints;
import Objects.Element;
import Objects.TripplePoints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Anton
 */
public class MainClass {
    
    String[] columnNames = {"name", "Fe2", "Fe3"};
    String[] names = new String[20];
    String[][] data = new String[20][3];
    
    
    
    
    private static int x = 40;
    private static int y = 25;
    
    private static String al = "Al\u00B3\u207A";
    private static  String fe2 = "Fe\u00B2\u207A";
    private static  String fe3 = "Fe\u00B3\u207A";
    private static  String mg = "Mg\u00B2\u207A";
    private static int alAmount = 0;
    private static int fe2Amount = 0;
    private static int fe3Amount = 0;
    private static int mgAmount = 0;
    
    
        
    private static  DoublePoints fe2Fe2 = new DoublePoints(fe2, fe2);
    private static  DoublePoints fe2Fe3 = new DoublePoints(fe2, fe3);
    private static  DoublePoints fe3Fe3 = new DoublePoints(fe3, fe3);
    private static  DoublePoints mgFe2 = new DoublePoints(mg, fe2);
    private static  DoublePoints mgFe3 = new DoublePoints(mg, fe3);
    private static  DoublePoints alFe2 = new DoublePoints(al, fe2);
    private static  DoublePoints alFe3 = new DoublePoints(al, fe3);
    private static  DoublePoints mgMg = new DoublePoints(mg, mg);
    private static  DoublePoints alMg = new DoublePoints(al, mg);
    private static DoublePoints alAl = new DoublePoints(al, al);
        
    private static DoublePoints[] points = {fe2Fe2,fe2Fe3,fe3Fe3,mgFe2,mgFe3,alFe2,alFe3,mgMg,alMg,alAl};
    
    private static TripplePoints fe3Fe3Fe3 = new TripplePoints(fe3, fe3, fe3);
    private static TripplePoints mgFe3Fe3 = new TripplePoints(mg, fe3, fe3);
    private static TripplePoints mgMgFe3 = new TripplePoints(mg, mg, fe3);
    private static TripplePoints mgMgMg = new TripplePoints(mg, mg, mg);
    private static TripplePoints fe2Fe3Fe3 = new TripplePoints(fe2, fe3, fe3);
    private static TripplePoints fe2MgFe3 = new TripplePoints(fe2, mg, fe3);
    private static TripplePoints fe2MgMg = new TripplePoints(fe2, mg, mg);
    private static TripplePoints fe2Fe2Fe3 = new TripplePoints(fe2, fe2, fe3);
    private static TripplePoints fe2Fe2Mg = new TripplePoints(fe2, fe2, mg);
    private static TripplePoints fe2Fe2Fe2 = new TripplePoints(fe2, fe2, fe2);
    private static TripplePoints alFe3Fe3 = new TripplePoints(al, fe3, fe3);
    private static TripplePoints alMgFe3 = new TripplePoints(al, mg, fe3);
    private static TripplePoints alMgMg = new TripplePoints(al, mg, mg);
    private static TripplePoints alFe2Fe3 = new TripplePoints(al, fe2, fe3);
    private static TripplePoints alFe2Mg = new TripplePoints(al, fe2, mg);
    private static TripplePoints alFe2Fe2 = new TripplePoints(al, fe2, fe2);
    private static TripplePoints alAlFe3 = new TripplePoints(al, al, fe3);
    private static TripplePoints alAlMg = new TripplePoints(al, al, mg);
    private static TripplePoints alAlFe2 = new TripplePoints(al, al, fe2);
    private static TripplePoints alAlAl = new TripplePoints(al, al, al);
    
    private static TripplePoints[] tripplePoints = {fe3Fe3Fe3, mgFe3Fe3, mgMgFe3, mgMgMg, fe2Fe3Fe3, 
                                                    fe2MgFe3, fe2MgMg, fe2Fe2Fe3, fe2Fe2Mg, fe2Fe2Fe2,
                                                    alFe3Fe3, alMgFe3, alMgMg, alFe2Fe3, alFe2Mg,
                                                    alFe2Fe2, alAlFe3, alAlMg, alAlFe2, alAlAl};

        
    private static Element[][] matrix = new Element[x][2*y];
    
    
    MainClass () {
        MainWindow frame = new MainWindow();
//      Установка иконки приложению
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("icon7.png")));

//        String[] columnNames = {"name", "Fe2", "Fe3"};
//            String[] names = new String[20];
//            String[][] data = new String[20][3];
//            for (int i =0; i<20; i++){
//                data [i][0] = MainClass.getTripplePoints()[i].getFullName();
//                data[i][1] = Integer.toString(MainClass.getTripplePoints()[i].getFe2Amount());
//                data[i][2] = Integer.toString(MainClass.getTripplePoints()[i].getFe3Amount());
//                
//            }
////            
//            frame.tableResults.setModel(new DefaultTableModel(data, columnNames));
//            frame.tableResults.revalidate();
//            
        //buildElements();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new MainClass();
            }
        });
    }
    public static int getAlAmount(){
        return alAmount;
    }
    public static int getFe2Amount(){
        return fe2Amount;
    }
    public static int getFe3Amount(){
        return fe3Amount;
    }
    public static int getMgAmount(){
        return mgAmount;
    }
    public static void setZeroAmounts(){
        alAmount = 0;
        fe2Amount = 0;
        fe3Amount = 0;
        mgAmount = 0;
    }
    
    
    
    
    public static void buildElements(){   
        for (int n = 0; n<points.length;n++){
            System.out.print(points[n].getAmount() + "  ");
            //points[n].setAmount(57);
        }
        for ( int i = 0; i<tripplePoints.length; i++) {
            tripplePoints[i].setAmountsZero();
            
        }
        int randomAmount;
        for (int i = 0; i<x; i++){
            for (int j =0; j<2*y-1; j = j+2) {
                int num = 0;
                randomAmount = 0;
                for (int k = 0; k < points.length; k++) {
                    randomAmount = randomAmount + points[k].getAmount();
                }
                int rand = (int) (Math.random() * randomAmount + 1); 
                
                for (int n = 0; n<points.length;n++) {
                    if (rand > num && rand <= num + points[n].getAmount()) {
                        Random change = new Random();
                        if (change.nextBoolean()) {
                            matrix[i][j] = new Element(points[n].getPoint2().getName(),i,j);
                            matrix[i][j+1] = new Element(points[n].getPoint1().getName(),i,j+1);
                        } else {
                            matrix[i][j] = new Element(points[n].getPoint1().getName(),i,j);
                            matrix[i][j+1] = new Element(points[n].getPoint2().getName(),i,j+1);
                        }                        
                        points[n].reduceAmount();                             
                        break;
                    } 
                    num = num + points[n].getAmount();
                }
            }
        }
        
        int amountAround=0;
        for (int i = 1; i<x-1; i++) {
            for (int j = 0; j<2*y;j++){
                amountAround=0;
                if (i%2==1&&j%2==0) amountAround = matrix[i-1][j+1].getId()+matrix[i][j+1].getId() + matrix[i+1][j+1].getId();
                if (i%2==1&&j%2==1&&j<(2*y-1)) amountAround = matrix[i][j-1].getId()+ matrix[i-1][j+1].getId() + matrix[i+1][j+1].getId();
                if (i%2==0&&j%2==1) amountAround = matrix[i][j-1].getId() + matrix[i-1][j-1].getId() + matrix[i+1][j-1].getId();
                if (i%2==0&&j%2==0&&j>0) amountAround = matrix[i-1][j-1].getId() + matrix[i+1][j-1].getId() + matrix[i][j+1].getId();
                
                if (matrix[i][j].getName().equals("Fe\u00B2\u207A")){
                    switch (amountAround) {
                        case (3000): fe3Fe3Fe3.increaseFe2Amount(); break;
                        case (2010): mgFe3Fe3.increaseFe2Amount(); break;
                        case (1020): mgMgFe3.increaseFe2Amount(); break;
                        case (30): mgMgMg.increaseFe2Amount(); break;
                        case (2100): fe2Fe3Fe3.increaseFe2Amount(); break;
                        
                        case(1110): fe2MgFe3.increaseFe2Amount(); break;
                        case(120): fe2MgMg.increaseFe2Amount(); break;
                        case(1200): fe2Fe2Fe3.increaseFe2Amount(); break;
                        case(210): fe2Fe2Mg.increaseFe2Amount(); break;
                        case(300): fe2Fe2Fe2.increaseFe2Amount(); break;
                        
                        case(2001): alFe3Fe3.increaseFe2Amount(); break;
                        case(1011): alMgFe3.increaseFe2Amount(); break;
                        case(21): alMgMg.increaseFe2Amount(); break;
                        case(1101): alFe2Fe3.increaseFe2Amount(); break;
                        case(111): alFe2Mg.increaseFe2Amount(); break;
                        
                        case (201): alFe2Fe2.increaseFe2Amount(); break;
                        case(1002): alAlFe3.increaseFe2Amount(); break;
                        case(12): alAlMg.increaseFe2Amount(); break;
                        case(102): alAlFe2.increaseFe2Amount(); break;
                        case (3): alAlAl.increaseFe2Amount(); break;
                    }
                }
                
                if (matrix[i][j].getName().equals("Fe\u00B3\u207A")){
                    switch (amountAround) {
                        case (3000): fe3Fe3Fe3.increaseFe3Amount(); break;
                        case (2010): mgFe3Fe3.increaseFe3Amount(); break;
                        case (1020): mgMgFe3.increaseFe3Amount(); break;
                        case (30): mgMgMg.increaseFe3Amount(); break;
                        case (2100): fe2Fe3Fe3.increaseFe3Amount(); break;
                        
                        case(1110): fe2MgFe3.increaseFe3Amount(); break;
                        case(120): fe2MgMg.increaseFe3Amount(); break;
                        case(1200): fe2Fe2Fe3.increaseFe3Amount(); break;
                        case(210): fe2Fe2Mg.increaseFe3Amount(); break;
                        case(300): fe2Fe2Fe2.increaseFe3Amount(); break;
                        
                        case(2001): alFe3Fe3.increaseFe3Amount(); break;
                        case(1011): alMgFe3.increaseFe3Amount(); break;
                        case(21): alMgMg.increaseFe3Amount(); break;
                        case(1101): alFe2Fe3.increaseFe3Amount(); break;
                        case(111): alFe2Mg.increaseFe3Amount(); break;
                        
                        case (201): alFe2Fe2.increaseFe3Amount(); break;
                        case(1002): alAlFe3.increaseFe3Amount(); break;
                        case(12): alAlMg.increaseFe3Amount(); break;
                        case(102): alAlFe2.increaseFe3Amount(); break;
                        case (3): alAlAl.increaseFe3Amount(); break;
                    }
                    
                }
            }
        }
        double sumPer = 0;
        for (int i =0; i< tripplePoints.length; i++) {
            sumPer = sumPer + tripplePoints[i].getFe2Amount() + tripplePoints[i].getFe3Amount();
        }
        for (int i =0; i< tripplePoints.length; i++) {
            tripplePoints[i].setFeAmount((tripplePoints[i].getFe2Amount()/sumPer*100), (tripplePoints[i].getFe3Amount()/sumPer*100));
        }
        
        
        int sum = 0;
        for (int i =0; i<x; i++) {
            for(int j = 0; j<2*y; j++) {
                System.out.printf("%5s", matrix[i][j].getName());
                if ( matrix[i][j].getName().equals(al))  alAmount++;
                if ( matrix[i][j].getName().equals(fe2))  fe2Amount++;
                if ( matrix[i][j].getName().equals(fe3))  fe3Amount++;
                if ( matrix[i][j].getName().equals(mg))  mgAmount++;                
                sum++;
            }
            System.out.println("");
        }
        
        System.out.println(matrix[0][1].getX()-matrix[0][0].getX() + "    " + 
                Math.sqrt((matrix[0][1].getX()-matrix[1][0].getX())*(matrix[0][1].getX()-matrix[1][0].getX())+
                        (matrix[1][0].getY()-matrix[0][1].getY())*(matrix[1][0].getY()-matrix[0][1].getY())));
        
        for (int i = 0; i<10; i++) {
            System.out.print(points[i].getAmount()+ "  ");
        }
         System.out.println();
         
        for (int i = 0; i<tripplePoints.length; i++) {
            System.out.print(tripplePoints[i].getFullName() + ": " +  tripplePoints[i].getFe2Amount() + "  ");
            System.out.print(tripplePoints[i].getFullName() + ": " +  tripplePoints[i].getFe3Amount() + "  ");
            System.out.println();
            
        }
        System.out.println(sum);
        System.out.println(alAmount);

//       PanelResults.tableResults.revalidate();
         
         
          
         
//         PanelResults.updateTable();
         
         
           // Проверка количества элементов в сетке.
//        int n =0;
//        for (int i =0; i<x; i++) {
//            for(int j = 0; j<2*y; j++) {
//                if (matrix[i][j].getName().equals(mg)) n++;
//            }
//            
//        }
//        System.out.println(n);

    }
    
    
    public static Element[][] getMatrix(){
        return matrix;
    }
    public static int getX(){
        return x;
    }
    public static int getY(){
        return y;
    }
    public static DoublePoints[] getPoints(){
        return points;
    }
    public static TripplePoints[] getTripplePoints(){
        return tripplePoints;
    }
    
}
