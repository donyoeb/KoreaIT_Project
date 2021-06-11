package order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReceiptPanel extends JPanel{
   JLabel laName;
   JLabel laCnt;
   JLabel laPrice;
   
   public ReceiptPanel(String name, String cnt, String price) {
      laName = new JLabel(name);
      laCnt = new JLabel(cnt);
      laPrice = new JLabel(price+" 원");
      
      
      laName.setPreferredSize(new Dimension(100, 30));
      laName.setHorizontalAlignment(JLabel.LEFT);
      //laName.setBorder(new EmptyBorder(0, 0, 0, 0));
      laName.setBackground(Color.BLUE);
      
      laCnt.setPreferredSize(new Dimension(60, 30));
      laCnt.setHorizontalAlignment(JLabel.CENTER);
      //laCnt.setBorder(new EmptyBorder(0, 0, 0, 0));
      
      laPrice.setPreferredSize(new Dimension(70, 30));
      laPrice.setHorizontalAlignment(JLabel.RIGHT);
      //laPrice.setBorder(new EmptyBorder(0, 0, 0, 0));
      
      setVisible(true);
      //setBorder(new EmptyBorder(0, 0, 0, 0));
      setPreferredSize(new Dimension(300, 30));
      setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
      
      add(laName, BorderLayout.WEST);
      add(laCnt, BorderLayout.CENTER);
      add(laPrice, BorderLayout.EAST);
      
      
      
   }
}