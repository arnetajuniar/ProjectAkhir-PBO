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
        
        try{
            Connection con = Koneksi.getKoneksi();
            String sql = "INSERT pengiriman_barang values(?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(1, pengirim.txtID.getText());
            prepare.setString(2, pengirim.txtNamaPengirim.getText());
            prepare.setString(3, pengirim.txtAlamatPengirim.getText());
            prepare.setString(4, pengirim.txtNoHP.getText());
            prepare.setString(5, pengirim.txtTanggalKirim.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            prepare.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            Tampil(pengirim);
            pengirim.setLebarKolom();
        }
    }

    @Override
    public void Ubah(Form_Pengirim pengirim) throws SQLException {
        try{
            Connection con = Koneksi.getKoneksi();
            String sql = "UPDATE pengiriman_barang set nama_pengirim=?, alamat_pengirim=?, kode_pos=?, no_hp=?, tanggal_kirim=? WHERE id=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            
            prepare.setString(5, pengirim.txtID.getText());
            prepare.setString(1, pengirim.txtNamaPengirim.getText());
            prepare.setString(2, pengirim.txtAlamatPengirim.getText());
            prepare.setString(3, pengirim.txtNoHP.getText());
            prepare.setString(4, pengirim.txtTanggalKirim.getText());
            prepare.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            prepare.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
        finally{
            Tampil(pengirim);
            pengirim.setLebarKolom();
            Baru(pengirim);
        }
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
