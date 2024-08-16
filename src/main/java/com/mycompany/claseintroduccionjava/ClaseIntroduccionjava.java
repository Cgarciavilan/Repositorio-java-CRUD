/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.claseintroduccionjava;

import java.util.Scanner;

/**
 *
 * @author cedua
 */
public class ClaseIntroduccionjava {

    public static void main(String[] args) {
       // System.out.println("Hello World!");
        Scanner scanner=new Scanner(System.in);
        LibroCrud libro=new LibroCrud();
        while (true) {
            System.out.println("Opciones: ");
            System.out.println("1. Crear Libro");
            System.out.println("2. Leer todos los libros");
            System.out.println("3. Leer libro por ID");
            System.out.println("4. Actualizar estado de libro");
            System.out.println("5. Eliminar un libro");
            System.out.println("6. Salir del sistema");
            
            int opcion= scanner.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("ID del libro");
                    int ID_Libro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Titulo: ");
                    String titulo =scanner.nextLine();
                    System.out.println("Autor: ");
                    String autor=scanner.nextLine();
                    System.out.println("Editorial: ");
                    String editorial=scanner.nextLine();
                    System.out.println("Año de Publicacion: ");
                    int anioPublicacion=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("ISBN: ");
                    String ISBN=scanner.nextLine();
                    System.out.println("Categoria: ");
                    String categoria=scanner.nextLine();
                    System.out.println("Estado: ");
                    String estado=scanner.nextLine();
                    libro.crearLibro(ID_Libro, titulo, autor, editorial, anioPublicacion, ISBN, categoria, estado);
                }
                case 2 -> {
                    libro.leerLibros();
                }
                case 3 -> {
                    System.out.println("ID del libro");
                    int ID_Libro = scanner.nextInt();
                    scanner.nextLine();
                    libro.leerLibroPorID(ID_Libro);
                }
                case 4 -> {
                    System.out.println("ID del libro");
                    int ID_Libro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nuevo Estado");
                    String nuevoEstado=scanner.nextLine();
                    libro.actualizarLibro(ID_Libro, nuevoEstado);
                }
                case 5 -> {
                   System.out.println("ID del libro");
                    int ID_Libro = scanner.nextInt();
                    scanner.nextLine();
                    libro.eliminarLibro(ID_Libro);
                }
                case 6 -> {
                     System.out.println("Saliendo del sistema");
                     scanner.close();
                     return;
                }
                default -> System.out.println("Opcion invalida");
            }
            
        }
    }
}
