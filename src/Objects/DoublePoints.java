/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Random;

/**
 *
 * @author Anton
 */
public class DoublePoints {
    private Element point1;
    private Element point2;
    private int amount;
    private String name;

    
    public DoublePoints(){
        
    }
    public DoublePoints(String name1, String name2) {        
        point1 = new Element(name1);
        point2 = new Element (name2);
        this.name = name1+name2;
        
    }
    public Element getPoint1(){
        return point1;
    }
     public Element getPoint2(){
        return point2;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public void reduceAmount(){
        this.amount = amount - 1;
    }
    public int getAmount () {
        return amount;
    }
    
     public String getName(){
         return name;
     }
    
}
