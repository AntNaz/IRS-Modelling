
package Containers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.MainClass;

/**
 *
 * @author Anton
 */
public class MainWindow extends JFrame {
    private int width = 1000;
    
    private int heigh = 500;
    
    private JPanel results = new JPanel();
    private static DrawPanel graphics = new DrawPanel();
    private JPanel info = new DrawInfo();
    public static JScrollPane scrollGraph = new JScrollPane(graphics);
    public static PanelResults panelResults = new PanelResults();
    
    
    public MainWindow() {
        setSize(width, heigh);
        setVisible(true);
        setTitle("IRS-Modelling");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 400));        
        LayoutManager layout = new BorderLayout();
        setLayout(layout);
        
        
        // -------------------MenuBar-----------------------------
        createMenu();
        //========================================================
        
        
        
        
        
        // -------------------GraphicPanel------------------------
        
        info.setBorder(BorderFactory.createLoweredBevelBorder());
        info.setPreferredSize(new Dimension(width, 70));
        
        createGraphicPanel();
        
        //========================================================
        
        //----------------------PanelInput------------------------
//        JPanel panelLeft = new JPanel();
//        panelLeft.setLayout(new BorderLayout());
//        panelLeft.setPreferredSize(new Dimension(240, heigh));
//        add(panelLeft, BorderLayout.WEST);
//        ScrollPane scrollInput = new ScrollPane();
//        scrollInput.setPreferredSize(new Dimension(220, heigh));
        PanelInput panelInput = new PanelInput(heigh);
//        panelLeft.add(scrollInput);
//        scrollInput.add(panelInput);
        this.add(panelInput, BorderLayout.WEST);
//        //========================================================
        
        //---------------------------------------------------------

//        JPanel info = new JPanel();
//        add(info, BorderLayout.SOUTH);
//        info.setPreferredSize(new Dimension(width-200, 50));
        //-----------------------------------------------------------
        
        
        
        
//        JPanel panelResults = new PanelResults();
//        JTable tableResults = new JTable();
        JScrollPane scrollRes = new JScrollPane(panelResults);
        //scrollRes.setHorizontalScrollBarPolicy();
//        String[] columnNames = {"name", "Fe2", "Fe3"};
//        String[] names = new String[20];
//        String[][] data = new String[20][3];
        //JPanel panelResults = new PanelResults();
        panelResults.setBackground(Color.LIGHT_GRAY);
        add(scrollRes, BorderLayout.EAST);
//        panelResults.add(scrollpane);
        panelResults.setPreferredSize(new Dimension(200, 400));
        panelResults.setBorder(BorderFactory.createLoweredBevelBorder());
        
//        for (int i =0; i<20; i++){
//                data [i][0] = MainClass.getTripplePoints()[i].getFullName();
//                data[i][1] = Integer.toString(MainClass.getTripplePoints()[i].getFe2Amount());
//                data[i][2] = Integer.toString(MainClass.getTripplePoints()[i].getFe3Amount());
//                
//            }
//        
//        panelResults.add(scrollpane);
        
        
//         JLabel text = new JLabel();
//            text.setText("dsjfajfkldasjf");
//            right.add(text);
        
        //------------------------------------------------------------
        PanelResults result = new PanelResults();
        result.setPreferredSize(new Dimension(width, 100));
        //add(result,BorderLayout.SOUTH);
    }
    
    public void createGraphicPanel(){
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        graphics.setLayout(new GridBagLayout());
        add(centerPanel, BorderLayout.CENTER);
        
        SwingUtilities.invokeLater( () -> {
        scrollGraph.setWheelScrollingEnabled(false);  
        });
        centerPanel.add(scrollGraph, BorderLayout.CENTER);
        centerPanel.add(info, BorderLayout.SOUTH);
        //graphics.setBorder(BorderFactory.createLoweredBevelBorder());
        
    }
//    public void setTable(String[][] data, String[] names){
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
//        tableResults.setModel(model);
//        tableResults.revalidate();
//        panelResults.revalidate();
//        panelResults.repaint();
//    }

    public void createMenu() {
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            //menuBar.setPreferredSize(new Dimension(width, 30));
            JMenu menuFile = new JMenu("File");
            JMenu view = new JMenu("View");
            JMenu help = new JMenu("About");
            menuBar.add(menuFile);
            menuBar.add(view);
            menuBar.add(help);


            JMenuItem fileItem = new JMenuItem("Save as");
            JMenuItem fileExit = new JMenuItem("Exit");
            menuFile.add(fileItem);
            menuFile.addSeparator();
            menuFile.add(fileExit);
            
            fileExit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals("Exit")) {
                        System.exit(0);
                    }
                }
            });
        }
}

