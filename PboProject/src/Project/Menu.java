
package Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*; 
import javax.swing.ImageIcon;

public class Menu extends JFrame {
    
   
     String DBurl = "jdbc:mysql://localhost/data1";
     String DBusername = "root";
     String DBpassword = "";  
     Connection con;
     Statement stm;
     ResultSet rs;
     String sql;
     
    
   ModelLogin modelLogin=new ModelLogin();
   JLabel lJudul = new JLabel(" PEMESANAN TIKET PESAWAT");
   JLabel lGambar;
   JLabel Username1=new JLabel("");

   JLabel lPesan = new JLabel("Pesan Tiket");
   JLabel lJadwal = new JLabel("Jadwal Pesawat");
   JLabel lRiwayat = new JLabel("Riwayat Perjalanan");

   JButton btnPesan = new JButton("");
   JButton btnJadwal = new JButton("");
   JButton btnRiwayat = new JButton("");
   
   

   public Menu() {
        Koneksi DB = new Koneksi();
        DB.config();
        this.con = DB.conn;
        this.stm = DB.stm;
        
	setTitle("Pembelian Tiket Kereta Api");
	setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/pesawat.jpg")));
        btnPesan = new JButton (new ImageIcon (getClass().getResource("image/iconk.jpg")));
        btnJadwal = new JButton (new ImageIcon (getClass().getResource("image/icon1.jpg")));
        btnRiwayat = new JButton (new ImageIcon (getClass().getResource("image/icona.png")));
	setSize(750,300);
      
      
	setLayout(null);
        add (lJudul);
	add(lPesan);
        add(lJadwal);
        add(lRiwayat);
	add(btnPesan);
        add(btnJadwal);
        add(btnRiwayat);
        add(Username1);
        add(lGambar);
        
        lJudul.setFont(new java.awt.Font("Couture", 2, 27));
        lJudul.setForeground(Color.orange);
        
        lPesan.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lJadwal.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        Username1.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
        lRiwayat.setFont(new java.awt.Font("Futura Bk Bt", 2, 15));
	lJudul.setBounds(130,2,480,40);
	lPesan.setBounds(90,220,120,20);
        lJadwal.setBounds(290,220,160,20);
        lRiwayat.setBounds(500,220,150,20);
	btnPesan.setBounds(100,170,50,50);
        btnJadwal.setBounds(330,170,50,50);
        btnRiwayat.setBounds(550,170,50,50);
        Username1.setBounds(50,50,250,20);
        lGambar.setBounds(0,0,750,300);
        
	setVisible(true);
        btnPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Data();
            }
        });
        btnJadwal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new LihatJadwal();
            }
        });
        btnRiwayat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new RiwayatPerjalanan();
            }
        });
   }
public static void main(String[] args) {
        new Menu();
    }

   
}
