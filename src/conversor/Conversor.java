/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 * @authors: 
 * Luciano Salgado
 * Gisele Galera
 * Lionel Bacsansky
 */

/**
 * La CLASE Conversor (padre) - es abstracta porque no tiene valor por sí solo
 */
public abstract class Conversor {

    //Declaración de variables
    private Double x;


    /**
     * Constructor vacío, siempre debe estar
     */
    public Conversor() {
    }
    
    /**
     * CONSTRUCTOR de tipo de acceso Protegido - para uso interno - que usa las clases hijas
     * cuando se ejecuta la clase hija - se ejecuta el constructor de la clase hija
     * esta es la función que recibe de la clase hija
     * y lo guarda en la propiedad x
     * @param x
     */
    protected Conversor(Double x) {
        this.x = x;
    }

    //MÉTODO abstracto (función) - esta se pisa con las funciones de las clases hijas (override)
    public abstract String getLabelValor1();
    public abstract String getLabelValor2();

    /**
     * MÉTODO PRINCIPAL de la CLASE PADRE (Conversor)- donde se hace la conversión 
     * Las subclases no lo pueden editar, porque es final
     * @param valor
     * @param camino
     * @return Double
     */
    public final Double convertir(Double valor, boolean camino){
        return (camino) ? valor/x : valor*x;
    }

    
}
