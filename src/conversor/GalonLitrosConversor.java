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
public class GalonLitrosConversor extends Conversor{

    public GalonLitrosConversor() {
        super(3.785);
    }

    @Override
    public String getLabelValor1() {
        return "Galon";
    }

    @Override
    public String getLabelValor2() {
        return "Litros";
    }

    @Override
    public String toString() {
        return "Galón <=> Litros";
    }
    
    public Double convertirValor1Valor2(Double valor) {
        Double valorConvertido = null;
        return valorConvertido;
    }
    
    
}
