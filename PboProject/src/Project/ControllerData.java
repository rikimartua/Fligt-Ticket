/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import javax.swing.JOptionPane;

/**
 *
 * @author RIKI MARTUA
 */
public class ControllerData {
    private ModelData mo;

    public void setMo(ModelData mo) {
        this.mo = mo;
    }

    public void Data() {
          CetakTiket Lihat = new CetakTiket();
          Lihat.setVisible(true);
//        setVisible(false);  
    }
    public void resetForm(ViewData b) {
        String namaDepan = b.getFnamadepan().getText();
        String namaBelakang = b.getFnamabelakang().getText();
        String telepon = b.getFtelepon().getText();
        String email = b.getFemail().getText();
        String id = b.getFid().getText();
        
        if (namaDepan.equals("") && namaBelakang.equals("") && telepon.equals("")&& email.equals("") &&id.equals("")) {
        } else {
            mo.resetForm();
        }
    }

    public void submitForm(ViewData o) {
        

        String namaDepan = o.getFnamadepan().getText();
        String namaBelakang = o.getFnamabelakang().getText();
        String telepon = o.getFtelepon().getText();
        String email = o.getFemail().getText();
        String id = o.getFid().getText();
        
        if (namaDepan.trim().equals("")) {
            JOptionPane.showMessageDialog(o, "Nama Depan Masih Kosong !");
        } else if (namaBelakang.trim().equals("")) {
            JOptionPane.showMessageDialog(o, "Nama Belakang Masih Kosong !");
        } else if (telepon.trim().equals("")) {
            JOptionPane.showMessageDialog(o, "Telepon Masih Kosong !"); 
        }  else if (email.trim().equals("")) {
            JOptionPane.showMessageDialog(o, "Email Masih Kosong !"); 
        }
         else if (id.trim().equals("")) {
            JOptionPane.showMessageDialog(o, "Nomor ID Masih Kosong !"); 
        }
        else {
            mo.submitForm(o);
        }


    }
    
}
