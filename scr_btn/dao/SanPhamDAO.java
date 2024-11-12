package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.SanPham;

public class SanPhamDAO { 
    public void addSanPham(SanPham sanPham) throws SQLException { 
        String sql = "INSERT INTO SanPham (maSP, tenSP, ngaySX, hanSD, maNCC, giaSP, soLuongTrongKho, loaiSP, donVi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, sanPham.getMaSP()); 
            pstmt.setString(2, sanPham.getTenSP()); 
            pstmt.setDate(3, sanPham.getNgaySX()); 
            pstmt.setDate(4, sanPham.getHanSD()); 
            pstmt.setString(5, sanPham.getMaNCC()); 
            pstmt.setDouble(6, sanPham.getGiaSP()); 
            pstmt.setInt(7, sanPham.getSoLuongTrongKho()); 
            pstmt.setString(8, sanPham.getLoaiSP()); 
            pstmt.setString(9, sanPham.getDonVi()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void updateSanPham(SanPham sanPham) throws SQLException { 
        String sql = "UPDATE SanPham SET tenSP = ?, ngaySX = ?, hanSD = ?, maNCC = ?, giaSP = ?, soLuongTrongKho = ?, loaiSP = ?, donVi = ? WHERE maSP = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, sanPham.getTenSP()); 
            pstmt.setDate(2, sanPham.getNgaySX()); 
            pstmt.setDate(3, sanPham.getHanSD()); 
            pstmt.setString(4, sanPham.getMaNCC()); 
            pstmt.setDouble(5, sanPham.getGiaSP()); 
            pstmt.setInt(6, sanPham.getSoLuongTrongKho()); 
            pstmt.setString(7, sanPham.getLoaiSP()); 
            pstmt.setString(8, sanPham.getDonVi()); 
            pstmt.setString(9, sanPham.getMaSP()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void deleteSanPham(String maSP) throws SQLException { 
        String sql = "DELETE FROM SanPham WHERE maSP = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maSP); 
            pstmt.executeUpdate(); 
    } 
    }

    public SanPham getSanPham(String maSP) throws SQLException { 
        String sql = "SELECT * FROM SanPham WHERE maSP = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maSP); 
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
                return new SanPham( 
                    rs.getString("maSP"), 
                    rs.getString("tenSP"), 
                    rs.getDate("ngaySX"), 
                    rs.getDate("hanSD"), 
                    rs.getString("maNCC"), 
                    rs.getDouble("giaSP"), 
                    rs.getInt("soLuongTrongKho"), 
                    rs.getString("loaiSP"), 
                    rs.getString("donVi") 
                ); 
            } 
        } 
        return null; 
    } 

    public List<SanPham> getAllSanPham() throws SQLException { 
        List<SanPham> sanPhams = new ArrayList<>(); 
        String sql = "SELECT * FROM SanPham"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             ResultSet rs = pstmt.executeQuery()) { 
            while (rs.next()) { 
                sanPhams.add(new SanPham( 
                    rs.getString("maSP"), 
                    rs.getString("tenSP"), 
                    rs.getDate("ngaySX"), 
                    rs.getDate("hanSD"), 
                    rs.getString("maNCC"), 
                    rs.getDouble("giaSP"), 
                    rs.getInt("soLuongTrongKho"), 
                    rs.getString("loaiSP"), 
                    rs.getString("donVi") 
                )); 
            } 
        } 
        return sanPhams; 
    } 
}
