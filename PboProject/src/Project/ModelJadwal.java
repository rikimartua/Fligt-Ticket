
package Project;

public class ModelJadwal {
    private String no_pesawat;
    private String maskapai;
    private String kelas;
    private String tujuan;
    private String tiba;
    private String berangkat;
    private ListenerJadwal listenerJadwal;

    protected void fireOnChange() {
        if (listenerJadwal != null) {
            listenerJadwal.onChange(this);
        }
    }

    public ListenerJadwal getJadwalListener() {
        return listenerJadwal;
    }

    public void setJadwalListener(ListenerJadwal listenerJadwal) {
        this.listenerJadwal = listenerJadwal;
    }

    public String getNo_pesawat() {
        return no_pesawat;
    }

    public void setNo_pesawat(String no_pesawat) {
        this.no_pesawat = no_pesawat;
    }

    public String getNama_pesawat() {
        return maskapai;
    }

    public void setMaskapai(String maskapai) {
        this.maskapai = maskapai;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getBerangkat() {
        return berangkat;
    }

    public void setBerangkat(String berangkat) {
        this.berangkat = berangkat;
    }

    public String getTiba() {
        return tiba;
    }

    public void setTiba(String tiba) {
        this.tiba = tiba;
    }

    public void resetForm() {
        setNo_pesawat("");
        setMaskapai("");
        setKelas("");
        setTujuan("");
        setBerangkat("");
        setTiba("");
    }
    public void submitForm(InputJadwal c) {
        Jadwal d = new Jadwal();
        d.MasukkanData(c);
    }
}