/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class InputData {
    String DBurl = "jdbc:mysql://localhost/data1";
        String DBusername = "root";
        String DBpassword = "";
        Connection koneksi;
        Statement statement;
    public void MasukkanData(ViewData c)
    {
        String namaDepan = c.getFnamadepan().getText();
        String namaBelakang = c.getFnamabelakang().getText();
        String telepon = c.getFtelepon().getText();
        String email = c.getFemail().getText();
        String id = c.getFid().getText();
         try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            statement.executeUpdate("insert into tiket values('" + namaDepan+" "+namaBelakang + "','" + telepon+ "','" + email + "','" + id + "')");
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