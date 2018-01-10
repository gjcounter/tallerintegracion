package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Registro {
    int codigo;
    int categoria;
    String descripcion;
    String nombre;
    int precio;
    String formato4k;
    
    
    public Registro(int codigo, int categoria, String descripcion, String nombre,  int precio, String formato4k) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.formato4k = formato4k;
    }

    public Registro(){ }
    
    Sql conectara = new Sql();
    //
    public boolean agregar(int codigo, int categoria, String nombre, int precio, String formato4k){
        if( valida_datos(codigo, nombre, precio) ) {
            //Se arma la consulta
            String q=" INSERT INTO taller3.pelicula(codigo,id_categoria,nombre,precio,formato4k) "
                    + "VALUES ( '" + codigo + "','" + categoria + "','"+ nombre +"','" + precio +"','" + formato4k +"');";
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = conectara.conectar().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
         return false;
    }
    
    public boolean eliminar(int codigo){
        boolean res=false;
        String q = " DELETE FROM taller3.pelicula WHERE codigo=" + codigo + "; " ;
        try {
            PreparedStatement pstm = conectara.conectar().prepareStatement(q);
            if (pstm.executeUpdate() == 1){
                res=true;
            }
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return res;
    }
    
    public boolean modificar(int codigo, int categoria, String nombre, int precio, String formato4k){
        String q= "UPDATE taller3.pelicula SET nombre='"+nombre+"', precio='"+precio+"', id_categoria='"+categoria+"', formato4k ='"+formato4k+"'WHERE codigo='"+codigo+"';";
        try {
            PreparedStatement pstm = conectara.conectar().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return false;
    }
    
    public DefaultTableModel buscar(int codigo){
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Código","Nombre","Categoría","Precio","Calidad 4k"};
      try{
         PreparedStatement pstm = conectara.conectar().prepareStatement( "SELECT count(*) as total FROM taller3.pelicula");
         ResultSet res = pstm.executeQuery();
         
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
      
      Object[][] data = new String[registros][9];
      try{
         PreparedStatement pstm = conectara.conectar().prepareStatement("SELECT * FROM taller3.pelicula WHERE codigo ="+codigo+";");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "codigo" );
                data[i][1] = res.getString( "nombre" );
                data[i][2] = nombre_categoria (Integer.parseInt(res.getString( "id_categoria" )));
                data[i][3] = res.getString( "precio" );
                data[i][4] = res.getString( "formato4k" );
            i++;
         }
         res.close();
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
    public DefaultTableModel mostrar(){
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"Código","Nombre","Categoría","Precio","Calidad 4k"};
      try{
         PreparedStatement pstm = conectara.conectar().prepareStatement( "SELECT count(*) as total FROM taller3.pelicula");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
      Object[][] data = new String[registros][9];
      try{
         PreparedStatement pstm = conectara.conectar().prepareStatement("SELECT * FROM taller3.pelicula");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){ 
                data[i][0] = res.getString( "codigo" );
                data[i][1] = res.getString( "nombre" );
                data[i][2] = nombre_categoria (Integer.parseInt(res.getString( "id_categoria" )));
                data[i][3] = res.getString( "precio" );
                data[i][4] = res.getString( "formato4k" );
            i++;
         }
         res.close();
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
    //Metodo para validar datos
    private boolean valida_datos(int codigo, String nombre, int precio){
        if(codigo==0){
            return false;
        }else if(nombre.length() > 0 && precio>0){
            return true;
        }else return false;
    }
    
    private String nombre_categoria (int categoria){
        String nombrecat = "Largometraje";
        switch (categoria){
            case 1: nombrecat = "Largometraje";
                break;
            case 2: nombrecat = "Infantil";
                break;
            case 3: nombrecat = "Documental";
                break;
            case 4: nombrecat = "Musical";
                break;
            case 5: nombrecat = "Drama";
                break;
            case 6: nombrecat = "Comedia";
                break;
            case 7: nombrecat = "Romance";
                break;
        }
        return nombrecat;
    }
    
    
    //consulta1
    public boolean Consulta1(int codigo, String nombre, int precio, String formato4k){
        if( valida_datos(codigo, nombre, precio) ) {
            //Se arma la consulta
            String q=" INSERT INTO taller3.pelicula(codigo,id_categoria,nombre,precio,formato4k) "
                    + "VALUES ( '" + codigo + "',5,'"+ nombre +"','" + precio +"','" + formato4k +"');"; // 5 -> CATEGORIA DRAMA
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = conectara.conectar().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
        return false;
    }
    
    //consulta 2
     public boolean Consulta2(int codigo, String nombre, int precio, String formato4k){
        if( valida_datos(codigo, nombre, precio) ) {
            //Se arma la consulta
            String q=" INSERT INTO taller3.pelicula(codigo,id_categoria,nombre,precio,formato4k) "
                    + "VALUES ( '" + codigo + "',6,'"+ nombre +"','" + precio +"','" + formato4k +"');"; // 6 -> CATEGORIA COMEDIA
            //se ejecuta la consulta
            try {
                PreparedStatement pstm = conectara.conectar().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
        return false;
    }
     
     public DefaultTableModel Consulta4(){
     DefaultTableModel tablemodel = new DefaultTableModel();
     int registros = 0;
     String[] columNames = {"Código","Nombre","Categoría","Precio","Calidad 4k"};
     try{
        PreparedStatement pstm = conectara.conectar().prepareStatement( "SELECT count(*) as total FROM taller3.pelicula WHERE id_categoria = 7;"); //7 = romance
        ResultSet res = pstm.executeQuery();
        res.next();
        registros = res.getInt("total");
        res.close();
     }catch(SQLException e){
        System.err.println( e.getMessage() );
     }
     Object[][] data = new String[registros][9];
     try{
        PreparedStatement pstm = conectara.conectar().prepareStatement("SELECT * FROM taller3.pelicula WHERE id_categoria = 7;");//7 = romance
        ResultSet res = pstm.executeQuery();
        int i=0;
        while(res.next()){
               data[i][0] = res.getString( "codigo" );
               data[i][1] = res.getString( "nombre" );
               data[i][2] = nombre_categoria (Integer.parseInt(res.getString( "id_categoria" )));
               data[i][3] = res.getString( "precio" );
               data[i][4] = res.getString( "formato4k" );
           i++;
        }
        res.close();
        tablemodel.setDataVector(data, columNames );
        }catch(SQLException e){
           System.err.println( e.getMessage() );
       }
       return tablemodel;
   }
    
    public boolean Consulta5(){
        boolean res=false;
        String q = " DELETE FROM taller3.pelicula WHERE precio > 2000; " ;
        try {
            PreparedStatement pstm = conectara.conectar().prepareStatement(q);
            if (pstm.executeUpdate() == 1){
                res=true;
            }
            pstm.close();
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return res;
    }
    
    public boolean Consulta6(){
        String q= "UPDATE taller3.pelicula set nombre = REPLACE(nombre, nombre, CONCAT('P', nombre)) WHERE codigo > 0;";
        try {
            PreparedStatement pstm = conectara.conectar().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
            return false;
        }
        
    }
}
