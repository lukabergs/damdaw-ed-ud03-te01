package com.lukabergs.ED03TE01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RutaCliente {
   public static void main(String[] args) throws FileNotFoundException {
        
      // Crea una ruta a partir de los datos de un fichero
      Ruta miRuta = crearRuta();
            
      // Mostrar ruta
      System.out.println(miRuta);
      
      // Calcular la longitud de la ruta
      double longitud = miRuta.calcularDistancia();
      System.out.printf("Longitud total de la ruta: %.2f", longitud);
   }
   
   // Método que lee un fichero y crea una ruta a partir de sus datos
   public static Ruta crearRuta() throws FileNotFoundException {
   
      Scanner leerDatos = new Scanner(new File("ruta.txt"));
      
      String titulo = leerDatos.nextLine();
      Ruta miRuta = new Ruta(titulo);
      
      while (leerDatos.hasNext()) {
               
         // Leer coordenadas
         String etiqueta = leerDatos.next();
         int x = leerDatos.nextInt();
         int y = leerDatos.nextInt();
                  
         // Añadir un punto a la ruta
         miRuta.addPunto(etiqueta, x, y);
      }
      return miRuta;
   }
}