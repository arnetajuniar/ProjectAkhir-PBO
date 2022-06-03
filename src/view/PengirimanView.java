package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PengirimanView extends JFrame{
   
    JLabel lId = new JLabel("ID Pengiriman");
    JLabel lpengirim = new JLabel("Pengirim");
    JLabel lpenerima = new JLabel("Penerima");
    JLabel lkurir = new JLabel("Kurir");
    JLabel lalamat = new JLabel("Alamat");
    JLabel lbarang = new JLabel("Nama Barang");
    JLabel ljarak = new JLabel("Jarak");
    JLabel lberat = new JLabel("Berat");
 
     
 
    
    public JTextField id  = new JTextField();
    public JTextField penerima = new JTextField();
    public JTextField pengirim = new JTextField();
    public JTextField kurir  = new JTextField();
    public JTextField alamat = new JTextField();
    public JTextField barang = new JTextField();
    public JTextField berat  = new JTextField();
    public JTextField jarak= new JTextField();
   
  
    
    public JButton btnSimpan = new JButton("Add");
    public JButton btnUbah = new JButton("Update");
    public JButton btnHapus = new JButton("Delete");
    public JButton btnBaru = new JButton("Clear");
    
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] columnName = {"ID", "Pengirim", "Penerima", "Kurir", "Alamat", "Nama Barang", "Jarak", "Berat", "Biaya"};

    public PengirimanView() {
        dtm = new DefaultTableModel(columnName, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        
        setTitle("Pengiriman Barang");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        setResizable(false);
        setLayout(null);
        setSize(1100, 500);
        
        add(scrollPane);
        scrollPane.setBounds(250, 25, 800, 400);
        
       
        
        add(lId);
        lId.setBounds(20, 20, 90, 20);
        add(id);
        id.setBounds(20, 40, 200, 20);
        
        add(lpengirim);
        lpengirim.setBounds(20, 60, 90, 20);
        add(pengirim);
        pengirim.setBounds(20, 80, 200, 20);
        
        add(lpenerima);
        lpenerima.setBounds(20, 100, 90, 20);
        add(penerima);
        penerima.setBounds(20, 120, 200, 20);
        
        add(lkurir);
        lkurir.setBounds(20, 140, 90, 20);
        add(kurir);
        kurir.setBounds(20, 160, 200, 20);
        
        add(lalamat);
        lalamat.setBounds(20, 180, 90, 20);
        add(alamat);
        alamat.setBounds(20, 200, 200, 20);
        
        add(lbarang);
        lbarang.setBounds(20, 220, 90, 20);
        add(barang);
        barang.setBounds(20, 240, 200, 20);
       
        add(lberat);
        lberat.setBounds(20, 260, 90, 20);
        add(berat);
        berat.setBounds(20, 280, 200, 20);
        
        add(ljarak);
        ljarak.setBounds(20, 300, 90, 20);
        add(jarak);
        jarak.setBounds(20, 320, 200, 20);
        
        
        add(btnSimpan);
        btnSimpan.setBounds(20, 360, 90, 20);
        
        add(btnUbah);
        btnUbah.setBounds(20, 390, 90, 20);
        
        add(btnHapus);
       btnHapus.setBounds(130, 360, 90, 20);
        
        add(btnBaru);
        btnBaru.setBounds(130, 390, 90, 20);
    }
    
    
    public String getId(){
        return id.getText();
    }
    
    public String getPenerima(){
        return penerima.getText();
    }
    
    public String getPengirim(){
        return pengirim.getText();
    }
    
    public String getKurir(){
        return kurir.getText();
    }
    public String getAlamat(){
        return alamat.getText();
    }
    public String getBarang(){
        return barang.getText();
    }
      public String getBerat(){
        return berat.getText();
    }
    public String getJarak(){
        return jarak.getText();
    }
   
    
   
    
    public void setId(){
        id.setText("");
    }
    
    public void setPengirim(){
        pengirim.setText("");
    }
    
    public void setPenerima(){
        penerima.setText("");
    }
    
    public void setKurir(){
        kurir.setText("");
    }
    public void setAlamat(){
        alamat.setText("");
    }
    
    public void setBarang(){
        barang.setText("");
    }
     public void setBerat(){
        berat.setText("");
    }
    
    public void setJarak(){
        jarak.setText("");
    }
    
    
}

