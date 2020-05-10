
package Project;

import javax.swing.JOptionPane;

public class ControllerDaftar {

    private ModelDaftar mo;

    public void setMo(ModelDaftar mo) {
        this.mo = mo;
    }
    
    public void Login() { 
          ViewLogin daftar = new ViewLogin();
          daftar.setVisible(true); 
    }

    public void resetForm(ViewDaftar viewDaftar) {
        String namaLengkap = viewDaftar.getFnamalengkap().getText();
        String email = viewDaftar.getFemail().getText();
        String username = viewDaftar.getFusername().getText();
        String password = viewDaftar.getFpassword().getText();
        String password1 = viewDaftar.getFpassword1().getText();

        if (namaLengkap.equals("") && email.equals("") && username.equals("") && password.equals("") && password1.equals("")) {
        } else {
            mo.resetForm();
        }
    }

    public void submitForm(ViewDaftar viewDaftar) {
        String namaLengkap = viewDaftar.getFnamalengkap().getText();
        String email = viewDaftar.getFemail().getText();
        String username = viewDaftar.getFusername().getText();
        String password = viewDaftar.getFpassword().getText();
        String password1 = viewDaftar.getFpassword1().getText();
        
        if(password.trim().equals(password1.trim()))
        {
        }
        else
        {
           JOptionPane.showMessageDialog(viewDaftar, "Konfirmasi Password Salah !"); 
        }

        if (namaLengkap.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Nama Depan Masih Kosong !");
        } else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Email Masih Kosong !");
        } else if (username.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Username Masih Kosong !");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Password Masih Kosong !");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(viewDaftar, "Confirm Password Masih Kosong !");
        }
        else {
            mo.submitForm(viewDaftar);
        }
    }
}
