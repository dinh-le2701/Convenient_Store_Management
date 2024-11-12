package entity;

import java.sql.Date;

public class SanPham {
	private String maSP;
	private String tenSP;
	private Date ngaySX;
	private Date hanSD;
	private String maNCC;
	private double giaSP;
	private int soLuongTrongKho;
	private String loaiSP;
	private String donVi;

	// Constructor
	public SanPham(String maSP, String tenSP, Date ngaySX, Date hanSD, String maNCC, double giaSP, int soLuongTrongKho,
			String loaiSP, String donVi) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.ngaySX = ngaySX;
		this.hanSD = hanSD;
		this.maNCC = maNCC;
		this.giaSP = giaSP;
		this.soLuongTrongKho = soLuongTrongKho;
		this.loaiSP = loaiSP;
		this.donVi = donVi;
	}

	// Getters and Setters
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

	public Date getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(Date ngaySX) {
		this.ngaySX = ngaySX;
	}

	public Date getHanSD() {
		return hanSD;
	}

	public void setHanSD(Date hanSD) {
		this.hanSD = hanSD;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public double getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(double giaSP) {
		this.giaSP = giaSP;
	}

	public int getSoLuongTrongKho() {
		return soLuongTrongKho;
	}

	public void setSoLuongTrongKho(int soLuongTrongKho) {
		this.soLuongTrongKho = soLuongTrongKho;
	}

	public String getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	// toString method
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", ngaySX=" + ngaySX + ", hanSD=" + hanSD + ", maNCC="
				+ maNCC + ", giaSP=" + giaSP + ", soLuongTrongKho=" + soLuongTrongKho + ", loaiSP=" + loaiSP
				+ ", donVi=" + donVi + "]";
	}
}
