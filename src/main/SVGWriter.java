
package main;

import Containers.DrawPanel;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Anton
 */
public class SVGWriter {
    public static void writeSVG() throws IOException{
        try(FileWriter writer = new FileWriter("Image.svg", false))
        {
            writer.write(
"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"\n" +
"    \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
"<svg version=\"1.1\"\n" +
"     baseProfile=\"full\"\n" +
"     xmlns=\"http://www.w3.org/2000/svg\"\n" +
"     xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
"     xmlns:ev=\"http://www.w3.org/2001/xml-events\"\n" +
"     width=\"2800\" height=\"1325\">\n" + "" +
//"      <circle r=\"65\" cx=\"70\" cy=\"70\" \n" +
//"    fill=\"orangered\" stroke=\"crimson\" stroke-width=\"5\"\n" +
"  />\n");
             for (int i = 0; i<MainClass.getX(); i++) {
                for (int j = 0; j<MainClass.getY()*2; j++) {
                    if (MainClass.getMatrix()[i][j].getName().equals("Al\u00B3\u207A")) {
                        writer.write(
"     <circle r=\"5\" cx=\""+  (MainClass.getMatrix()[i][j].getX()-4) +"\" cy=\"" +  (MainClass.getMatrix()[i][j].getY()-4)+  "\" \n" +
"     fill=\"none\" stroke=\"black\" stroke-width=\"1\"\n" +
"     />\n");
                    }
                    if (MainClass.getMatrix()[i][j].getName().equals("Fe\u00B3\u207A")) {
                        writer.write(
"     <circle r=\"5\" cx=\""+  (MainClass.getMatrix()[i][j].getX()-4) +"\" cy=\"" +  (MainClass.getMatrix()[i][j].getY()-4)+  "\" \n" +
"     fill=\"black\" stroke=\"black\" stroke-width=\"1\"\n" +
"     />\n");
                    }
                    if (MainClass.getMatrix()[i][j].getName().equals("Fe\u00B2\u207A")) {
                        writer.write(
"     <circle r=\"5\" cx=\""+  (MainClass.getMatrix()[i][j].getX()-4) +"\" cy=\"" +  (MainClass.getMatrix()[i][j].getY()-4)+  "\" \n" +
"     fill=\"black\" stroke=\"black\" stroke-width=\"1\"\n" +
"     />\n" + 
"     <circle r=\"3\" cx=\""+  (MainClass.getMatrix()[i][j].getX()-4) +"\" cy=\"" +  (MainClass.getMatrix()[i][j].getY()-4)+  "\" \n" +
"     fill=\"white\" stroke=\"black\" stroke-width=\"1\"\n" +
"     />\n");
                    }
                    if (MainClass.getMatrix()[i][j].getName().equals("Mg\u00B2\u207A")) {
                        writer.write(
"     <circle r=\"5\" cx=\""+  (MainClass.getMatrix()[i][j].getX()-4) +"\" cy=\"" +  (MainClass.getMatrix()[i][j].getY()-4)+  "\" \n" +
"     fill=\"grey\" stroke=\"black\" stroke-width=\"1\"\n" +
"     />\n");
                    }
                }
             }

writer.write("</svg>");
            
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    
}
}
