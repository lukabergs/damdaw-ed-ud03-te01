package com.lukabergs.ED03TE01;

public class Punto {

	   // Atributos
	   private int x;
	   private int y;
	   private String etiqueta;
	   
	   // Constructores
	   public Punto(int x, int y, String etiqueta) {
	      setCoordenadas(x, y);
	      this.etiqueta = etiqueta;
	   }

	   public Punto(int x, int y) {
	      this(x, y, "");
	   }
	   
	   public Punto() {
	      this(0, 0, "");
	   }
	   
	   public Punto(Punto otroPunto) {
               this(otroPunto.getX(), otroPunto.getY(), otroPunto.getEtiqueta());
	   }

	   // Métodos consultores (get) y modificadores (set)
	   public int getX() {
	      return x;
	   }
	   
	   public int getY() {
	      return y;
	   }
	   
	   public String getEtiqueta() {
	      return etiqueta;
	   }
	   
	   public void setCoordenadas(int x, int y) {
	      this.x = x;
	      this.y = y;
	   }
	   
	   public void setEtiqueta(String etiqueta) {
	      this.etiqueta = etiqueta;
	   }
	   
	   // Método toString para formatear la salida de datos
	   public String toString() {
	      if (etiqueta.equals("")) {
	         return "(" + x + ", " + y + ")";
	      } else {
	         return etiqueta + " (" + x + ", " + y + ")";
	      }
	   }

	   // Calcula la distancia desde el origen (0, 0) a las coordenadas del punto
	   public double distanciaOrigen() {
	      Punto origen = new Punto();
	      return distanciaPuntos(origen);
	   }

	   // Calcula la distancia entre el punto p2 y las coordenadas del punto  
	   public double distanciaPuntos(Punto p2) {
	      return Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2));
	   }

	   // Mueve la coordenada x del punto una distancia dx y la coordenada y otra dy  
	   public void moverPunto(int dx, int dy) {
	      setCoordenadas(x + dx, y + dy);
	   }
	}
