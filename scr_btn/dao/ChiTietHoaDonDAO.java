package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.ChiTietHoaDon;

public class ChiTietHoaDonDAO {

    // Thêm chi tiết hóa đơn
    public void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException {
        String sql = "INSERT INTO ChiTietHoaDon (maCTHD, maHD, maSP, tenSP, soLuong, donGia, thanhTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, chiTietHoaDon.getMaCTHD());
            pstmt.setString(2, chiTietHoaDon.getMaHD());
            pstmt.setString(3, chiTietHoaDon.getMaSP());
            pstmt.setString(4, chiTietHoaDon.getTenSP());
            pstmt.setInt(5, chiTietHoaDon.getSoLuong());
            pstmt.setDouble(6, chiTietHoaDon.getDonGia());
            pstmt.setDouble(7, chiTietHoaDon.getThanhTien()); // Giữ lại thanhTien
            pstmt.executeUpdate();
        }
    }

    // Cập nhật chi tiết hóa đơn
    public void updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException {
        String sql = "UPDATE ChiTietHoaDon SET maHD = ?, maSP = ?, tenSP = ?, soLuong = ?, donGia = ?, thanhTien = ? WHERE maCTHD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, chiTietHoaDon.getMaHD());
            pstmt.setString(2, chiTietHoaDon.getMaSP());
            pstmt.setString(3, chiTietHoaDon.getTenSP());
            pstmt.setInt(4, chiTietHoaDon.getSoLuong());
            pstmt.setDouble(5, chiTietHoaDon.getDonGia());
            pstmt.setDouble(6, chiTietHoaDon.getThanhTien()); // Cập nhật thanhTien
            pstmt.setString(7, chiTietHoaDon.getMaCTHD());
            pstmt.executeUpdate();
        }
    }

    // Xóa chi tiết hóa đơn
    public void deleteChiTietHoaDon(String maCTHD) throws SQLException {
        String sql = "DELETE FROM ChiTietHoaDon WHERE maCTHD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maCTHD);
            pstmt.executeUpdate();
        }
    }

    // Lấy chi tiết hóa đơn theo mã
    public ChiTietHoaDon getChiTietHoaDon(String maCTHD) throws SQLException {
        String sql = "SELECT * FROM ChiTietHoaDon WHERE maCTHD = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maCTHD);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ChiTietHoaDon(
                        rs.getString("maCTHD"),
                        rs.getString("maHD"),
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuong"),
                        rs.getDouble("donGia"),
                        rs.getDouble("thanhTien") // Lấy thanhTien từ kết quả
                );
            }
        }
        return null;
    }

    // Lấy tất cả chi tiết hóa đơn
    public List<ChiTietHoaDon> getAllChiTietHoaDon() throws SQLException {
        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                chiTietHoaDons.add(new ChiTietHoaDon(
                        rs.getString("maCTHD"),
                        rs.getString("maHD"),
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuong"),
                        rs.getDouble("donGia"),
                        rs.getDouble("th anhTien") // Lấy thanhTien từ kết quả
                ));
            }
        }
        return chiTietHoaDons;
    }
}