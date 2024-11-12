package entity;

public class ChiTietPhieuDatHang {
    private String maCTPDH; // Mã chi tiết phiếu đặt hàng
    private String maPhieu; // Mã phiếu
    private String maSP; // Mã sản phẩm
    private String tenSP;
    private int soLuong; // Số lượng
    private double donGia; // Đơn giá
    private double thanhTien; // Thành tiền

    // Constructor
    public ChiTietPhieuDatHang(String maCTPDH, String maPhieu, String maSP, String tenSP, int soLuong, double donGia, double thanhTien) {
        this.maCTPDH = maCTPDH;
        this.maPhieu = maPhieu;
        this.maSP = maSP;
        this.tenSP= tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // Tính thành tiền
    }

    public ChiTietPhieuDatHang() {
        // Constructor mặc định
    }

    // Getter and Setter methods
    public String getMaCTPDH() {
        return maCTPDH;
    }

    public void setMaCTPDH(String maCTPDH) {
        this.maCTPDH = maCTPDH;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = soLuong * donGia; // Cập nhật thành tiền
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia; // Cập nhật thành tiền
    }

    public double getThanhTien() {
        return thanhTien;
    }

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatHang [maCTPDH=" + maCTPDH + ", maPhieu=" + maPhieu + ", maSP=" + maSP + ", tenSP="
				+ tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
	}

   
}