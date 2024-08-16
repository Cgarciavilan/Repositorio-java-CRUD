/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.claseintroduccionjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cedua
 */
public class LibroCrud {
    int ID_Libro;
    String titulo;
    String autor;
    String editorial;
    int anioPublicacion;
    String ISBN;
    String categoria;
    String estado;
    
    /*
    Este metodo es el encargado de registrar en la base de datos los libros
    */
    
    public void crearLibro(int ID_Libro,  String titulo,  String autor, String editorial, int anioPublicacion,  String ISBN, String categoria, String estado){
        String query = "INSERT INTO Libro (ID_Libro,Título,Autor,Editorial,Año_Publicación,ISBN,Categoría,Estado)VALUES( ? , ?, ?, ?, ?, ?,?,?)";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt =  conn.prepareStatement(query)) {
            pstmt.setInt(1, ID_Libro);
            pstmt.setString(2, titulo);
            pstmt.setString(3, autor);
            pstmt.setString(4, editorial);
            pstmt.setInt(5, anioPublicacion);
            pstmt.setString(6, ISBN);
            pstmt.setString(7, categoria);
            pstmt.setString(8, estado);
            pstmt.executeUpdate();
            
            System.out.println(" Libro creado exitosamente: ");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Excepcion finalizada");
        }

    }
    
    public void leerLibros(){
        String query ="SELECT * FROM Libro";
        try(Connection conn=ConexionBD.getConnection(); Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(query)){
            while (rs.next()){
                System.out.println(rs.getInt("ID_Libro") + "\t"
                                + rs.getString("Título") +"\t"
                                + rs.getString("Autor")  +"\t"
                                + rs.getString("Editorial") +"\t"
                                + rs.getInt("Año_Publicación") + "\t"
                                + rs.getString("ISBN") + "\t"
                                + rs.getString("Categoría") + "\t"
                                + rs.getString("Estado")
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }  finally {
            System.out.println("Excepcion finalizda");
        }   
      }  
    /*
    Este metodo de buscar un libro por su identificador
    */
    
    public void leerLibroPorID(int ID_Libro){
        String query ="SELECT * FROM Libro WHERE ID_Libro = ?";
        try(Connection conn=ConexionBD.getConnection(); Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(query)){
            while (rs.next()){
                System.out.println(rs.getInt("ID_Libro") + "\t"
                                + rs.getString("Título") +"\t"
                                + rs.getString("Autor")  +"\t"
                                + rs.getString("Editorial") +"\t"
                                + rs.getInt("Año_Publicación") + "\t"
                                + rs.getString("ISBN") + "\t"
                                + rs.getString("Categoría") + "\t"
                                + rs.getString("Estado")
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }  finally {
            System.out.println("Excepcion finalizda");
        }   
      }  
    
    /*Metodo encargado de realizar la actualización del estado de un libro  dado por un ID
    
    */
    public void actualizarLibro(int ID_Libro, String nuevoEstado){
        String query = "UPDATE Libro SET Estado = ? WHERE ID_Libro= ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt =  conn.prepareStatement(query)) {
         pstmt.setString(1, nuevoEstado);
         pstmt.setInt(2, ID_Libro);
         pstmt.executeUpdate();
         System.out.println("Estado del libro actualizado con exito");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
            
        }
    
    /*
    Metodo encargado de eliminar un libor por ID
    */
    public void eliminarLibro(int ID_Libro){
        String query = "DELETE FROM Libro WHERE  ID_Libro = ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt =  conn.prepareStatement(query)) {
        
         pstmt.setInt(1, ID_Libro);
         pstmt.executeUpdate();
         System.out.println("Libro Eliminado con exito");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
   }
}
    
   
   


