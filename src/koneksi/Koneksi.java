package koneksi;

import java.sql.*;

public class Koneksi {
    
    private static Connection Koneksi;
    public static Connection getKoneksi(){
        if(Koneksi == null){
            try{
                String url = "jdbc:mysql://localhost/jasapengiriman";
                String username = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Koneksi = DriverManager.getConnection(url, username, password);
                System.out.println("Koneksi Berhasil");
            } catch(Exception ex){
                System.out.println("Koneksi gagal");
            }
        }
        return Koneksi;
    }
}
