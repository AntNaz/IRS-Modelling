/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Anton
 */
public class TripplePoints {
    private Element point1;
    private Element point2;
    private Element point3;
    
    private int fe2Amount;
    private int fe3Amount;
    private String name;
    public TripplePoints(){
    }
    public TripplePoints(String name1, String name2, String name3){
        point1 = new Element(name1);
        point2 = new Element(name2);
        point3 = new Element(name3);
        this.name = name1+name2+name3;
    }
    public int getFe2Amount(){
        return fe2Amount;
    }
    public int getFe3Amount(){
        return fe3Amount;
    }
    public Element getPoint1(){
        return point1;
    }
    public Element getPoint2(){
        return point2;
    }
    public Element getPoint3(){
        return point3;
    }
    public void setAmountsZero(){
        fe2Amount = 0;
        fe3Amount = 0;
    }
    public void increaseFe2Amount(){
        fe2Amount++;
    }
    public void increaseFe3Amount(){
        fe3Amount++;
    }
    public String getFullName(){
        return name;
    }
}
