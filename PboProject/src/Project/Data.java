/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author RIKI MARTUA
 */
public final class Data extends JFrame{
    
  String DBurl = "jdbc:mysql://localhost/data1";
  String DBusername = "root";
  String DBpassword = "";  
  Connection con;
  Statement stat;
  ResultSet rs;
  String sql;
  String kelas;
  JTextField fsisa = new JTextField(10);
  JTextField fharga = new JTextField(10);
  JLabel Tanggal = new JLabel("Tanggal ");
   String[] tanggal =
            {"-Pilih Tanggal-","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",};
   JComboBox Cbtanggal = new JComboBox(tanggal);
   JLabel Bulan = new JLabel("Bulan ");
   String[] bulan =
            {"-Pilih Bulan-"," Januari "," Februari "," Maret "," April "," Mei "," Juni "," Juli "," Agustus "," September "," Oktober "," November "," Desember ",};
   JComboBox Cbbulan = new JComboBox(bulan);
   JLabel Tahun=new JLabel("Tahun");
   String[] tahun=
            {"-Pilih Tahun-","2020","2021",};
    JComboBox CbTahun=new JComboBox(tahun);
    JLabel harga=new JLabel("Harga");
    JLabel harga1;
    JLabel Judul = new JLabel(" PEMESANAN TIKET PESAWAT");
    JLabel lGambar;
    JRadioButton rb1 = new JRadioButton("Business ");
   JRadioButton rb2 = new JRadioButton("Economy ");
   JLabel lasal = new JLabel("DARI");
//   String[] namaasal =
//            {"Yogyakarta"};
   JComboBox cmbasal = new JComboBox();
   JLabel ltujuan = new JLabel("TUJUAN");
//   String[] namatujuan =
//            {"-Pilih Tujuan-","Jakarta","Bandung","Malang","Surabaya",};
    JComboBox cmbtujuan = new JComboBox();
   

   JLabel lKelas = new JLabel("Kelas");
   JButton btnBeli = new JButton("Beli");
   JButton btnKembali = new JButton("");
   ControllerData controllerData;
    ModelData modelData;
    private Image image;
    
    public Data(){
       harga1 = new JLabel ("");
      
       Cbtanggal.getSelectedItem();
       Cbbulan.getSelectedItem();
       CbTahun.getSelectedItem();
       
       
        setTitle("Pemesanan Tiket Pesawat");
        setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/pes.jpg")));
        btnKembali = new JButton (new ImageIcon(getClass(). getResource("image/kembali.jpg")));
	setSize(750,300); 
         
          
        ButtonGroup group=new ButtonGroup();
        group.add(rb1);
        group.add(rb2); 

        
        setLayout(null);
        add(Judul);
	add(harga1);
        add(harga);
        add(Tanggal);
        add(Cbtanggal);
        add(Bulan);
        add(Cbbulan);
        add(Tahun);
        add(CbTahun);
	add(lKelas);
	add(rb1);
	add(rb2);
	add(lasal);
	add(cmbasal);
        add(ltujuan);
	add(cmbtujuan);
	add(btnBeli);
        add(btnKembali);
        add(lGambar);
	
        Judul.setFont(new java.awt.Font("Couture", 2, 24));
        Judul.setForeground(Color.orange);
	Judul.setBounds(170,2,420,40);
        harga.setBounds(310,190,120,20);
	harga1.setBounds(430,190,120,20);
        Cbtanggal.setBounds(310,160,120,20);
        Tanggal.setBounds(310,140,80,20);
        Cbbulan.setBounds(445,160,120,20);
        Bulan.setBounds(445,140,120,20);
        CbTahun.setBounds(580,160,120,20);
        Tahun.setBounds(580,140,120,20);
	fharga.setBounds(580,190,100,20);
	lasal.setBounds(310,70,120,20);
	cmbasal.setBounds(430,70,150,20);
        ltujuan.setBounds(310,90,150,20);
	cmbtujuan.setBounds(430,90,150,20);
	lKelas.setBounds(310,115,120,20);
	rb1.setBounds(430,115,100,20);
	rb2.setBounds(560,115,90,20);
	btnBeli.setBounds(400,220,120,20);
        btnKembali.setBounds(10,200,50,50);
        lGambar.setBounds(0,0,800,300);
        
        setVisible(true);     
        tampil_combo(); 
        combo_berangkat();
      
        //Radio Button kelas Pesawat
        if(rb1.isSelected()){
            rb1.getText();
        }
        else if(rb2.isSelected())
        {
            kelas=rb2.getText();
        }
        rb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

           
            }
        });
        rb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
            }
        });
         btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                masukkanData();
                ViewData input = new ViewData(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Menu m = new Menu(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        cmbtujuan.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
            
               tampilin();
            }
       });
       
    }
     public void masukkanData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            stat = con.createStatement();
            stat.executeUpdate("insert into perjalanan values('"+ cmbasal.getSelectedItem().toString() + "','" + cmbtujuan.getSelectedItem().toString() + "','" + kelas + "','" + Cbtanggal.getSelectedItem()+Cbbulan.getSelectedItem()+CbTahun.getSelectedItem() + "','" + harga1.getText() + "')");
            JOptionPane.showMessageDialog(null, "Data BerhasilDisimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            stat.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

public static void main(String[] args) {
        new Data();
    }
public void tampil_combo(){
    
    try {
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.conn;
        stat = DB.stm;
        stat= con.createStatement();
        String sql = "select * from jadwal order by Tiba asc";      // disini saya menampilkan NIM, anda dapat menampilkan
        rs= stat.executeQuery(sql); 
        
        while(rs.next()){
          
            cmbtujuan.addItem(rs.getString("Tiba"));
            
           // fungsi ini bertugas menampung isi dari database
        }
        rs.close(); stat.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
}
public void combo_berangkat(){
    
    try {
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.conn;
        stat = DB.stm;
        stat= con.createStatement();
        String sql = "select * from jadwal order by Berangkat asc";      // disini saya menampilkan NIM, anda dapat menampilkan
        rs= stat.executeQuery(sql); 
        
        while(rs.next()){
          
            cmbasal.addItem(rs.getString("Berangkat"));
            
           // fungsi ini bertugas menampung isi dari database
        }
        rs.close(); stat.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
}
public void tampilin(){
      try {
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.conn;
        stat = DB.stm;
        stat= con.createStatement();
        String sql = "select Harga from Jadwal where Tiba='"+cmbtujuan.getSelectedItem()+"'";      
        rs= stat.executeQuery(sql); 
        
        while(rs.next()){
          
            Object[] ob = new Object[1];
            ob[0]=  rs.getString(1);                     
            harga1.setText((String) ob[0]);

           // fungsi ini bertugas menampung isi dari database
          
        }
        rs.close(); stat.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

    
   

    
}
