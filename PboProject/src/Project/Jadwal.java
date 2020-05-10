
package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Jadwal {
    String DBurl = "jdbc:mysql://localhost/data1";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public void MasukkanData(InputJadwal inputJadwal)
    {
        String no_pesawat = inputJadwal.getFno_pesawat().getText();
        String maskapai = inputJadwal.getFmaskapai().getText();
        String kelas = inputJadwal.getFkelas().getText();
        String tujuan = inputJadwal.getFtujuan().getText();
        String berangkat = inputJadwal.getFberangkat().getText();
        String tiba = inputJadwal.getFtiba().getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into jadwal values('"+ no_pesawat + "','" + maskapai + "','" + kelas + "','" + tujuan+ "','" + berangkat+ "','" + tiba+ "')");
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}