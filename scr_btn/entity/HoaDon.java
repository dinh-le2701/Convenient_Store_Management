package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HoaDon {
    private String maHD;
    private Date ngayGio;
    private String tenKH;
    private String tenNV;
    private double tongTien;
    private List<ChiTietHoaDon> chiTietHoaDons;

    public HoaDon() {
        this.chiTietHoaDons = new ArrayList<>();
    }

    public HoaDon(String maHD, Date ngayGio, String tenKH, String tenNV) {
        this.maHD = maHD;
        this.ngayGio = ngayGio;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
        this.tongTien = 0.0;
        this.chiTietHoaDons = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(Date ngayGio) {
        this.ngayGio = ngayGio;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
        this.tongTien = 0; // Cập nhật lại tổng tiền
        for (ChiTietHoaDon cthd : chiTietHoaDons) {
            this.tongTien += cthd.getThanhTien();
        }
    }

    public void addChiTietHoaDon(ChiTietHoaDon chiTiet) {
        this.chiTietHoaDons.add(chiTiet);
        this.tongTien += chiTiet.getThanhTien();
    }

    public void removeChiTietHoaDon(ChiTietHoaDon chiTiet) {
        this.chiTietHoaDons.remove(chiTiet);
        this.tongTien -= chiTiet.getThanhTien();
    }

    @Override
    public String toString() {
        return "HoaDon [maHD=" + maHD + ", ngayGio=" + ngayGio + ", tenKH=" + tenKH + ", tenNV=" + tenNV + ", tongTien="
                + tongTien + ", chiTietHoaDons=" + chiTietHoaDons + "]";
    }
}