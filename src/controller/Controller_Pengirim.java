package controller;

import view.Form_Pengirim;
import java.sql.SQLException;

public interface Controller_Pengirim {
    public void Simpan(Form_Pengirim pengirim) throws SQLException;
    public void Ubah(Form_Pengirim pengirim) throws SQLException;
    public void Hapus(Form_Pengirim pengirim) throws SQLException;
    public void Tampil(Form_Pengirim pengirim) throws SQLException;
    public void Baru(Form_Pengirim pengirim);
    public void KlikTabel(Form_Pengirim pengirim) throws SQLException;
}
