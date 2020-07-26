
package Objects;

/**
 *
 * @author Anton
 */
public class Element {
    private String name;
    private int x;
    private int y;
    private int id;
    private int amount = 0;
    
    
    public Element(){
        
    }
    public Element(String name, int i, int j){
        this.name = name;
        this.x = (int) ((j*54-j%2*18 + i%2*54)) + 50;
        this.y = ((int) (i*36*Math.sin(Math.toRadians(60)))) + 50;
        if (name.equals("Al\u00B3\u207A")) id = 1;
        if (name.equals("Mg\u00B2\u207A")) id = 10;
        if (name.equals("Fe\u00B2\u207A")) id = 100;
        if (name.equals("Fe\u00B3\u207A")) id = 1000;
        
    }
    public Element(String name) {
        this.name = name;
        
    }
//    public void setXY (int i, int j){
//        this.x = 50;        
//        this.y = 50;
////        this.x = i*50+50-i%2*20 + j%2*50;        
////        this.y = j*30+50;
//    }
    
    public void setX () {
        
    }
    public void setY (){        
    }
    
    public int getX () {
        return x;
    }
    public int getY (){
        return y;
    }
    public int getAmount(){
        return amount;
    }
    public void setZeroAmount(){
        amount = 0;
    }
    public void increaseAmount(){
        this.amount++;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj != this) return false;
        if (obj.getClass()== this.getClass()) {
            Element point = (Element) obj;
            if (point.name == this.name) return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    public String getName (){
        return name;
    }
    public int getId(){
        return id;
    }
    
   
}
