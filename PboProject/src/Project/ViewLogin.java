
package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Background;
import javax.swing.*; 
import javax.swing.ImageIcon;


public class ViewLogin extends JFrame implements ActionListener, ListenerLogin
{
   
   JLabel lGambar;
   final JTextField fUsername = new JTextField(10);
   JLabel lUsername = new JLabel("Username");
   final JPasswordField fPassword = new JPasswordField(10);
   JLabel lPassword = new JLabel("Password");
   JButton btnLogin = new JButton("");
   JButton btnSignup = new JButton("");
   JLabel lJudul1 = new JLabel(" Belum Punya Akun? Daftar Disini ");
   ControllerLogin controllerLogin;
   ModelLogin modelLogin;
   
   public ViewLogin() 
   {
        setTitle("LOGIN");
	setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/login_layout.jpg")));
        btnLogin = new JButton (new ImageIcon (getClass().getResource("image/loginn.jpg")));
        btnSignup = new JButton (new ImageIcon (getClass().getResource("image/signupp.jpg")));
        setSize(300,500);
        setLayout(null);
        add (lJudul1);
        add (fUsername);
        add (lUsername);
        add (fPassword);
        add (lPassword);
        add (btnLogin);
        add (btnSignup);
        add (lGambar);
        lUsername.setFont(new java.awt.Font("Century Gothic", 2, 14));
        lPassword.setFont(new java.awt.Font("Century Gothic", 2, 14));
        fUsername.setFont(new java.awt.Font("Futura Bk Bt", 2, 16));
        fUsername.setBounds(10, 192, 260, 30);
        lUsername.setBounds(10,162, 260, 40);
        lPassword.setBounds(10, 222, 260, 40);
        fPassword.setBounds(10, 252, 260, 30);
        btnLogin.setBounds(40,290,200,40);
        lJudul1.setBounds(45, 360, 300, 40);
        btnSignup.setBounds(40, 390, 200, 40);
        lGambar.setBounds(0, 0, 300, 500);
        
        btnLogin.addActionListener(this);
        btnSignup.addActionListener(this);
        setVisible (true);
        controllerLogin= new ControllerLogin();
        modelLogin = new ModelLogin();
        modelLogin.setLoginListener(this);
        controllerLogin.setMo(modelLogin);
        
    }
   public JTextField getFusername() {
        return fUsername;
    }

    public JPasswordField getFpassword() {
        return fPassword;
    }
    
   public static void main(String[] args) {
	 new ViewLogin();
   }
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            controllerLogin.submitForm(this);
            setVisible(false);
        }
        if (e.getSource() == btnSignup) {
            controllerLogin.Daftar();
            setVisible(false);
        }
    }

    public void onChange(ModelLogin modelLogin) {
        fUsername.setText(modelLogin.getUsername());
        fPassword.setText(modelLogin.getPassword());
    }
}