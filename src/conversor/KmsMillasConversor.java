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
public class KmsMillasConversor extends Conversor{

    public KmsMillasConversor() {
        super(0.6214);
    }

    @Override
    public String getLabelValor1() {
        return "Kms";
    }

    @Override
    public String getLabelValor2() {
        return "Millas";
    }

    @Override
    public String toString() {
        return "Kms <=> Millas";
    }
    
    public Double convertirValor1Valor2(Double valor) {
        Double valorConvertido = null;
        return valorConvertido;
    }
    
    
}
