package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.ChiTietPhieuDatHang;

public class ChiTietPhieuDatHangDAO { 
    public void addChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws SQLException { 
        String sql = "INSERT INTO ChiTietPhieuDatHang (maCTP, maPhieu, maSP, soLuong, donGia, thanhTien) VALUES (?, ?, ?, ?, ?, ?)"; 
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

    public void updateChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws SQLException { 
        String sql = "UPDATE ChiTietPhieuDatHang SET maPhieu = ?, maSP = ?, soLuong = ?, donGia = ?, thanhTien = ? WHERE maCTP = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, chiTietPhieuDatHang.getMaPhieu()); 
            pstmt.setString(2, chiTietPhieuDatHang.getMaSP()); 
            pstmt.setInt(3, chiTietPhieuDatHang.getSoLuong()); 
            pstmt.setDouble(4, chiTietPhieuDatHang.getDonGia()); 
            pstmt.setDouble(5, chiTietPhieuDatHang.getThanhTien()); 
            pstmt.setString(6, chiTietPhieuDatHang.getMaCTPDH()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void deleteChiTietPhieuDatHang(String maCTP) throws SQLException { 
        String sql = "DELETE FROM ChiTietPhieuDatHang WHERE maCTP = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maCTP); 
            pstmt.executeUpdate(); 
        } 
    } 

    public ChiTietPhieuDatHang getChiTietPhieuDatHang(String maCTP) throws SQLException { 
        String sql = "SELECT * FROM ChiTietPhieuDatHang WHERE maCTP = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maCTP); 
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
                return new ChiTietPhieuDatHang( 
                    rs.getString("maCTP"), 
                    rs.getString("maPhieu"), 
                    rs.getString("maSP"),
                    rs.getString("tenSP"),
                    rs.getInt("soLuong"), 
                    rs.getDouble("donGia"), 
                    rs.getDouble("thanhTien") 
                ); 
            } 
        } 
        return null; 
    } 

    public List<ChiTietPhieuDatHang> getAllChiTietPhieuDatHang() throws SQLException { 
        List<ChiTietPhieuDatHang> chiTietPhieuDatHangs = new ArrayList<>(); 
        String sql = "SELECT * FROM ChiTietPhieuDatHang"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             ResultSet rs = pstmt.executeQuery()) { 
            while (rs.next()) { 
                chiTietPhieuDatHangs.add(new ChiTietPhieuDatHang( 
                		rs.getString("maCTP"), 
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
