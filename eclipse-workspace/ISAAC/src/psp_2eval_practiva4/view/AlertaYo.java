package psp_2eval_practiva4.view;

import psp_2eval_practica4.utilities.IconoAplicacion;
import psp_2eval_practiva4.model.Imagen;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class AlertaYo extends javax.swing.JFrame {

    /**
     * Creates new form AlertaYo
     */
    public AlertaYo() {
        initComponents();
    }
                       
    private void initComponents() {
    	this.setIconImage(IconoAplicacion.icono());
    	this.setResizable(false);
    	this.setTitle("SGE - Sobre mí");
    	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    
    	setLocationByPlatform(true);
    	
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        Imagen imagenRetorno = new Imagen();
        jLabel1.setIcon(imagenRetorno.imagenDevolver("/resources/images/yo.PNG"));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }                 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	this.setVisible(false);
    }                                        
                  
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;            
}
