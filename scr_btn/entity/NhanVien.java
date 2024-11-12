package entity;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private int tuoi;
	private String gioiTinh;
	private String sdt;
	private String email;

	// Constructor
	public NhanVien(String maNV, String tenNV, int tuoi, String gioiTinh, String sdt, String email) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
	}

	// Getters and Setters
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString method
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", sdt="
				+ sdt + ", email=" + email + "]";
	}
}
