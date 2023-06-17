package android.bai3_lab4;

public class Truyen {
    String tenTruyen;
    int idAnh;
    String ndTruyen;

    public Truyen(String tenTruyen, int idAnh, String ndTruyen) {
        this.tenTruyen = tenTruyen;
        this.idAnh = idAnh;
        this.ndTruyen = ndTruyen;
    }
    public Truyen()
    {

    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getNdTruyen() {
        return ndTruyen;
    }

    public void setNdTruyen(String ndTruyen) {
        this.ndTruyen = ndTruyen;
    }
}
