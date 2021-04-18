/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 * @authors: 
 * Lionel Bacsansky
 * Gisele Galera
 * Luciano Salgado
 */
public class PieCmConversor extends Conversor{

    
    public PieCmConversor() {
        super(30.48);
    }
    
    @Override
    public String getLabelValor1() {
        return "Pie";
    }

    @Override
    public String getLabelValor2() {
        return "Cm";
    }

    @Override
    public String toString() {
        return "Pie <=> Cms";
    }
       
}
