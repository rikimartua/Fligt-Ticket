
package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Daftar {
    String DBurl = "jdbc:mysql://localhost/data1";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public void Data(ViewDaftar c)
    {
        String namaLengkap = c.getFnamalengkap().getText();
        String email = c.getFemail().getText();
        String username = c.getFusername().getText();
        String password = c.getFpassword().getText();
        String password1 = c.getFpassword1().getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into user values('"+ namaLengkap + "','" + email + "','" + username + "','" + password + "')");
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
