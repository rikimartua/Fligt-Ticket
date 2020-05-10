/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author RIKI MARTUA
 */
public class ViewData extends JFrame implements ActionListener,ListenerData{
    
    final JTextField fnamadepan = new JTextField(10);
    final JTextField fnamabelakang = new JTextField(10);
    final JTextField femail = new JTextField(10);
    final JTextField ftelepon = new JTextField(10);
    final JTextField fid = new JTextField(10);
    JLabel lnamadepan = new JLabel("Nama Depan");
    JLabel lnamabelakang = new JLabel("Nama Belakang");
    JLabel lemail = new JLabel("Alamat Email");
    JLabel ltelepon = new JLabel("No. Telepon");
    JLabel lid = new JLabel("No. KTP/SIM");
    JButton btnSave = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnData = new JButton("Cetak");
    JLabel lJudul = new JLabel(" ISI DATA TIKET KERETA API ");
    JLabel lGambar;
    ControllerData controllerData;
    ModelData modelData;

    public ViewData() {
        setTitle("INPUT DATA DIRI");
        setDefaultCloseOperation(3);
        lGambar = new JLabel (new ImageIcon (getClass().getResource("image/pes.jpg")));
        setSize(750, 300);


        setLayout(null);
        add(lnamadepan);
        add(lJudul);
        add(fnamadepan);
        add(lnamabelakang);
        add(fnamabelakang);
        add(lemail);
        add(femail);
        add(ltelepon);
        add(ftelepon);
        add(lid);
        add(fid);
        add(btnSave);
        add(btnReset);
        add(btnData);
        add(lGambar);
        
        lJudul.setFont(new java.awt.Font("Couture", 2, 18));
        lJudul.setForeground(Color.orange);
        lJudul.setBounds(250, 2, 360, 40);
        lnamadepan.setBounds(350, 70, 120, 20);
        fnamadepan.setBounds(470, 70, 170, 20);
        lnamabelakang.setBounds(350, 95, 120, 20);
        fnamabelakang.setBounds(470, 95, 170, 20);
        lemail.setBounds(350, 120, 120, 20);
        femail.setBounds(470, 120, 170, 20);
        ltelepon.setBounds(350, 145, 120, 20);
        ftelepon.setBounds(470, 145, 170, 20);
        lid.setBounds(350, 170, 120, 20);
        fid.setBounds(470, 170, 170, 20);
        btnReset.setBounds(470, 220, 80, 20);
        btnSave.setBounds(560, 220, 80, 20);
        btnData.setBounds(370, 220, 80, 20);
        lGambar.setBounds(0, 0, 800, 300);

        btnSave.addActionListener(this);
        btnReset.addActionListener(this);
        btnData.addActionListener(this);
        
        setVisible(true);

        controllerData = new ControllerData();
        modelData = new ModelData();
        modelData.setDataListener(this);
        controllerData.setMo(modelData);
        
    }

    public JTextField getFnamabelakang() {
        return fnamabelakang;
    }

    public JTextField getFnamadepan() {
        return fnamadepan;
    }
    
    public JTextField getFtelepon() {
        return ftelepon;
    }
    
    public JTextField getFemail() {
        return femail;
    }

    public JTextField getFid() {
        return fid;
    }

    public static void main(String[] args) {
        new ViewData();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            controllerData.submitForm(this);
        }
        if (e.getSource() == btnReset) {
            controllerData.resetForm(this);
        }
        if (e.getSource() == btnData) {
            controllerData.Data();
            setVisible(false);
        }
    }

    public void onChange(ModelData modelData) {
        fnamadepan.setText(modelData.getNamaDepan());
        fnamabelakang.setText(modelData.getNamaBelakang());
        ftelepon.setText(modelData.getTelepon());
        femail.setText(modelData.getEmail());
        fid.setText(modelData.getID());
    }
}
