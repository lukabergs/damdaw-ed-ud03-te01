package com.lukabergs.ED03TE01;

import java.util.ArrayList;

public class Ruta {

   // Atributos
   private String titulo; 
   private ArrayList<Punto> ruta;
   
   // Constructor: Recibe el nombre de la ruta y crea un ArrayList vacÃ­o
   // No necesita saber el número de puntos. Se adapta.
   public Ruta(String titulo) {
      this.titulo = titulo;
      ruta = new ArrayList<Punto>();
   }
   
   // Métodos get
   // Obtiene la longitud del ArrayList
   public int getLongitud() {
      return ruta.size();
   }
   
   // Obtiene el título de la ruta
   public String getTitulo() {
      return titulo;
   }
   
   // Obtiene el punto con el índice indicado
   public Punto getPunto(int indice) {
      // Copia
      Punto copia = new Punto(ruta.get(indice));
      return copia;
   }
   
   // Métodos set
   // Modifica el nombre y las coordenadas del punto con el indice indicado
   public void setPunto(int indice, String etiqueta, int x, int y) {
      Punto cambiar = ruta.get(indice);
      cambiar.setCoordenadas(x, y);
      cambiar.setEtiqueta(etiqueta);
      ruta.set(indice, cambiar);
   }
   
   // Modifica el título de la ruta
   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }
   
   // Métodos add
   // Añade las coordenadas x e y a la ruta
   public void addPunto(String etiqueta, int x, int y) {
      Punto nuevo = new Punto(y, x, etiqueta);
      ruta.add(nuevo);
   }
   
   // Métodos add
   // Añade un punto a la ruta
   public void addPunto(Punto otroPunto) {
      if (otroPunto == null) {
          throw new IllegalArgumentException("Valor del punto incorrecto");
      }
      // Copia del punto
      Punto copia = new Punto(otroPunto);
      ruta.add(copia);
   }
   
   // Método toString: Mostrar el nombre y los puntos de la ruta
   public String toString() {
      String mostrar = "RUTA " + titulo.toUpperCase() + "\n";
  mostrar += "1. " + ruta.get(0);
  for (int i = 1; i < ruta.size(); i++) {      
     mostrar += " --> " + (i + 1) + ". " + ruta.get(i);                  
  }
  mostrar += "\n";
      return mostrar;
   }
   
   // Método para calcular la longitud de la ruta
   public double calcularDistancia() {
      double longitud = 0;
      for (int i = 0; i < ruta.size() - 1; i++) {
      
         // Calcular distancia entre 2 puntos consecutivos y sumarla
         Punto p1 = ruta.get(i);
         Punto p2 = ruta.get(i + 1);
         longitud += p1.distanciaPuntos(p2);
      }
      return longitud;
   }
   
   public boolean esDificil() {
       double distancia = calcularDistancia();
       if (distancia > 20) {
           return true;
       }
       return false;
   }
}