package entity;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private int tuoi;
	private String sdt;
	private String email;

	// Constructor
	public KhachHang(String maKH, String tenKH, int tuoi, String sdt, String email) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.tuoi = tuoi;
		this.sdt = sdt;
		this.email = email;
	}

	// Getters and Setters
	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
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
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", tuoi=" + tuoi + ", sdt=" + sdt + ", email=" + email
				+ "]";
	}
}
