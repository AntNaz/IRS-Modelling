/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Containers;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.*;
import main.MainClass;

/**
 *
 * @author Anton
 */
public class PanelInput extends JPanel {
        private int height = 800;
        private JButton startButton = new JButton("Start");
        private JButton buttonReset = new JButton("reset");
        PanelInput() {
            
        }
        
        PanelInput(int height) {
            setPreferredSize(new Dimension(200, height - 100));
            setBackground(Color.LIGHT_GRAY);
            setBorder(BorderFactory.createLoweredBevelBorder());
            setLayout(new FlowLayout());
            JLabel label1 = new JLabel("IRS-data:");
            label1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
            label1.setPreferredSize(new Dimension(190, 40));
            label1.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
            this.add(label1);
            JPanel doublePanel = new JPanel();
            doublePanel.setLayout(new GridLayout(12, 2, 5, 5));
            doublePanel.setPreferredSize(new Dimension(190,350));
            doublePanel.setBackground(Color.LIGHT_GRAY);
            doublePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        
            add(doublePanel);
            
            
            //text4.setEnabled(false);
            
            JLabel[]labels = new JLabel[10];
            JTextField[] textFields = new JTextField[10];
            
            for (int n = 0; n<10; n++){
                labels[n] = new JLabel();
                labels[n].setText(MainClass.getPoints()[n].getName());
                labels[n].setHorizontalAlignment(SwingConstants.LEFT);
                labels[n].setFont(new Font("Times_New_Roman", Font.BOLD, 14));
                textFields[n] = new JTextField("0");
                textFields[n].addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                ((JTextField)e.getSource()).selectAll();
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                
                
                textFields[n].setHorizontalAlignment(JTextField.RIGHT);
                doublePanel.add(labels[n]);
                doublePanel.add(textFields[n]);
            }
            JLabel labelIter = new JLabel("Iterations");
            labelIter.setFont(new Font("Times_New_Roman", Font.BOLD, 14));
            doublePanel.add(labelIter);
            JTextField textIter = new JTextField();
            textIter.setText("1");
            textIter.setHorizontalAlignment(JTextField.RIGHT);
            textIter.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                ((JTextField)e.getSource()).selectAll();
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
            doublePanel.add(textIter);
            doublePanel.add(startButton);
            doublePanel.add(buttonReset);
            
            startButton.addKeyListener(
                new KeyAdapter() {
                   public void keyPressed(KeyEvent e) {
                     if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                       startButton.doClick();
                     }
                   }
                });
            buttonReset.addKeyListener(
                new KeyAdapter() {
                   public void keyPressed(KeyEvent e) {
                     if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                       buttonReset.doClick();
                       textFields[0].requestFocus();
                     }
                   }
                });

            startButton.addActionListener(new ActionListener() {
                int summ = 0;
                
                //BigDecimal sumBuf;
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean positive = true;
                    MainClass.setZeroAmounts();
                    //MainClass.setIter(1);
                    
                    System.out.println("\nButton was pressed!");
                    try {
                        for (int n = 0; n<10; n++){
                            textFields[n].setText(textFields[n].getText().replace(" ", ""));
                            textFields[n].setText(textFields[n].getText().replace(",", "."));
                            if (textFields[n].getText().trim().equals("")) textFields[n].setText("0");
                            BigDecimal bd = new BigDecimal((textFields[n].getText().replace(",", ".")));
                            MainClass.getPoints()[n].setAmount((int)(((bd).setScale(10,(BigDecimal.ROUND_HALF_UP)).doubleValue()*10))); //bd.setScale(5,BigDecimal.ROUND_HALF_DOWN).intValue()*570;
                            //DevApp.getPoints()[n].setAmount((int)(Double.parseDouble(textFields[n].getText()))*10);
                            
                            //DevApp.getPoints()[n].setAmount(new BigDecimal(Double.parseDouble(textFields[n].getText())).intValueExact()*570);
                            if (MainClass.getPoints()[n].getAmount() >= 0) positive = true;
                            else {
                                positive = false; 
                                break;
                            }
                            summ = summ + MainClass.getPoints()[n].getAmount();
                            //System.out.println(MainClass.getPoints()[n].getAmount());
                            //DevApp.getPoints()[n].setAmount(80);
                        }
                        int iter = Integer.parseInt(textIter.getText());
                        MainClass.setIter(iter);
                        //summ = (summ);
                        if (summ ==1000 && positive && iter >0 && iter <=10000) {
                            MainClass.buildElements();
                            MainWindow.getPanelResults().setUp();
//                            MainClass.getFrame().
                            for (int n = 0; n<10; n++){
                                textFields[n].setEditable(false);
                            }
                            //textIter.setEditable(false);
                        }
                        else 
                        {
                            if (positive || iter <=0 || iter>10000) JOptionPane.showMessageDialog(null, "Проверьте правильность ввода значений!", "Error", JOptionPane.ERROR_MESSAGE);
                            else JOptionPane.showMessageDialog(null, "Числа не могут быть отрицательными!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Неверный формат данных!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    summ = 0;
                    MainWindow.getInfo().revalidate();
                    MainWindow.getInfo().repaint();
                     //DrawPanel.setK();
                    
                }
            });
            buttonReset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    for (int i = 0; i < MainClass.getX(); i++) {
                        for (int j = 0; j<MainClass.getY()*2; j++) { 
                            MainClass.getMatrix()[i][j] = null;
                            MainClass.setIter(1);
                            textIter.setText("1");
                        }
                    }
                    for (int n = 0; n<10; n++){
                        textFields[n].setText("0");
                        textFields[n].setEditable(true);
                     }
                    textIter.setEditable(true);
                    DrawPanel.setK();
                    DrawPanel.setZeroPosition();
                    
                    for (int i = 0; i<20; i++) {
                        MainClass.getTripplePoints()[i].setAmountsZero();
                    }
                    MainWindow.getPanelResults().setUp();
                    MainClass.setZeroAmounts();
                    MainWindow.getInfo().revalidate();
                    MainWindow.getInfo().repaint();
                    
                }
            });
            
        }
}
