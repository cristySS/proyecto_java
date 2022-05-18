
/*
Programa: Hello World

Programa en Java

Autor: Cristina Sánchez Saldaña
Fecha: 06 de mayo 2022
*/
package com.sic;
import java.sql.*;
/**
 * Hello world!
 * consultar datos de MySql
 */
public class App {
    public static void main(String[] args) {
        // System.out.println( "Hello World!" );
        //Try-Catch para manejo de errores
        try {
        //Llamada a la libreria mysql conector
           Class.forName("com.mysql.jdbc.Driver");
           //Nueva conexión                           conexión a localhost |   nombre de bd | ususario mysql | contraseña  
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "usuariotabla", "pass1234");
           //Nuevo statement para llamada de datos
           Statement stmt = con.createStatement();
           //Creación de Query | llamada a todos los datos de la tabla alumnos
           ResultSet rs = stmt.executeQuery("select * from alumnos");
           //Ciclo de todos los elementos obtenidos por el query
           while (rs.next())
           //Impresión de los valores
           System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ " " + rs.getString(4));
           //Se cierra la conexión 
           con.close();
        } catch (Exception e) {
          //Imprimir errores 
          System.out.println(e);
          }
    }
}
