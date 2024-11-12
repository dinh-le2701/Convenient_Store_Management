package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.ChiTietPhieuDatHang;
import entity.PhieuDatHang;

public class PhieuDatHangDAO {

    public void addPhieuDatHang(PhieuDatHang phieuDatHang) throws SQLException {
        String sql = "INSERT INTO PhieuDatHang (maPhieu, ngayGioDat, maNCC, diachiNhanHang, ngayGiao, tongTien) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, phieuDatHang.getMaPhieu());
            pstmt.setDate(2, phieuDatHang.getNgayGioDat());
            pstmt.setString(3, phieuDatHang.getMaNCC());
            pstmt.setString(4, phieuDatHang.getDiachiNhanHang());
            pstmt.setDate(5, phieuDatHang.getNgayGiao());
            pstmt.setDouble(6, phieuDatHang.getTongTien());
            pstmt.executeUpdate();
        }

        // Thêm chi tiết phiếu đặt hàng
        for (ChiTietPhieuDatHang ctpdh : phieuDatHang.getChiTietPhieuDatHangs()) {
            addChiTietPhieuDatHang(ctpdh);
        }
    }

    public void addChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws SQLException {
        String sql = "INSERT INTO ChiTietPhieuDatHang (maCTPDH, maPhieu, maSP, soLuong, donGia, thanhTien) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, chiTietPhieuDatHang.getMaCTPDH());
            pstmt.setString(2, chiTietPhieuDatHang.getMaPhieu());
            pstmt.setString(3, chiTietPhieuDatHang.getMaSP());
            pstmt.setInt(4, chiTietPhieuDatHang.getSoLuong());
            pstmt.setDouble(5, chiTietPhieuDatHang.getDonGia());
            pstmt.setDouble(6, chiTietPhieuDatHang.getThanhTien());
            pstmt.executeUpdate();
        }
    }

    public void updatePhieuDatHang(PhieuDatHang phieuDatHang) throws SQLException {
        String sql = "UPDATE PhieuDatHang SET ngayGioDat = ?, maNCC = ?, diachiNhanHang = ?, ngayGiao = ?, tongTien = ? WHERE maPhieu = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, phieuDatHang.getNgayGioDat());
            pstmt.setString(2, phieuDatHang.getMaNCC());
            pstmt.setString(3, phieuDatHang .getDiachiNhanHang());
            pstmt.setDate(4, phieuDatHang.getNgayGiao());
            pstmt.setDouble(5, phieuDatHang.getTongTien());
            pstmt.setString(6, phieuDatHang.getMaPhieu());
            pstmt.executeUpdate();
        }

        // Cập nhật chi tiết phiếu đặt hàng
        for (ChiTietPhieuDatHang ctpdh : phieuDatHang.getChiTietPhieuDatHangs()) {
            updateChiTietPhieuDatHang(ctpdh);
        }
    }

    public void updateChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws SQLException {
        String sql = "UPDATE ChiTietPhieuDatHang SET soLuong = ?, donGia = ?, thanhTien = ? WHERE maCTPDH = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, chiTietPhieuDatHang.getSoLuong());
            pstmt.setDouble(2, chiTietPhieuDatHang.getDonGia());
            pstmt.setDouble(3, chiTietPhieuDatHang.getThanhTien());
            pstmt.setString(4, chiTietPhieuDatHang.getMaCTPDH());
            pstmt.executeUpdate();
        }
    }

    public PhieuDatHang getPhieuDatHang(String maPhieu) throws SQLException {
        String sql = "SELECT * FROM PhieuDatHang WHERE maPhieu = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maPhieu);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                PhieuDatHang phieuDatHang = new PhieuDatHang(
                    rs.getString("maPhieu"),
                    rs.getDate("ngayGioDat"),
                    rs.getString("maNCC"),
                    rs.getString("diachiNhanHang"),
                    rs.getDate("ngayGiao"),
                    rs.getDouble("tongTien")
                );

                // Lấy chi tiết phiếu đặt hàng
                List<ChiTietPhieuDatHang> chiTietPhieuDatHangs = getChiTietPhieuDatHang(maPhieu);
                phieuDatHang.setChiTietPhieuDatHangs(chiTietPhieuDatHangs);
                return phieuDatHang;
            }
        }
        return null;
    }

    public List<ChiTietPhieuDatHang> getChiTietPhieuDatHang(String maPhieu) throws SQLException {
        List<ChiTietPhieuDatHang> chiTietPhieuDatHangs = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietPhieuDatHang WHERE maPhieu = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maPhieu);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                chiTietPhieuDatHangs.add(new ChiTietPhieuDatHang(
                    rs.getString("maCTPDH"),
                    rs.getString("maPhieu"),
                    rs.getString("maSP"),
                    rs.getString("tenSP"),
                    rs.getInt("soLuong"),
                    rs.getDouble("donGia"),
                    rs.getDouble("thanhTien")
                ));
            }
        }
        return chiTietPhieuDatHangs;
    }
}