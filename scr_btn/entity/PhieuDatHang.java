package entity;

import java.sql.Date;
import java.util.List;

public class PhieuDatHang {
    private String maPhieu; // Mã phiếu
    private Date ngayGioDat; // Ngày giờ đặt
    private String maNCC; // Mã nhà cung cấp
    private String diachiNhanHang; // Địa chỉ nhận hàng
    private Date ngayGiao; // Ngày giao
    private double tongTien; // Tổng tiền
    private List<ChiTietPhieuDatHang> chiTietPhieuDatHangs; // Chi tiết phiếu đặt hàng

    // Constructor
    public PhieuDatHang(String maPhieu, Date ngayGioDat, String maNCC, String diachiNhanHang, Date ngayGiao, double tongTien) {
        this.maPhieu = maPhieu;
        this.ngayGioDat = ngayGioDat;
        this.maNCC = maNCC;
        this.diachiNhanHang = diachiNhanHang;
        this.ngayGiao = ngayGiao;
        this.tongTien = tongTien;
        this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
    }

    public PhieuDatHang() {
        // Constructor mặc định
    }

    // Getter and Setter methods
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayGioDat() {
        return ngayGioDat;
    }

    public void setNgayGioDat(Date ngayGioDat) {
        this.ngayGioDat = ngayGioDat;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getDiachiNhanHang() {
        return diachiNhanHang;
    }

    public void setDiachiNhanHang(String diachiNhanHang) {
        this.diachiNhanHang = diachiNhanHang;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public List<ChiTietPhieuDatHang> getChiTietPhieuDatHangs() {
        return chiTietPhieuDatHangs;
    }

    public void setChiTietPhieuDatHangs(List<ChiTietPhieuDatHang> chiTietPhieuDatHangs) {
        this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
    }

    @Override
    public String toString() {
        return "PhieuDatHang [maPhieu=" + maPhieu + ", ngayGioDat=" + ngayGioDat + ", maNCC=" + maNCC + ", diachiNhanHang=" + diachiNhanHang
                + ", ngayGiao=" + ngayGiao + ", tongTien=" + tongTien + ", chiTietPhieuDatHangs=" + chiTietPhieuDatHangs + "]";
    }
}