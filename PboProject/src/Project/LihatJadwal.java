
package Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LihatJadwal extends JFrame {

      String[][] data = new String[500][6];
    String[] kolom = {"No Pesawat", "Maskapai", "Kelas", "Tujuan", "Berangkat", "Tiba"};
    JTable tabel;
    JScrollPane scrollPane;
    JButton btnBack,btnDelete;
    JPanel panelTombol;
    String DBurl = "jdbc:mysql://localhost/data1";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;           
    ResultSet resultSet;
    JLabel lGambar;

    public LihatJadwal() {
        setTitle("Jadwal Pesawat");
        setSize(750, 300);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/jadwal.png")));
        setLayout(null);
        add(lGambar);
        lGambar.setBounds(0, 0, 500, 300);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,
                      DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from jadwal "; 
            resultSet = statement.executeQuery(sql); 
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("No_Pesawat");
                data[p][1] = resultSet.getString("Nama_Maskapai");
                data[p][2] = resultSet.getString("Kelas");
                data[p][3] = resultSet.getString("Tujuan");
                data[p][4] = resultSet.getString("Berangkat");
                data[p][5] = resultSet.getString("Tiba");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);

        setLayout(new FlowLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        btnBack = new JButton ("BACK");
        btnDelete = new JButton ("DELETE");
        
        panelTombol = new JPanel(new FlowLayout());
        setLayout(new BorderLayout());
        add(panelTombol, BorderLayout.PAGE_END);
        panelTombol.add(btnDelete);
        add(panelTombol, BorderLayout.PAGE_END);
        panelTombol.add(btnBack);
        setVisible(true);
        btnBack.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().setVisible(true);
                setVisible(false);
            }          }); 
        btnDelete.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             try{
             koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
             statement = koneksi.createStatement();
             String query = "delete from jadwal";
             PreparedStatement ps = koneksi.prepareStatement(query);
             ps.executeUpdate();
             statement.close();
             koneksi.close();
           }catch(Exception ex){
           }
           new Menu().setVisible(true);
           dispose();
           }});
    }     
    public static void main(String[] args) {
        LihatJadwal lihatJadwal = new LihatJadwal();
    }
}
