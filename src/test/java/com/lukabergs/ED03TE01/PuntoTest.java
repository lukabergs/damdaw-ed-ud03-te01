/*
 * Clase para testear el código de Ruta.java
 */
package com.lukabergs.ED03TE01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

@TestMethodOrder(OrderAnnotation.class)
public class PuntoTest {
    
    public PuntoTest() {
        int x = 2;
        int y = 5;
        String etiqueta = "Punto de prueba";
        
        Punto punto = new Punto(x, y, etiqueta);
        
        assertEquals(x, punto.getX());
        assertEquals(y, punto.getY());
        assertEquals(etiqueta, punto.getEtiqueta());
    }
    
    @Test
    @Order(1)
    public void testMoverPunto() {
        int x = 5;
        int y = 7;
        String etiqueta = "Punto de prueba";
        int dx = 3;
        int dy = -2;
        
        Punto puntoPrueba = new Punto(x, y, etiqueta);
        puntoPrueba.moverPunto(dx, dy);
        
        assertEquals(x+dx, puntoPrueba.getX());
        assertEquals(y+dy, puntoPrueba.getY());
    }

    @Disabled
    @Test
    public void testToString() {
        int x = 2;
        int y = 5;
        String etiqueta = "Punto de prueba";
        
        Punto punto = new Punto(x, y, etiqueta);
        String stringEsperado = etiqueta + " (" + x + ", " + y + ")";
        
        assertEquals(stringEsperado, punto.toString());
    }
}
