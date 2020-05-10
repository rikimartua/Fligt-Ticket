/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author RIKI MARTUA
 */
public class GetStart extends JFrame implements ActionListener{
   JLabel lGambar;
   JButton btnStart = new JButton("");

   public GetStart() {
	setTitle("Pembelian Tiket Kereta Api");
	setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/BackgroundPesawat.png")));
            btnStart = new JButton (new ImageIcon (getClass().getResource("image/start.png")));
	setSize(996,447);
	setLayout(null);
	add(btnStart);
        add(lGambar);
	btnStart.setBounds(719,270,180,70);
        lGambar.setBounds(0,0,996,447);
         btnStart.addActionListener(this);
	setVisible(true);
         btnStart.addActionListener(new ActionListener() {
              @Override
             public void actionPerformed(ActionEvent ae) {
                   setVisible(false);
               ViewLogin l = new ViewLogin();//To change body of generated methods, choose Tools | Templates.
                 setVisible (true);
            }
      });
        
   }
public static void main(String[] args) {
        new GetStart();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        if (ae.getSource() == btnStart) {
            setVisible(false);
        }
    }

 
}

