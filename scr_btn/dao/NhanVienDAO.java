package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.NhanVien;

public class NhanVienDAO { 
    public void addNhanVien(NhanVien nhanVien) throws SQLException { 
        String sql = "INSERT INTO NhanVien (maNV, tenNV, tuoi, gioiTinh, sdt, email) VALUES (?, ?, ?, ?, ?, ?)"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, nhanVien.getMaNV()); 
            pstmt.setString(2, nhanVien.getTenNV()); 
            pstmt.setInt(3, nhanVien.getTuoi()); 
            pstmt.setString(4, nhanVien.getGioiTinh()); 
            pstmt.setBigDecimal(5, new BigDecimal(nhanVien.getSdt())); // Chuyển đổi sdt thành BigDecimal 
            pstmt.setString(6, nhanVien.getEmail()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void updateNhanVien(NhanVien nhanVien) throws SQLException { 
        String sql = "UPDATE NhanVien SET tenNV = ?, tuoi = ?, gioiTinh = ?, sdt = ?, email = ? WHERE maNV = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, nhanVien.getTenNV()); 
            pstmt.setInt(2, nhanVien.getTuoi()); 
            pstmt.setString(3, nhanVien.getGioiTinh()); 
            pstmt.setBigDecimal(4, new BigDecimal(nhanVien.getSdt())); // Chuyển đổi sdt thành BigDecimal 
            pstmt.setString(5, nhanVien.getEmail()); 
            pstmt.setString(6, nhanVien.getMaNV()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void deleteNhanVien(String maNV) throws SQLException { 
        String sql = "DELETE FROM NhanVien WHERE maNV = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maNV); 
            pstmt.executeUpdate(); 
        } 
    } 

    public NhanVien getNhanVien(String maNV) throws SQLException { 
        String sql = "SELECT * FROM NhanVien WHERE maNV = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maNV); 
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
                return new NhanVien( 
                    rs.getString("maNV"), 
                    rs.getString("tenNV"), 
                    rs.getInt("tuoi"), 
                    rs.getString("gioiTinh"), 
                    rs.getBigDecimal("sdt").toString(), // Chuyển đổi BigDecimal thành String 
                    rs.getString("email") 
                ); 
            } 
        } 
        return null; 
    } 

    public List<NhanVien> getAllNhanVien() throws SQLException { 
        List<NhanVien> nhanViens = new ArrayList<>(); 
        String sql = "SELECT * FROM NhanVien"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             ResultSet rs = pstmt.executeQuery()) { 
            while (rs.next()) { 
                nhanViens.add(new NhanVien( 
                    rs.getString("maNV"), 
                    rs.getString("tenNV"), 
                    rs.getInt("tuoi"), 
                    rs.getString("gioiTinh"), 
                    rs.getBigDecimal("sdt").toString(), // Chuyển đổi BigDecimal thành String 
                    rs.getString("email") 
                )); 
            } 
        } 
        return nhanViens; 
    } 
}