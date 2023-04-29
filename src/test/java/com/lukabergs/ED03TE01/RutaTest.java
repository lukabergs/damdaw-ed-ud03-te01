/*
 * Clase para testear el código de Ruta.java
 */
package com.lukabergs.ED03TE01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RutaTest {
    
    static Ruta rutaPruebas;
    
    @BeforeEach
    // Inicializa el atributo rutaPruebas a partir del fichero ruta.txt
    // para poder trabajar con él en cada uno de los métodos
    // ruta.txt debe estar ubicado en la carpeta raíz del proyecto
    public void setUp() throws FileNotFoundException {
        Scanner leerDatos = new Scanner(new File("ruta.txt"));
      
        String titulo = leerDatos.nextLine();
        rutaPruebas = new Ruta(titulo);
      
        while (leerDatos.hasNext()) {
               
            // Leer coordenadas
            String etiqueta = leerDatos.next();
            int x = leerDatos.nextInt();
            int y = leerDatos.nextInt();

            // Añadir un punto a la ruta
            rutaPruebas.addPunto(etiqueta, x, y);
        }
    }

    @Test
    void testGetPunto() {
        Punto punto = rutaPruebas.getPunto(1);
        assertEquals("cruce", punto.getEtiqueta());
        assertEquals(0, punto.getX());
        assertEquals(5, punto.getY());
    }

    @Test
    void testAddPunto() {
        rutaPruebas.addPunto("Una cima", 5, 18);
        Punto unaCima = rutaPruebas.getPunto(5);
        Punto otraCima = new Punto(unaCima);
        rutaPruebas.addPunto(otraCima);
        assertNotSame(unaCima, otraCima);
    }
    
    @Test
    void testEsDificil() {
        assertFalse(rutaPruebas.esDificil());
        rutaPruebas.addPunto("Otra cima", 5, 18);
        assertTrue(rutaPruebas.esDificil());
    }

    /**
     * Test parametrizado del método getPunto.
     * Nos permite ejecutar el mismo test con diferentes valores
     * Con @CsvSource definimos los valores para las pruebas
     * name identifica el nombre para trabajar con ese valor
     * index indica la posición en la fila del valor dentro CsvSource
     */
    @DisplayName("Test con muchos datos")
    @ParameterizedTest(name = "{index} => valor={0}, expResult={1}")
    @CsvSource({
            "0, Parking, 0, 0",
            "1, cruce, 0, 5",
            "2, fuente, 0, 10",
            "3, cruce, 0, 15",
            "4, cima, 0, 20"
    })
    
    // Se le pasan como parámetros los valores definidos con @ParameterizedTest
    public void ParameterizedTestGetPunto(int indice, String expEtiqueta, int expX, int expY) {
        Punto puntoPrueba = rutaPruebas.getPunto(indice);
        assertEquals(expEtiqueta, puntoPrueba.getEtiqueta());
        assertEquals(expX, puntoPrueba.getX());
        assertEquals(expY, puntoPrueba.getY());
    }

    /**
     * Test de excepciones.
     * Se comprueba que:
     *      - al pasarle un punto nulo a addPunto se produce la excepción IllegalArgumentException
     *      - al pasarle un indice fuera de rango a getPunto se produce la excepción IndexOutOfBoundsException
     * Permite comprobar precondiciones
     */
    @Test
    public void testExpectedException() {

        assertThrows(IllegalArgumentException.class, () -> {
            rutaPruebas.addPunto(null);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            rutaPruebas.getPunto(5);
        });
    }
}
