/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import controller.PengirimanController;
import java.sql.SQLException;
import model.PengirimanModel;
import view.PengirimanView;
import view.LoginView;
import view.RegistrasiView;

/**
 *
 * @author Hewlett-Packard
 */
public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
    
       LoginView LoginView = new LoginView( );
        RegistrasiView RegistrasiView = new RegistrasiView(); 
        PengirimanView PengirimanView = new PengirimanView();
                  PengirimanModel PengirimanModel = new PengirimanModel( );
                               
         PengirimanController PengirimanController = new PengirimanController( LoginView,  PengirimanModel, PengirimanView, RegistrasiView);

    }
    
}
