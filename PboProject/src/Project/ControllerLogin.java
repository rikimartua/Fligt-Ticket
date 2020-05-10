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
import javax.swing.JOptionPane;

public class ControllerLogin {

    private ModelLogin mo;

    public void setMo(ModelLogin mo) {
        this.mo = mo;
    }
    
    public void Daftar() { 
          ViewDaftar daftar = new ViewDaftar();
          daftar.setVisible(true); 
    }

    public void resetForm(ViewLogin viewLogin) {
        String username = viewLogin.getFusername().getText();
        String password = viewLogin.getFpassword().getText();

        if (username.equals("") && password.equals("")) {
        } else {
            mo.resetForm();
        }
    }

    public void submitForm(ViewLogin viewLogin) {
        String username = viewLogin.getFusername().getText();
        String password = viewLogin.getFpassword().getText();

        if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(viewLogin, "Username Masih Kosong !");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(viewLogin, "Password Masih Kosong !");
        } 
        else {
            mo.submitForm(viewLogin);
        }
    }
}
