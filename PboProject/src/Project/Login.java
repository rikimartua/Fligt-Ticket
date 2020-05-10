
package Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Login {

  String DBurl = "jdbc:mysql://localhost/data1";
  String DBusername = "root";
  String DBpassword = "";  
  Connection con;
  Statement stat;
  ResultSet rs;
  String sql;
            
public Login()
{
    Koneksi DB = new Koneksi();
    DB.config();
    con = DB.conn;
    stat = DB.stm;
}

public void Data(ViewLogin c)
    {
        String username = c.getFusername().getText();
        String password = c.getFpassword().getText();
         try {
            sql = "SELECT * FROM login WHERE username='"+username+"' AND password='"+password+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                     new Menu().setVisible(true);
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Username atau Password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}