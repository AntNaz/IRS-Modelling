/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Containers;

import java.awt.Color;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import main.MainClass;

/**
 *
 * @author Anton
 */

public class PanelResults extends JPanel{
            
     String[][] data = new String[20][3];   
          
    private JTable tableResults = new JTable();
    private JPopupMenu popup = new JPopupMenu();
    private JMenuItem copyItem = new JMenuItem("Копировать");
    
    public JTable getTableResults(){
        return tableResults;
    }
        public void setUp(){
            for (int i =0; i<20; i++){
                        data [i][0] = MainClass.getTripplePoints()[i].getFullName();
                        data[i][1] = Double.toString(MainClass.getTripplePoints()[i].getFe2Amount());
                        data[i][2] = Double.toString(MainClass.getTripplePoints()[i].getFe3Amount());
                
                    }
            String[] columnNames = {"Окружение", "Fe\u00B2\u207A", "Fe\u00B3\u207A"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }};
            tableResults.setModel(model);
            tableResults.setColumnSelectionAllowed(true);
            tableResults.getColumnModel().getColumn(0).setMinWidth(100);
            tableResults.getTableHeader().setReorderingAllowed(false);
            
            for (int j = 0; j<3; j++){
                for (int i=0; i<20; i++) {
                   model.isCellEditable(i, j);
                }
            }
            
            tableResults.setModel(model);
            tableResults.revalidate();
        }
        
        PanelResults(){           
            setUp();
            setBorder(BorderFactory.createLoweredBevelBorder());
            Font font = new Font("Times New Roman", Font.BOLD, 14);
//            setBackground(Color.GRAY);
            
            JLabel text = new JLabel();
            text.setFont(font);
            text.setText("Результаты моделирования");
            add(text);
            tableResults.setFont(new Font( "SansSerif", Font.PLAIN, 14 ));
            tableResults.setRowHeight(tableResults.getRowHeight()+2);
            String[] columnNames = {"Окружение", "Fe\u00B2\u207A", "Fe\u00B3\u207A"};
            tableResults.setPreferredScrollableViewportSize(new Dimension(210, 360));
            //tableResults.setBackground(Color.LIGHT_GRAY);
            JScrollPane scrollpane = new JScrollPane(tableResults);
            scrollpane.setBackground(Color.LIGHT_GRAY);
            add(scrollpane, BorderLayout.CENTER);
            DefaultTableModel model = new DefaultTableModel(data, columnNames){
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex){
                    return false;
                }
            };
            
            for (int j = 0; j<3; j++){
                for (int i=0; i<20; i++) {
                   model.isCellEditable(i, j);
                }
            }
            popup.add(copyItem);
            
            copyItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    int[] rows = tableResults.getSelectedRows();
//                    int[] cols = tableResults.getSelectedColumns();
                    String textToCopy = tableResults.getColumnName(0) + "\t" + tableResults.getColumnName(1) + "\t" + tableResults.getColumnName(2) + "\n";
                    
                    for (int i = 0; i<20; i++) {
                        for (int j = 0; j<3; j++){
                            textToCopy = textToCopy + tableResults.getValueAt(i, j).toString().replace(".", ",");
                            if (j!=2) textToCopy = textToCopy + "\t";
                        }
                        textToCopy = textToCopy + "\n";
                    }
                    StringSelection stringSelection = new StringSelection(textToCopy);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                }
            });
            tableResults.add(popup);
            tableResults.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    showPopup(e);
                }
                public void mouseReleased(MouseEvent e) {
                  showPopup(e);
                }
                private void showPopup(MouseEvent e) {
                    
                  if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                  }
                }
});
                    
                    
            tableResults.setModel(model);
            tableResults.setColumnSelectionAllowed(true);
            tableResults.getColumnModel().getColumn(0).setMinWidth(100);
            tableResults.revalidate();
    };

    
}
