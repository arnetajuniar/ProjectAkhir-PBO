package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoginView extends JFrame{
   
    JLabel luser = new JLabel("Username");
    JLabel lpass = new JLabel("Password");

    public JTextField user = new JTextField();
    public JTextField pass = new JTextField();
 
    public JButton btnLogin = new JButton("Login");
    public JButton btnRegister = new JButton("Registrasi");

    public LoginView() {
       
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(400,400);
      
        add(luser);
        luser.setBounds(70, 70, 90, 20);
        add(user);
        user.setBounds(180, 70, 120, 20);
        
        add(lpass);
        lpass.setBounds(70, 100, 90, 20);
        add(pass);
        pass.setBounds(180, 100, 120, 20);
        
        add(btnLogin);
        btnLogin.setBounds(90, 150, 200, 20);
        
        add(btnRegister);
        btnRegister.setBounds(90, 190, 200, 20);
        
    }
    
    public String getUser(){
        return user.getText();
    }
 
    public String getPass(){
        return pass.getText();
    }
    
    public void setUser(){
        user.setText("");
    }
    
    public void setPass(){
        pass.setText("");
    }
    
}

