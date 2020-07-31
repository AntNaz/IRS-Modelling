/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Containers;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import main.MainClass;

/**
 *
 * @author Anton
 */

public class PanelResults extends JPanel{
//        JTable tableResults = new JTable();
//            static JScrollPane scrollpane = new JScrollPane(tableResults);
            
//            scrollpane.setPreferredSize(new Dimension(500,200));
//            scrollpane.setSize(new Dimension(500,1000));
            //tableResults.setPreferredScrollableViewportSize(new Dimension(200, 200));
            
     String[][] data = new String[20][3];   
          
    public JTable tableResults = new JTable();
    
    
        public void setUp(){
            for (int i =0; i<20; i++){
                        data [i][0] = MainClass.getTripplePoints()[i].getFullName();
                        data[i][1] = Integer.toString(MainClass.getTripplePoints()[i].getFe2Amount());
                        data[i][2] = Integer.toString(MainClass.getTripplePoints()[i].getFe3Amount());
                
                    }
            String[] columnNames = {"Name", "Fe\u00B2\u207A", "Fe\u00B3\u207A"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames){
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }};
            tableResults.setModel(model);
            tableResults.setColumnSelectionAllowed(true);
            tableResults.getColumnModel().getColumn(0).setMinWidth(100);
            
            for (int j = 0; j<3; j++){
                for (int i=0; i<20; i++) {
                   model.isCellEditable(i, j);
                }
            };
            
            tableResults.setModel(model);
            tableResults.revalidate();
        }
        
        PanelResults(){           
            setUp();
            setBorder(BorderFactory.createLoweredBevelBorder());
            Font font = new Font("Times New Roman", Font.BOLD, 18);
//            setBackground(Color.GRAY);
            
            JLabel text = new JLabel();
            text.setFont(font);
            text.setText("Modelling results");
            add(text);
            tableResults.setFont(new Font( "SansSerif", Font.PLAIN, 14 ));
            tableResults.setRowHeight(tableResults.getRowHeight()+2);
            String[] columnNames = {"Name", "Fe\u00B2\u207A", "Fe\u00B3\u207A"};
            tableResults.setPreferredScrollableViewportSize(new Dimension(190, 360));
            //tableResults.setBackground(Color.LIGHT_GRAY);
            JScrollPane scrollpane = new JScrollPane(tableResults);
            scrollpane.setBackground(Color.LIGHT_GRAY);
            add(scrollpane, BorderLayout.CENTER);
            DefaultTableModel model = new DefaultTableModel(data, columnNames){
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return false;
                }
            };
            
            for (int j = 0; j<3; j++){
                for (int i=0; i<20; i++) {
                   model.isCellEditable(i, j);
                }
            }
            
                    
            tableResults.setModel(model);
            tableResults.setColumnSelectionAllowed(true);
            tableResults.getColumnModel().getColumn(0).setMinWidth(100);
            tableResults.revalidate();
    };

    
}
