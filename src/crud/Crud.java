package crud;

import controller.PengirimanController;
import java.sql.SQLException;
import model.PengirimanModel;
import view.PengirimanView;
import view.LoginView;
import view.RegistrasiView;

public class Crud {

    public static void main(String[] args) throws SQLException {
    
       LoginView LoginView = new LoginView( );
        RegistrasiView RegistrasiView = new RegistrasiView(); 
        PengirimanView PengirimanView = new PengirimanView();
                  PengirimanModel PengirimanModel = new PengirimanModel( );
                               
         PengirimanController PengirimanController = new PengirimanController( LoginView,  PengirimanModel, PengirimanView, RegistrasiView);

    }
    
}
