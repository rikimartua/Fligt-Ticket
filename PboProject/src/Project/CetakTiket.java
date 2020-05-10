
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author TOSHIBA
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CetakTiket extends JFrame {
    
   ModelData modelData = new ModelData();
   JLabel lid = new JLabel("ID ");
   JLabel lnama_Pesawat;
   JLabel ltanggal1;
   JLabel lno_Pesawat;
   JLabel lberangkat1;
   JLabel lAsal1;
   JLabel lTiba1;
   JLabel ltiba1;
   JLabel lid1;
   JLabel lnama1;
   JLabel lalamat1;
   JLabel ltelepon1;
   JLabel lemail1;
   JLabel lharga1;
//   JLabel kelas;
   JLabel lNama = new JLabel("Nama ");
   JLabel lAlamat = new JLabel("Alamat ");
   JLabel lTelepon = new JLabel("Telepon ");
   JLabel lEmail = new JLabel("Email ");
   JLabel lTanggal = new JLabel("TANGGAL");
   JLabel lNo_Pesawat = new JLabel("NO PESAWAT");
   JLabel lNama_Pesawat = new JLabel("MASKAPAI");
   JLabel lBerangkat = new JLabel("BERANGKAT ");
   JLabel lTiba = new JLabel("TIBA ");
   JLabel lJudul = new JLabel("BUKTI PEMBAYARAN TIKET PESAWAT ");
   JLabel lJudul1 = new JLabel("Detil Pemesanan ");
   JLabel lJudul2 = new JLabel("Detil Perjalanan ");
   JLabel lAsal = new JLabel("Berangkat ");
   JLabel lTujuan = new JLabel("Tiba");
   JLabel lHarga = new JLabel("TARIF");
   JLabel lGambar;
   JLabel lJarak;
   JButton btnKembali = new JButton("");
   private Image image;
   
   String DBurl = "jdbc:mysql://localhost/data1";
  String DBusername = "root";
  String DBpassword = "";  
  Connection con;
  Statement stat;
  ResultSet rs;
  String sql;
  String ID;
 
   public CetakTiket() {
    Koneksi DB = new Koneksi();
    DB.config();
    con = DB.conn;
    stat = DB.stm;
       
	setTitle("Pembelian Tiket Pesawat");
	setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/pes.jpg")));
        lJarak = new JLabel (new ImageIcon (getClass().getResource("image/jarak.png")));
        btnKembali = new JButton (new ImageIcon(getClass(). getResource("image/kembali.jpg")));
        lid1 = new JLabel ("");
        lnama1 = new JLabel ("");
        lalamat1 = new JLabel ("Yogyakarta");
        ltelepon1 = new JLabel ("");
        lemail1 = new JLabel ("");
        ltanggal1 = new JLabel ("");
        lnama_Pesawat = new JLabel ("");
        lno_Pesawat = new JLabel ("");
        lberangkat1 = new JLabel ("");
        ltiba1 = new JLabel ("");
        lTiba1 = new JLabel ("");
        lAsal1 = new JLabel ("");
        lharga1 = new JLabel ("");
	setSize(750,300);
        try
        {
            sql = "select * from tiket";
            rs = stat.executeQuery(sql);
            while(rs.next()){
               lnama1.setText(rs.getString("Nama"));
               lid1.setText(rs.getString("ID"));
               ltelepon1.setText(rs.getString("Telepon"));
               lemail1.setText(rs.getString("Email"));
            }
            sql = "select * from perjalanan";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                lTiba1.setText(rs.getString("tujuan"));
                lAsal1.setText(rs.getString("asal"));
               ltanggal1.setText(rs.getString("tanggal"));
               lharga1.setText(rs.getString("Harga"));
              
            }
            sql = "select * from jadwal";
            rs = stat.executeQuery(sql);
            while(rs.next()){
               lno_Pesawat.setText(rs.getString("No_Pesawat"));
               lnama_Pesawat.setText(rs.getString("Nama_Maskapai"));
               lberangkat1.setText(rs.getString("Berangkat"));
               ltiba1.setText(rs.getString("Tiba"));
               
            }
            
        }
        catch(SQLException s)
        {
            
        }
       
	setLayout(null);
        add(lJudul);
        add(lJudul1);
        add(lJudul2);
	add(lNama);
	add(lnama1);
        add(lAlamat);
	add(lalamat1);
        add(lTelepon);
	add(ltelepon1);
        add(lEmail);
	add(lemail1);
        add(lTanggal);
	add(ltanggal1);
        add(lid);
	add(lid1);
        add(lNo_Pesawat);
	add(lno_Pesawat);
        add(lNama_Pesawat);
	add(lnama_Pesawat);
        add(lBerangkat);
	add(lberangkat1);
        add(lTiba);
	add(ltiba1);
        add(lAsal);
	add(lAsal1);
        add(lTujuan);
	add(lTiba1);
        add(btnKembali);
        add(lJarak);
        add(lHarga);
        add(lharga1);
        add(lGambar);

        lJudul.setFont(new java.awt.Font("Couture", Font.ITALIC, 24));
        lJudul1.setFont(new java.awt.Font("Couture", Font.ITALIC, 12));
        lJudul2.setFont(new java.awt.Font("Couture", Font.ITALIC, 12));
        lTiba1.setFont(new java.awt.Font("Couture", Font.ITALIC, 12));
        lAsal1.setFont(new java.awt.Font("Couture", Font.ITALIC, 12));
        lJudul.setForeground(Color.orange);
        lTiba1.setForeground(Color.orange);
        lAsal1.setForeground(Color.orange);
        lJudul1.setForeground(Color.black);
        lJudul2.setForeground(Color.black);
	lJudul.setBounds(70,0,600,40);
        lJudul1.setBounds(70,20,500,40);
        lid.setBounds(310,50,100,20);
        lid1.setBounds(380,50,200,20);
        lNama.setBounds(310,70,100,20);
        lnama1.setBounds(380,70,200,20);
        lAlamat.setBounds(310,90,100,20);
        lalamat1.setBounds(380,90,200,20);
        lTelepon.setBounds(310,110,100,20);
        ltelepon1.setBounds(380,130,200,20);
        lEmail.setBounds(310,130,100,20);
	lemail1.setBounds(380,110,200,20);
        
        lJudul2.setBounds(70,170,500,20);
        lTanggal.setBounds(70,190,100,20);
	ltanggal1.setBounds(70,210,100,20);
        lNo_Pesawat.setBounds(180,190,100,20);
	lno_Pesawat.setBounds(180,210,100,20);
        lNama_Pesawat.setBounds(290,190,100,20);
	lnama_Pesawat.setBounds(290,210,100,20);
        lBerangkat.setBounds(400,190,100,20);
	lberangkat1.setBounds(400,210,100,20);
        lTiba.setBounds(510,190,100,20);
        lHarga.setBounds(580,190,100,20);
        lharga1.setBounds(580,210,100,20);
	ltiba1.setBounds(510,210,100,20);
        lAsal.setBounds(140,55,100,20);
	lAsal1.setBounds(140,70,100,20);
        lTujuan.setBounds(140,130,100,20);
	lTiba1.setBounds(140,145,80,20);
        btnKembali.setBounds(10,200,50,50);
        lGambar.setBounds(0,0,750,300);
        lJarak.setBounds(70,55,75,110);
	setVisible(true);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Menu m = new Menu(); //To change body of generated methods, choose Tools | Templates.
            }
        });
   }
public static void main(String[] args) {
        new CetakTiket();
    }
}
