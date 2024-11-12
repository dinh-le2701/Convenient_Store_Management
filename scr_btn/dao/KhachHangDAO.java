package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.KhachHang;

public class KhachHangDAO { 
    public void addKhachHang(KhachHang khachHang) throws SQLException { 
        String sql = "INSERT INTO KhachHang (maKH, tenKH, tuoi, sdt, email) VALUES (?, ?, ?, ?, ?)"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, khachHang.getMaKH()); 
            pstmt.setString(2, khachHang.getTenKH()); 
            pstmt.setInt(3, khachHang.getTuoi()); 
            pstmt.setBigDecimal(4, new BigDecimal(khachHang.getSdt())); // Chuyển đổi sdt thành BigDecimal 
            pstmt.setString(5, khachHang.getEmail()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void updateKhachHang(KhachHang khachHang) throws SQLException { 
        String sql = "UPDATE KhachHang SET tenKH = ?, tuoi = ?, sdt = ?, email = ? WHERE maKH = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, khachHang.getTenKH()); 
            pstmt.setInt(2, khachHang.getTuoi()); 
            pstmt.setBigDecimal(3, new BigDecimal(khachHang.getSdt())); // Chuyển đổi sdt thành BigDecimal 
            pstmt.setString(4, khachHang.getEmail()); 
            pstmt.setString(5, khachHang.getMaKH()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void deleteKhachHang(String maKH) throws SQLException { 
        String sql = "DELETE FROM KhachHang WHERE maKH = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maKH); 
            pstmt.executeUpdate(); 
        } 
    } 

    public KhachHang getKhachHang(String maKH) throws SQLException { 
        String sql = "SELECT * FROM KhachHang WHERE maKH = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maKH); 
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
                return new KhachHang( 
                    rs.getString("maKH"), 
                    rs.getString("tenKH"), 
                    rs.getInt("tuoi"), 
                    rs.getBigDecimal("sdt").toString(), // Chuyển đổi BigDecimal thành String 
                    rs.getString("email") 
                ); 
            } 
        } 
        return null; 
    } 

    public List<KhachHang> getAllKhachHang() throws SQLException { 
        List<KhachHang> khachHangs = new ArrayList<>(); 
        String sql = "SELECT * FROM KhachHang"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             ResultSet rs = pstmt.executeQuery()) { 
            while (rs.next()) { 
                khachHangs.add(new KhachHang( 
                    rs.getString("maKH"), 
                    rs.getString("tenKH"), 
                    rs.getInt("tuoi"), 
                    rs.getBigDecimal("sdt").toString(), // Chuyển đổi BigDecimal thành String 
                    rs.getString("email") 
                )); 
            } 
        } 
        return khachHangs; 
    } 
}
