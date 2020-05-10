
package Project;


public class ModelDaftar {

    private String namaLengkap;
    private String email;
    private String username;
    private String password;
    private String password1;
    private ListenerDaftar listenerDaftar;

    protected void fireOnChange() {
        if (listenerDaftar != null) {
            listenerDaftar.onChange(this);
        }
    }

    public ListenerDaftar getDaftarListener() {
        return listenerDaftar;
    }

    public void setDaftarListener(ListenerDaftar listenerDaftar) {
        this.listenerDaftar = listenerDaftar;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
        fireOnChange();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnChange();
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
        fireOnChange();
    }

    public void resetForm() {
        setNamaLengkap("");
        setEmail("");
        setUsername("");
        setPassword("");
        setPassword1("");
    }
    public void submitForm(ViewDaftar c) {
        Daftar input = new Daftar();
        input.Data(c);
    }
}