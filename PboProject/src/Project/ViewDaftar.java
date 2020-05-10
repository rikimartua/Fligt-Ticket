
package Project;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class ViewDaftar extends JFrame implements ActionListener, ListenerDaftar {

    final JTextField fnamalengkap = new JTextField(10);
    final JTextField femail = new JTextField(10);
    final JTextField fusername = new JTextField(10);
    final JPasswordField fpassword = new JPasswordField(10);
    final JPasswordField fpassword1 = new JPasswordField(10);
    JLabel lJudul = new JLabel("DAFTAR AKUN ");
    JLabel lJudul1 = new JLabel("SILAHKAN =D ");
    JLabel lnamalengkap = new JLabel("Nama Lengkap");
    JLabel lemail = new JLabel("Alamat Email");
    JLabel lusername = new JLabel("Username");
    JLabel lpassword = new JLabel("Password");
    JLabel lpassword1 = new JLabel("Confirm Password");
    JButton btndaftar = new JButton("Daftar");
    JButton btnlogin = new JButton("Login");
    JLabel lGambar;
    ControllerDaftar controllerDaftar;
    ModelDaftar modelDaftar;

    public ViewDaftar() {
        setTitle("DAFTAR");
        setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/pesawat.jpg")));
        setSize(400, 350);


        setLayout(null);
        add(lJudul);
        add(lJudul1);
        add(lnamalengkap);
        add(fnamalengkap);
        add(lemail);
        add(femail);
        add(lusername);
        add(fusername);
        add(lpassword);
        add(fpassword);
        add(lpassword1);
        add(fpassword1);
        add(btnlogin);
        add(btndaftar);
        add(lGambar);
        
        lJudul.setFont(new java.awt.Font("Couture", 2, 24));
        lJudul.setForeground(Color.orange);
        lJudul.setBounds(10, 10, 360, 40);
        lJudul1.setFont(new java.awt.Font("Century Gothic", 2, 10));
        lJudul1.setForeground(Color.black);
        lJudul1.setBounds(10, 28, 360, 40);
        lnamalengkap.setBounds(50, 90, 120, 20);
        lnamalengkap.setForeground(Color.white);
        fnamalengkap.setBounds(170, 90, 170, 20);
        lemail.setBounds(50, 115, 120, 20);
        lemail.setForeground(Color.white);
        femail.setBounds(170, 115, 170, 20);
        lusername.setBounds(50, 140, 120, 20);
        lusername.setForeground(Color.white);
        fusername.setBounds(170, 140, 170, 20);
        lpassword.setBounds(50, 165, 120, 20);
        lpassword.setForeground(Color.white);
        fpassword.setBounds(170, 165, 170, 20);
        lpassword1.setBounds(50, 190, 120, 20);
        lpassword1.setForeground(Color.white);
        fpassword1.setBounds(170, 190, 170, 20);
        btnlogin.setBounds(50, 240, 80, 20);
        btndaftar.setBounds(250, 240, 80, 20);
        lGambar.setBounds(0, 0, 400, 350);

        btnlogin.addActionListener(this);
        btndaftar.addActionListener(this);
        
        setVisible(true);

        controllerDaftar = new ControllerDaftar();
        modelDaftar = new ModelDaftar();
        modelDaftar.setDaftarListener(this);
        controllerDaftar.setMo(modelDaftar);
    }

    public JTextField getFnamalengkap() {
        return fnamalengkap;
    }

    public JTextField getFemail() {
        return femail;
    }
    
    public JTextField getFusername() {
        return fusername;
    }
    
    public JTextField getFpassword() {
        return fpassword;
    }
    
    public JTextField getFpassword1() {
        return fpassword1;
    }

    public static void main(String[] args) {
        new ViewDaftar();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btndaftar) {
            controllerDaftar.submitForm(this);
        }
        if (e.getSource() == btnlogin) {
            controllerDaftar.Login();
            setVisible(false);
        }
    }

    public void onChange(ModelDaftar modelDaftar) {
        fnamalengkap.setText(modelDaftar.getNamaLengkap());
        femail.setText(modelDaftar.getEmail());
        fusername.setText(modelDaftar.getUsername());
        fpassword.setText(modelDaftar.getPassword());
        fpassword1.setText(modelDaftar.getPassword1());
    }
}