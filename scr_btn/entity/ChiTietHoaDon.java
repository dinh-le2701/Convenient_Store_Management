package entity;

public class ChiTietHoaDon {
    private String maCTHD; // Mã chi tiết hóa đơn
    private String maHD; // Mã hóa đơn
    private String maSP; // Mã sản phẩm
    private String tenSP; // Tên sản phẩm
    private int soLuong; // Số lượng
    private double donGia; // Đơn giá
    private double thanhTien; // Thành tiền

    public ChiTietHoaDon(String maCTHD, String maHD, String maSP, String tenSP, int soLuong, double donGia,double thanhTien) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = tinhThanhTien(); // Tính thành tiền khi khởi tạo
    }

    public ChiTietHoaDon() {
        // Constructor mặc định
    }

    // Getter and Setter methods
    public String getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(String maCTHD) {
        this.maCTHD = maCTHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = tinhThanhTien(); // Cập nhật thành tiền khi số lượng thay đổi
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = tinhThanhTien(); // Cập nhật thành tiền khi đơn giá thay đổi
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // Tính thành tiền
    public double tinhThanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon [maCTHD=" + maCTHD + ", maHD=" + maHD + ", maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong
                + ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
    }
}