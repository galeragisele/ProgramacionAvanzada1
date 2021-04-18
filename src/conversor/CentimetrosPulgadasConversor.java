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

//Clase hija que se extiende de la clase padre abstracta Conversor
public class CentimetrosPulgadasConversor extends Conversor{


    //Cuando se instancia esta clase lo que se ejecuta es el constructor CentimetrosPulgasConversor
    public CentimetrosPulgadasConversor() {
        //super = clase padre 
        //a la clase padre (Conversor) le setea el valor de 2.54 en la propiedad X
        //cuando uso SUPER estoy diciendo que ejecute el Constructor Protegido de la clase Padre (Conversor) y le pase este valor
        super(2.54);
    }
   
    //Función que especificas en la clase hijo
    @Override 
    public String getLabelValor1() {
        return "Pulgadas";
    }

    @Override
    public String getLabelValor2() {
        return "Centímetros";
    }

    @Override
    public String toString() {
        return "Pulgadas <=> Cms";
    }

    
    
}
