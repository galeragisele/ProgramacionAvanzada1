package conversor;
// sirve para separar el código (modularidad)
// El package se puede reutilizar en diferentes proyectos
// porción de código que se puede usar en diferentes proyectos

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JTextField;

/**
 * @authors: 
 * Luciano Salgado
 * Gisele Galera
 * Lionel Bacsansky
 */

// clase MAIN - es la que ejecuta el programa
public class Main extends javax.swing.JFrame {

    //Es un ATRIBUTO privado de tipo LISTA que contiene objetos de la clase abstracta Conversor (clase PADRE)
    //la lista se llama CONVERSORES
    // la inicializa como un nuevo array
    private List<Conversor> conversores = new ArrayList<>();

    // ATRIBUTO (variable) de tipo boolean que define hacia que lado se va a realizar la conversion
    //si va a ser valor1 => valor2 o viceversa
    private boolean camino;
    

    /**
     * CONSTRUCTOR del programa
     * Acá se inicia el programa
     * @return void
     */
    public Main() {
        // llama el MÉTODO que crea el FORMULARIO
        initComponents();
        //cambiar el texto de la barra de titulo
        setTitle("TP1 - Conversor");
        // es una función para centrar la ventana
        setLocationRelativeTo(null);

        //agrego a lista todas las clases hijas
        conversores.add(new CentimetrosPulgadasConversor());
        conversores.add(new KmsMillasConversor());
        conversores.add(new MetrosKmsConversor());
        conversores.add(new GalonLitrosConversor());
        conversores.add(new PieCmConversor());

        // recorre la lista de conversores (forEach)         
        for (Conversor conversor : conversores) {
            //al objeto jcbConversion (combobox) - que se va agregando los items (conversores)
            jcbConversion.addItem(conversor.toString());
        }
        
        // ejecuta el método setText (el cual asigna los valores a los jLabels)
        setText();
    }
    
    /**
     * Devuelve el conversor seleccionado en el combobox
     * @return Conversor
     */
    private Conversor getConversorSeleccionado(){
        return conversores.get(jcbConversion.getSelectedIndex());
    }

    /**
     * Llama al método - pone la etiqueta sin valor
     * los nombres de las etiquetas dependen de la clase hija seleccionada
     * Blanquea los JTextField
     * @return void
     */
    private void setText() {
        jlValor1.setText(getConversorSeleccionado().getLabelValor1());
        jlValor2.setText(getConversorSeleccionado().getLabelValor2());
        blanquearFields();
    }
    
    /**
     * Este método sirve para blanquear los JTextFields
     * @return void
     */
    private void blanquearFields() {
        jtfValor1.setText("");
        jtfValor2.setText("");
    }
    
    /**
     * Lanzar error en pantalla, cuando no se puede realizar la conversión
     * @param JTextField jtf
     * @return void
     */
    private void error(JTextField jtf){
        
        //Mostrar el mensaje en el formulario por pantalla
        JOptionPane.showMessageDialog(this, "No se pudo convertir el numero '" + jtf.getText() + "'", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        //Blanquear JTextField
        blanquearFields();  
              
    }

    /**
     * Cuando se pulsa ENTER o el boton CONVERTIR - se ejecuta este MÉTODO
     * @param JTextField jtf
     * @return String
     */
    private String convertir (JTextField jtf){

        //Declaración de variables
        String valorString;
        Double valor;
        Double retorno;
        String retornoString;
        
        //Reemplazar "," por "."
        valorString = jtf.getText().replace(",", ".");
        
        //Convertir (parsear/castear) el valor de tipo string en tipo numerico decimal
        try {   
            valor = Double.valueOf(valorString);
        }
        //Si no puede convertir de string a número --- devuelve una excepcion 
        catch (NumberFormatException e) {
            //Mostrar el mensaje error
            error(jtf);
            
            //Mostrar mensaje de error por consola
            System.out.println(e.getMessage());
            
            //Punto de escape, para que no continue con la ejecución
            return null;
        }
        
        //Ver si tiene algun caracter L long, F float, D;
        if (valorString.toLowerCase().contains("l") ||
            valorString.toLowerCase().contains("f") ||
            valorString.toLowerCase().contains("d") ){
            //Mostrar error en pantalla
            error(jtf);
            
            //Mostrar mensaje de error por consola
            System.out.println("contiene L, F ó D");
            
            //Punto de escape, para que no continue con la ejecución
            return null;
        }
        
        //Obtiene el conversor seleccionado
        Conversor conversor = getConversorSeleccionado();
        
        //Ejecuta el METODO Convertir con el valor del cbb (getText)
        retorno = conversor.convertir(valor, camino);
        
        //Convertir el valor en string para mostrar en el JTextField correspondiente
        retornoString = String.format("%.3f", retorno);
        
        //Retorna el valor convertido, en forma de String, listo para hacer un setText al JTextField
        return retornoString;
    }
   
    /**
     * Esta funcion valida que haya que convertir con la tecla enter
     * Evita el bug de bucle cuando aparece el error y tocas enter para quitar el cartel
     * pero quiere volver a convertir.
     * @param evt
     * @return boolean
     */
    private boolean convertirConEnter(java.awt.event.KeyEvent evt){
        return evt.getKeyChar()==KeyEvent.VK_ENTER && 
            (!"".equals(jtfValor1.getText()) ||
            (!"".equals(jtfValor2.getText()) ));
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    // MÉTODO - lo que hace es crear el FORMULARIO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlValor1 = new javax.swing.JLabel();
        jtfValor1 = new javax.swing.JTextField();
        jbConvertir = new javax.swing.JButton();
        jlValor2 = new javax.swing.JLabel();
        jtfValor2 = new javax.swing.JTextField();
        jcbConversion = new javax.swing.JComboBox<>();
        jlConversion = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jbConsigna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlValor1.setText("jlValor1");

        jtfValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfValor1KeyReleased(evt);
            }
        });

        jbConvertir.setText("Convertir");
        jbConvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConvertirActionPerformed(evt);
            }
        });

        jlValor2.setText("jlValor2");

        jtfValor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfValor2KeyReleased(evt);
            }
        });

        jcbConversion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbConversionItemStateChanged(evt);
            }
        });

        jlConversion.setText("Conversión");

        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Conversor");

        jbConsigna.setText("?");
        jbConsigna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsignaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlValor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlConversion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlValor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfValor1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfValor2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbConversion, 0, 175, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 98, Short.MAX_VALUE)
                        .addComponent(jbConvertir)
                        .addGap(53, 53, 53)
                        .addComponent(jbConsigna)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbConversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlConversion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlValor1)
                    .addComponent(jtfValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlValor2)
                    .addComponent(jtfValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConvertir)
                    .addComponent(jbConsigna))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este metodo está asignado al evento del ENTER sobre el elemento 1
     * @param evt 
     * @return void
     */
    private void jtfValor1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValor1KeyReleased
        camino = false;
        //Si se toca la tecla enter hay texto en alguno de los 2 JTextFields
        if(convertirConEnter(evt)){
            jtfValor2.setText(convertir(jtfValor1));
        }
    }//GEN-LAST:event_jtfValor1KeyReleased

    /**
     * Este metodo realiza la conversion y asignación en los TextField
     * Lo realiza en un camino u otro, dependiento cual haya sido el ultimo JTextfield editado
     * @param evt 
     * @return void
     */
    private void jbConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConvertirActionPerformed
        if (camino) {
            jtfValor1.setText(convertir(jtfValor2));
        } else {
            jtfValor2.setText(convertir(jtfValor1));
        }
    }//GEN-LAST:event_jbConvertirActionPerformed

    /**
     * Es un MÉTODO que está asignado al evento del ENTER sobre el elemento 2
     * @param evt 
     * @return void
     */
    private void jtfValor2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValor2KeyReleased
        camino = true;
        if(convertirConEnter(evt)){
            jtfValor1.setText(convertir(jtfValor2));
        }
    }//GEN-LAST:event_jtfValor2KeyReleased

    /**
     * cuando cambias el combo se ejecuta es MÉTODO - etiquetas (nombre de los labels y blanqueo de JTextField)        
     * @param evt 
     */
    private void jcbConversionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbConversionItemStateChanged
        setText();
    }//GEN-LAST:event_jcbConversionItemStateChanged

    private void jbConsignaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsignaActionPerformed
        String text = "<html>"
                    + "<h2>Programación I - UNLAM</h2><br>"
                    + "<h3>Trabajo realizado por Grupo X:</h3>"
                    + " * Luciano Salgado<br>"
                    + " * Gisele Galera<br>"
                    + " * Lionel Bacsansky<br>"
                    + "<h4>Consigna:</h2><br>"
                    + "<div>"
                    + "El conversor genérico debe tener las siguientes funcionalidades:<br>"
                    + "✔ Contener al menor 5 tipos de conversores. Pueden incluir los dos vistos en clase.<br>"
                    + "✔ Dos TextFields, con UN solo botón para convertir.<br>"
                    + "✔ Presionando ENTER sobre los TextFields, debe convertir.<br>"
                    + "✔ No contener código repetido, esto es reutilizar sentencias de código que se necesitan en eventos diferentes.<br>"
                    + "✔ Manejo de error con Exceptions (ej.: NumberFormatException), mostrando un mensaje amigable via JOptionPane.<br>"
                    + "✔ Si se ingresa la ',' (coma) como separador decimal, que se realice la conversión.<br>"
                    + "✔ Basarse en lo hecho en clase, terniendo en cuenta el uso de la Herencia y el Polimorfismo.<br>"
                    + "</div>";
        JOptionPane.showMessageDialog(this, text, "Acerca de TP1 - Conversor", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jbConsignaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbConsigna;
    private javax.swing.JButton jbConvertir;
    private javax.swing.JComboBox<String> jcbConversion;
    private javax.swing.JLabel jlConversion;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlValor1;
    private javax.swing.JLabel jlValor2;
    private javax.swing.JTextField jtfValor1;
    private javax.swing.JTextField jtfValor2;
    // End of variables declaration//GEN-END:variables
}
