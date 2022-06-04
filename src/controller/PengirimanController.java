package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.PengirimanModel;
import view.PengirimanView;
import view.LoginView;
import view.RegistrasiView;

public class PengirimanController {
    PengirimanModel pengirimanmodel;
    PengirimanView pengirimanview;
    LoginView loginview;
    RegistrasiView registrasiview;
    Object header[] = {"Id", "Pengirim", "Penerima", "Kurir", "Alamat", "Nama Barang", "Jarak (km)", "Berat (kg)", "Ongkir"};
  


    public PengirimanController(LoginView loginview,  PengirimanModel pengirimanmodel, PengirimanView pengirimanview, RegistrasiView registrasiview) {
        this.pengirimanmodel = pengirimanmodel;
        this. pengirimanview = pengirimanview;
        this. loginview = loginview;
        this.registrasiview = registrasiview;
         
        loginview.btnLogin.addActionListener((ActionEvent arg0) -> {
            String user = loginview.getUser();
            String pass = loginview.getPass();
              
            if(pengirimanmodel .getLogin(user,pass)!=0)
            {
                pengirimanview.setVisible(false);
            }
            else
            {
                pengirimanview.setVisible(true);
                loginview.setVisible(false);
            }
        });
          
        loginview.btnRegister.addActionListener((ActionEvent arg0) -> {
              
            registrasiview.setVisible(true);
            loginview.setVisible(false);
        
        });
          
        registrasiview.addUser.addActionListener((ActionEvent arg0) -> {
            String user = registrasiview.getUser();
            String pass = registrasiview.getPass();
              
            if(pengirimanmodel.Registrasi(user, pass)!=0)
            {
                loginview.setVisible(false); 
                registrasiview.setUser();
                registrasiview.setPass();
            }
            else
            {
                loginview.setVisible(true); 
                loginview.user.setText(user);
                loginview.pass.setText(pass);
                registrasiview.getPass();
                registrasiview.setVisible(false);
            }
        });
          
        if (pengirimanmodel .getKasirdata()!=0) {
            String[][] dataPengiriman = pengirimanmodel.tampilData();
            pengirimanview.table.setModel((new JTable(dataPengiriman, header)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        pengirimanview.btnSimpan.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = pengirimanview.getId();
                String pengirim = pengirimanview.getPengirim();
                String penerima = pengirimanview.getPenerima();
                String kurir = pengirimanview.getKurir();
                String alamat = pengirimanview.getAlamat();
                String barang = pengirimanview.getBarang();
                String jarak= pengirimanview.getJarak();
                String berat = pengirimanview.getBerat();
                
                pengirimanmodel.insertData(id, pengirim,  penerima,  kurir, alamat,  barang,  jarak, berat);
                String[][] dataPengiriman = pengirimanmodel.tampilData();
               pengirimanview.table.setModel((new JTable(dataPengiriman, header)).getModel());
            }
        });
        
        pengirimanview.btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = pengirimanview.getId();
                String pengirim = pengirimanview.getPengirim();
                String penerima = pengirimanview.getPenerima();
                String kurir = pengirimanview.getKurir();
                String alamat = pengirimanview.getAlamat();
                String barang = pengirimanview.getBarang();
                String jarak= pengirimanview.getJarak();
                String berat = pengirimanview.getBerat();
               
                pengirimanmodel.updateData(id, pengirim,  penerima,  kurir, alamat,  barang, jarak, berat);
                String[][] dataPengiriman = pengirimanmodel.tampilData();
                pengirimanview.table.setModel((new JTable(dataPengiriman, header)).getModel());
            }
        });
        
        pengirimanview.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = pengirimanview.getId();
                
                pengirimanmodel.deleteData(id);
                String[][] dataPengiriman =  pengirimanmodel.tampilData();
                pengirimanview.table.setModel((new JTable(dataPengiriman, header)).getModel());
            }
        });
        
        pengirimanview.btnBaru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               pengirimanview.setId();
               pengirimanview.setPengirim();
               pengirimanview.setPenerima();
               pengirimanview.setKurir();
               pengirimanview.setAlamat();
               pengirimanview.setBarang();
               pengirimanview.setJarak();
               pengirimanview.setBerat();
            }
        });
        
        pengirimanview.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int rows = pengirimanview.table.getSelectedRow();
                
                String id = pengirimanview.table.getValueAt(rows, 0).toString();
                String pengirim = pengirimanview.table.getValueAt(rows, 1).toString();
                String penerima = pengirimanview.table.getValueAt(rows, 2).toString();
                String kurir = pengirimanview.table.getValueAt(rows, 3).toString();
                String alamat = pengirimanview.table.getValueAt(rows, 4).toString();
                String barang = pengirimanview.table.getValueAt(rows, 5).toString();
                String jarak = pengirimanview.table.getValueAt(rows, 6).toString();
                String berat= pengirimanview.table.getValueAt(rows, 7).toString();
                
                pengirimanview.id.setText(id);
                pengirimanview.pengirim.setText(pengirim);
                pengirimanview.penerima.setText(penerima);
                pengirimanview.kurir.setText(kurir);
                pengirimanview.alamat.setText(alamat);
                pengirimanview.barang.setText(barang);
                pengirimanview.jarak.setText(jarak);
                pengirimanview.berat.setText(berat);
            }
        });
    }
}
