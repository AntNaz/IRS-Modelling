
package Containers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.*;
import main.MainClass;
import main.SVGWriter;

/**
 *
 * @author Anton
 */
public class MainWindow extends JFrame {
    private int width = 1000;
    
    private int heigh = 480;
    
    private JPanel results = new JPanel();
    private static DrawPanel graphics = new DrawPanel();
    private static JPanel info = new DrawInfo();
    private static JScrollPane scrollGraph = new JScrollPane(graphics);
    private static PanelResults panelResults = new PanelResults();
    
    public static PanelResults getPanelResults(){
        return panelResults;
    }
    public static JPanel getInfo(){
        return info;
    }
    public static JScrollPane getScrollGraph(){
        return scrollGraph;
    }
    
    public MainWindow() {
        setSize(width, heigh);
        this.setLocationByPlatform(true);
        setVisible(true);
        setTitle("IRS-Modelling");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 480));        
        LayoutManager layout = new BorderLayout();
        setLayout(layout);
        
        
        // -------------------MenuBar-----------------------------
        createMenu();
        //========================================================
        
        
        
        
        
        // -------------------GraphicPanel------------------------
        
        info.setBorder(BorderFactory.createLoweredBevelBorder());
        info.setPreferredSize(new Dimension(width, 90));
        
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
        panelResults.setPreferredSize(new Dimension(220, 400));
        //panelResults.setBorder(BorderFactory.createLoweredBevelBorder());
        
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
    
    public void createMenu() {
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            //menuBar.setPreferredSize(new Dimension(width, 30));
            JMenu menuFile = new JMenu("Файл");
            menuFile.setMnemonic(KeyEvent.VK_F);
            //menuFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
            //JMenu view = new JMenu("View");
            //JMenuItem help = new JMenuItem("Help",KeyEvent.VK_H);
            menuBar.add(menuFile);
            //menuBar.add(view);
            //menuBar.add(help);


            JMenuItem fileItem = new JMenuItem("Сохранить изображение");
            fileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
            JMenuItem copyItem = new JMenuItem("Копировать таблицу");
            copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
            JMenuItem fileExit = new JMenuItem("Выход");
            fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            menuFile.add(fileItem);
            menuFile.add(copyItem);
            menuFile.addSeparator();
            menuFile.add(fileExit);
            
//            help.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JOptionPane.showMessageDialog(null, "Press \"Ctrl+C\" to copy data from table.\nPress \"Ctrl+V\" to paste data to Excel.");
//                }
//            });
            
            fileExit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().equals("Выход")) {
                        System.exit(0);
                    }
                }
            });
            fileItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(MainClass.getMatrix()[0][0] != null){
                            SVGWriter.writeSVG();
                            JOptionPane.showMessageDialog(null, "Изображение сохранено.","Сообщение", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else JOptionPane.showMessageDialog(null, "Модель не построена.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        System.out.println("error");
                    }
                }
            });
            copyItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String textToCopy = panelResults.getTableResults().getColumnName(0) + "\t" + panelResults.getTableResults().getColumnName(1) + "\t" + panelResults.getTableResults().getColumnName(2) + "\n";
                    
                    for (int i = 0; i<20; i++) {
                        for (int j = 0; j<3; j++){
                            textToCopy = textToCopy + panelResults.getTableResults().getValueAt(i, j).toString().replace(".", ","); 
                            if (j!=2) textToCopy = textToCopy + "\t";
                        }
                        textToCopy = textToCopy + "\n";
                    }
                    StringSelection stringSelection = new StringSelection(textToCopy);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);
                }
            });
            
        }
}

