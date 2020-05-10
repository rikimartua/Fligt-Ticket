/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author RIKI MARTUA
 */
public class ModelData {
    private String namaDepan;
    private String namaBelakang;
    private String telepon;
    private String email;
    private String id;

    
    private ListenerData listenerData;

    protected void fireOnChange() {
        if (listenerData != null) {
            listenerData.onChange(this);
        }
    }

    public ListenerData getDataListener() {
        return listenerData;
    }

    public void setDataListener(ListenerData listenerData) {
        this.listenerData = listenerData;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
        fireOnChange();
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
        fireOnChange();
    }
    
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
        fireOnChange();
    }

    public void resetForm() {
        setNamaBelakang("");
        setNamaDepan("");
    }
    public void submitForm(ViewData c) {
        InputData k = new InputData();
        k.MasukkanData(c);
    }
    
}
