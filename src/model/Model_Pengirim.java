package model;

import controller.Controller_Pengirim;
import koneksi.Koneksi;
import view.Form_Pengirim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Model_Pengirim implements Controller_Pengirim{
    String jk;
    
    @Override
    public void Simpan(Form_Pengirim pengirim) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Ubah(Form_Pengirim pengirim) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Hapus(Form_Pengirim pengirim) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Tampil(Form_Pengirim pengirim) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void Baru(Form_Pengirim pengirim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void KlikTabel(Form_Pengirim pengirim) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
