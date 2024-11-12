package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class HoaDonDAO {

    private static final String INSERT_SQL = "INSERT INTO HoaDon (maHD, ngayGio, tenKH, tenNV, tongTien) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE HoaDon SET ngayGio = ?, tenKH = ?, tenNV = ?, tongTien = ? WHERE maHD = ?";
    private static final String DELETE_SQL = "DELETE FROM HoaDon WHERE maHD = ?";
    private static final String SELECT_SQL = "SELECT * FROM HoaDon WHERE maHD = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM HoaDon";

    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

    // Thêm hóa đơn
    public void addHoaDon(HoaDon hoaDon) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setString(1, hoaDon.getMaHD());
            pstmt.setDate( 2, hoaDon.getNgayGio());
            pstmt.setString(3, hoaDon.getTenKH());
            pstmt.setString(4, hoaDon.getTenNV());
            pstmt.setDouble(5, hoaDon.getTongTien());
            pstmt.executeUpdate();
        }
        for (ChiTietHoaDon chiTiet : hoaDon.getChiTietHoaDons()) {
            chiTietHoaDonDAO.addChiTietHoaDon(chiTiet);
        }
    }

    // Cập nhật hóa đơn
    public void updateHoaDon(HoaDon hoaDon) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
            pstmt.setDate(1, hoaDon.getNgayGio());
            pstmt.setString(2, hoaDon.getTenKH());
            pstmt.setString(3, hoaDon.getTenNV());
            pstmt.setDouble(4, hoaDon.getTongTien());
            pstmt.setString(5, hoaDon.getMaHD());
            pstmt.executeUpdate();
        }
        // Cập nhật chi tiết hóa đơn nếu cần
        for (ChiTietHoaDon chiTiet : hoaDon.getChiTietHoaDons()) {
            chiTietHoaDonDAO.updateChiTietHoaDon(chiTiet);
        }
    }

    // Xóa hóa đơn
    public void deleteHoaDon(String maHD) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
            pstmt.setString(1, maHD);
            pstmt.executeUpdate();
        }
        // Xóa chi tiết hóa đơn liên quan
        List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDAO.getAllChiTietHoaDon();
        for (ChiTietHoaDon chiTiet : chiTietHoaDons) {
            if (chiTiet.getMaHD().equals(maHD)) {
                chiTietHoaDonDAO.deleteChiTietHoaDon(chiTiet.getMaCTHD());
            }
        }
    }

    // Lấy hóa đơn theo mã
    public HoaDon getHoaDon(String maHD) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL)) {
            pstmt.setString(1, maHD);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                HoaDon hoaDon = new HoaDon(
                        rs.getString("maHD"),
                        rs.getDate("ngayGio"),
                        rs.getString("tenKH"),
                        rs.getString("tenNV")
                );
                // Lấy chi tiết hóa đơn liên quan
                List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDAO.getAllChiTietHoaDon();
                for (ChiTietHoaDon chiTiet : chiTietHoaDons) {
                    if (chiTiet.getMaHD().equals(maHD)) {
                        hoaDon.addChiTietHoaDon(chiTiet);
                    }
                }
                return hoaDon;
            }
        }
        return null;
    }

    // Lấy tất cả hóa đơn
    public List<HoaDon> getAllHoaDon() throws SQLException {
        List<HoaDon> hoaDons = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(
                        rs.getString("maHD"),
                        rs.getDate("ngayGio"),
                        rs.getString("tenKH"),
                        rs.getString("tenNV")
                );
                // Lấy chi tiết hóa đơn liên quan
                List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDAO.getAllChiTietHoaDon();
                for (ChiTietHoaDon chiTiet : chiTietHoaDons) {
                    if (chiTiet.getMaHD().equals(hoaDon.getMaHD())) {
                        hoaDon.addChiTietHoaDon(chiTiet);
                    }
                }
                hoaDons.add(hoaDon);
            }
        }
        return hoaDons;
    }
}