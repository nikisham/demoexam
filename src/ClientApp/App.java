package ClientApp;

import ClientApp.ui.CreateForm;
import ClientApp.ui.SellectAll;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class App {

    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new SellectAll();

    }



    public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demoexam","root","Nikpro2002");
    }
}
