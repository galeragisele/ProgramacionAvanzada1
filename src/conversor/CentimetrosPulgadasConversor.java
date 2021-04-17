/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author Luciano
 * @author Gisele
 * @author Lionel
 */

// esta es una clase hija que se extiende de la clase padre Conversor

public class CentimetrosPulgadasConversor extends Conversor{

// cuando se instancia esta clase lo que se ejecuta es el constructor CentimetrosPulgasConversor


    public CentimetrosPulgadasConversor() {
//super = clase padre 
// a la clase padre (Conversor) le setea el valor de 2.54 en la propiedad X
// cuando uso SUPER estoy diciendo que ejecute el Constructor Protegido de la clase Padre (Conversor) y le pase este valor
        super(2.54);
    }
   
    @Override // función que especificas en la clase hijo
    public String getLabelValor1() {
        return "Pulgadas";
    }

    @Override
    public String getLabelValor2() {
        return "Centrimetros";
    }

    @Override
    public String toString() {
        return "Pulgadas <=> Centimetros";
    }

    
    
}
