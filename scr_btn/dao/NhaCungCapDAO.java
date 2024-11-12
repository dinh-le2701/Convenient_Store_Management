package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connectDB.DatabaseConnection;
import entity.NhaCungCap;

public class NhaCungCapDAO { 
    public void addNhaCungCap(NhaCungCap nhaCungCap) throws SQLException { 
        String sql = "INSERT INTO NhaCungCap (maNCC, tenNCC, diaChi, sdt, email, webSite) VALUES (?, ?, ?, ?, ?, ?)"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, nhaCungCap.getMaNCC()); 
            pstmt.setString(2, nhaCungCap.getTenNCC()); 
            pstmt.setString(3, nhaCungCap.getDiaChi()); 
            pstmt.setBigDecimal(4, new BigDecimal(nhaCungCap.getSdt())); // Chuyển đổi sdt thành BigDecimal 
            pstmt.setString(5, nhaCungCap.getEmail()); 
            pstmt.setString(6, nhaCungCap.getWebSite()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void updateNhaCungCap(NhaCungCap nhaCungCap) throws SQLException { 
        String sql = "UPDATE NhaCungCap SET tenNCC = ?, diaChi = ?, sdt = ?, email = ?, webSite = ? WHERE maNCC = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, nhaCungCap.getTenNCC()); 
            pstmt.setString(2, nhaCungCap.getDiaChi()); 
            pstmt.setBigDecimal(3, new BigDecimal(nhaCungCap.getSdt())); // Chuyển đổi sdt thành BigDecimal 
            pstmt.setString(4, nhaCungCap.getEmail()); 
            pstmt.setString(5, nhaCungCap.getWebSite()); 
            pstmt.setString(6, nhaCungCap.getMaNCC()); 
            pstmt.executeUpdate(); 
        } 
    } 

    public void deleteNhaCungCap(String maNCC) throws SQLException { 
        String sql = "DELETE FROM NhaCungCap WHERE maNCC = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maNCC); 
            pstmt.executeUpdate(); 
        } 
    } 

    public NhaCungCap getNhaCungCap(String maNCC) throws SQLException { 
        String sql = "SELECT * FROM NhaCungCap WHERE maNCC = ?"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.setString(1, maNCC); 
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
                return new NhaCungCap( 
                    rs.getString("maNCC"), 
                    rs.getString("tenNCC"), 
                    rs.getString("diaChi"), 
                    rs.getBigDecimal("sdt").toString(), // Chuyển đổi BigDecimal thành String 
                    rs.getString("email"), 
                    rs.getString("webSite") 
                ); 
            } 
        } 
        return null; 
    } 

    public List<NhaCungCap> getAllNhaCungCap() throws SQLException { 
        List<NhaCungCap> nhaCungCaps = new ArrayList<>(); 
        String sql = "SELECT * FROM NhaCungCap"; 
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             ResultSet rs = pstmt.executeQuery()) { 
            while (rs.next()) { 
                nhaCungCaps.add(new NhaCungCap( 
                    rs.getString("maNCC"), 
                    rs.getString("tenNCC"), 
                    rs.getString("diaChi"), 
                    rs.getBigDecimal("sdt").toString(), // Chuyển đổi BigDecimal thành String 
                    rs.getString("email"), 
                    rs.getString("webSite") 
                )); 
            } 
        } 
        return nhaCungCaps; 
    } 
}
