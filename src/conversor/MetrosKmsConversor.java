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
public class MetrosKmsConversor extends Conversor{

    
    public MetrosKmsConversor() {
        super(0.001);
    }
    

    @Override
    public String getLabelValor1() {
        return "Metros";
    }

    @Override
    public String getLabelValor2() {
        return "Kilómetros";
    }

    @Override
    public String toString() {
        return "Mts <=> Kms";
    }
       
}
