/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hewlett-Packard
 */
public class PengirimanModel implements Perhitungan {
   
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pengiriman";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;
    
    public PengirimanModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    @Override
    public int average(int jrk, int brt) {
        return (jrk*brt);
    }
    
    public int getKasirdata(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `transaksi`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query );

            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public void insertKasir(String id, String penerima, String pengirim, String kurir, String alamat, String barang, String jarak, String berat){
        try {
            
            int jrk, brt, score;
           jrk = Integer.parseInt(jarak);
            brt = Integer.parseInt(berat);
           
            
            score = average(jrk, brt);
            

          
            statement = connection.createStatement();
            statement.executeUpdate("insert into `transaksi` (`id`, `penerima`, `pengirim`, `kurir`, `alamat` , `nama_barang`, `berat`,`jarak`,`biaya`) " + 
                        " values  ('" + id + "','" + penerima + "','" + pengirim + "','" + kurir + "','" +alamat+ "','" + barang+ "'," + brt + ","+ jrk +","+ score +")");
            
            JOptionPane.showMessageDialog(null, "Input Data Berhasil");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("")){
                JOptionPane.showMessageDialog(null, "Mohon Lengkapi Data");
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal di Input");
            }     
        }
    }
    
    public String[][] tampilKasir(){
        try{
            int totalData = 0;
            
            String data[][] = new String[getKasirdata()][9];
            
            String query = "SELECT * FROM `transaksi`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
          
            
            while (resultSet.next()){
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("penerima");                
                data[totalData][2] = resultSet.getString("pengirim");
                data[totalData][3] = resultSet.getString("kurir");
                data[totalData][4] = resultSet.getString("alamat");
                data[totalData][5] = resultSet.getString("nama_barang");
                data[totalData][6] = resultSet.getString("berat");
                 data[totalData][7] = resultSet.getString("jarak");
                data[totalData][8] = resultSet.getString("biaya");
              
                totalData++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
    
    public void updateKasir(String id, String penerima, String pengirim, String kurir, String alamat, String barang, String jarak, String berat){
        try {
            int jrk, brt, score;
           jrk = Integer.parseInt(jarak);
            brt = Integer.parseInt(berat);
           
            
            score = average(jrk, brt);
            
    
       
            
            String query = "UPDATE `transaksi` "
                    + "SET "
                    + "`penerima`='" + penerima + "',"
                    + "`pengirim`='" + pengirim + "',"
                    + "`kurir`='" + kurir + "',"
                    + "`alamat`='" + alamat + "',"
                    + "`nama_barang`='" + barang + "',"
                    + "`berat`=" + brt + ","
                    + "`jarak`=" + jrk + ","
                    + "`biaya`="+score
                    + " WHERE id='" + id + "'";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("")){
                JOptionPane.showMessageDialog(null, "Mohon Lengkapi Data");
            }else{
                JOptionPane.showMessageDialog(null, "Update gagal");
            }     
        }
    }
    
    public void deleteKasir (String id) {
        try{
            String query = "DELETE FROM transaksi WHERE id = '"+id+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Success");
            
        }catch(SQLException e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
    
    public int getLogin(String user, String pass){
        int a = 0;
        try {
          
      
       
            String query = "SELECT * FROM `akun` WHERE user ='"+user+"'and pass='"+pass+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query );

            if(resultSet.next()){
                 JOptionPane.showMessageDialog(null, "Login Berhasil");
                  a = 0;
            }
           else
            {
                JOptionPane.showMessageDialog(null, "Login Gagal. Silahkan Cek Username dan Password anda");
                 a = 1;
                
            }
         
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
           
        }
        return a;
       
    }
    
    public int Registrasi(String user, String pass){
         int a = 0;
        try {
            
          
            statement = connection.createStatement();
            statement.executeUpdate("insert into `akun` (`user`, `pass`) " + 
                        " values  ('" + user + "','" + pass +"')");
            
            JOptionPane.showMessageDialog(null, "Input Data Berhasil");
            a = 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("")){
                JOptionPane.showMessageDialog(null, "Mohon Lengkapi Data");
                a =1;
            }else{
                JOptionPane.showMessageDialog(null, "Akun Sudah Ada silahkan gunakan akun lain");
                a=1;
            }     
        }
        return a;
    }
    
}
        
