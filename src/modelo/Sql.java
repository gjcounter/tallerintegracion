package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sql {
    Connection conectar=null;
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(""
                    + "jdbc:mysql://taller4.mysql.database.azure.com:3306/taller3?useSSL=true&requireSSL=false","fcovvb@taller4","Tabla22#");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return conectar;
    }
}