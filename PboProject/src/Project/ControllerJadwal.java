
package Project;

import javax.swing.JOptionPane;

public class ControllerJadwal {

    private ModelJadwal mo;

    public void setMo(ModelJadwal mo) {
        this.mo = mo;
    }
    
    public void Login() { 
          LihatJadwal l = new LihatJadwal();
//          setVisible(false);
          l.setVisible(true); 
    }

    public void resetForm(InputJadwal inputJadwal) {
        String no_pesawat = inputJadwal.getFno_pesawat().getText();
        String maskapai = inputJadwal.getFmaskapai().getText();
        String kelas = inputJadwal.getFkelas().getText();
        String tujuan = inputJadwal.getFtujuan().getText();
        String berangkat = inputJadwal.getFberangkat().getText();
        String tiba = inputJadwal.getFtiba().getText();

        if (no_pesawat.equals("") && maskapai.equals("") && kelas.equals("") && tujuan.equals("") && berangkat.equals("")&& tiba.equals("")) {
        } else {
            mo.resetForm();
        }
    }

    public void submitForm(InputJadwal inputJadwal) {
        String no_pesawat = inputJadwal.getFno_pesawat().getText();
        String maskapai = inputJadwal.getFmaskapai().getText();
        String kelas = inputJadwal.getFkelas().getText();
        String tujuan = inputJadwal.getFtujuan().getText();
        String berangkat = inputJadwal.getFberangkat().getText();
        String tiba = inputJadwal.getFtiba().getText();
        

        if (no_pesawat.trim().equals("")) {
            JOptionPane.showMessageDialog(inputJadwal, "N0-Ka Masih Kosong !");
        } else if (maskapai .trim().equals("")) {
            JOptionPane.showMessageDialog(inputJadwal, "Nama_Ka Masih Kosong !");
        } else if (kelas.trim().equals("")) {
            JOptionPane.showMessageDialog(inputJadwal, "Kelas Masih Kosong !");
        } else if (tujuan.trim().equals("")) {
            JOptionPane.showMessageDialog(inputJadwal, "Tujuan Masih Kosong !");
        } else if (berangkat.trim().equals("")) {
            JOptionPane.showMessageDialog(inputJadwal, "Berangkat Password Masih Kosong !");
        } else if (tiba.trim().equals("")) {
            JOptionPane.showMessageDialog(inputJadwal, "Tiba Password Masih Kosong !");
        }
        else {
            mo.submitForm(inputJadwal);
        }
    }
}
