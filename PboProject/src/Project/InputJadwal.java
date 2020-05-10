
package Project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputJadwal extends JFrame implements ActionListener, ListenerJadwal {
    
    final JTextField fno_pesawat = new JTextField(10);
    final JTextField fNama_pesawat = new JTextField(10);
    final JTextField fKelas = new JTextField(10);
    final JTextField fTujuan = new JTextField(10);
    final JTextField fBerangkat = new JTextField(10);
    final JTextField fTiba = new JTextField(10);
    JLabel lno_pesawat = new JLabel("No_Pesawat");
    JLabel lNama_pesawat = new JLabel("Nama_Maskapai");
    JLabel lKelas = new JLabel("Kelas");
    JLabel lTujuan = new JLabel("Tujuan");
    JLabel lBerangkat = new JLabel("Berangkat");
    JLabel lTiba = new JLabel("Tiba");
    JButton btnSave = new JButton("Submit");    
    JButton btnReset = new JButton("Reset");
    JButton btnData = new JButton("Data");

    JLabel lJudul = new JLabel(" ISI JADWAL TIKET PESAWAT ");
    JLabel lGambar;
    ControllerJadwal controllerJadwal;
    ModelJadwal modelJadwal;

    public InputJadwal() {
        setTitle("INPUT Jadwal Kereta");
        setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/pesawat.jpg")));
        setSize(750, 300);

        setLayout(null);
        add(lno_pesawat);
        add(lJudul);
        add(fno_pesawat);
        add(lNama_pesawat);
        add(fNama_pesawat);
        add(lKelas);
        add(fKelas);
        add(lTujuan);
        add(fTujuan);
        add(lBerangkat);
        add(fBerangkat);
        add(lTiba);
        add(fTiba);
        add(btnSave);
        add(btnReset);
        add(btnData);
        add(lGambar);
        
        lJudul.setFont(new java.awt.Font("Couture", 2, 18));
        lJudul.setForeground(Color.orange);
        lJudul.setBounds(250, 2, 360, 40);
        lno_pesawat.setBounds(350, 70, 120, 20);
        fno_pesawat.setBounds(470, 70, 170, 20);
        lNama_pesawat.setBounds(350, 95, 120, 20);
        fNama_pesawat.setBounds(470, 95, 170, 20);
        lKelas.setBounds(350, 120, 120, 20);
        fKelas.setBounds(470, 120, 170, 20);
        lTujuan.setBounds(350, 145, 120, 20);
        fTujuan.setBounds(470, 145, 170, 20);
        lBerangkat.setBounds(350, 170, 120, 20);
        fBerangkat.setBounds(470, 170, 170, 20);
        lTiba.setBounds(350, 195, 120, 20);
        fTiba.setBounds(470, 195, 170, 20);
        btnReset.setBounds(470, 220, 80, 20);
        btnSave.setBounds(560, 220, 80, 20);
        btnData.setBounds(370, 220, 80, 20);
        lGambar.setBounds(0, 0, 800, 300);
        
        btnSave.addActionListener(this);
        btnReset.addActionListener(this);
        btnData.addActionListener(this);
        
        setVisible(true);

        controllerJadwal = new ControllerJadwal();
        modelJadwal= new ModelJadwal();
        modelJadwal.setJadwalListener(this);
        controllerJadwal.setMo(modelJadwal);
    }
  
    public JTextField getFno_pesawat() {
        return fno_pesawat;
    }

    public JTextField getFmaskapai() {//tandai
        return fNama_pesawat;
    }
    
    public JTextField getFkelas() {
        return fKelas;
    }
    
    public JTextField getFtujuan() {
        return fTujuan;
    }
    
    public JTextField getFberangkat() {
        return fBerangkat;
    }
    
    public JTextField getFtiba() {
        return fTiba;
    }

    public static void main(String[] args) {
        new InputJadwal();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            controllerJadwal.submitForm(this);
        }
        if (e.getSource() == btnReset) {
            controllerJadwal.resetForm(this);
        }
        if (e.getSource() == btnData) {
            controllerJadwal.Login();
            setVisible(false);
        }
    }
    
    public void onChange(ModelJadwal modelJadwal) {
        fno_pesawat.setText(modelJadwal.getNo_pesawat());
        fNama_pesawat.setText(modelJadwal.getNama_pesawat());
        fKelas.setText(modelJadwal.getKelas());
        fTujuan.setText(modelJadwal.getTujuan());
        fBerangkat.setText(modelJadwal.getBerangkat());
        fTiba.setText(modelJadwal.getTiba());
    }
}
