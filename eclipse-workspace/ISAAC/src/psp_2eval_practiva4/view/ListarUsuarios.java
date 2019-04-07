package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import psp_2eval_practica4.Get;
import psp_2eval_practiva4.model.Usuario;




public class ListarUsuarios extends javax.swing.JFrame {
	
	public static ArrayList<Usuario> USUARIOS = null;
    /**
     * Creates new form NewJFrame
     */
    public ListarUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        
       
        
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Bienvenido admin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jButton1.setText("Listar usuarios");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				
				//llama a la clase get con el metodo get para listar usuarios
				Get g = new Get(USUARIOS);
				
				jTextArea2.setText(g.getUserADevolver().toString());
				
				//funcion para mostrar los datos en la table cada uno en su fila y columna
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
		        ArrayList<Usuario> lista = g.getUserADevolver();
		        Object fila[] = new Object[6];
		        for(int i = 0; i < lista.size(); i++)
		        {
		            fila[0] = lista.get(i).getIdUser();
		            fila[1] = lista.get(i).getName();
		            fila[2] = lista.get(i).getSurname();
		            fila[3] = lista.get(i).getEmail();
		            fila[4] = lista.get(i).getMoney();
		            fila[5] = lista.get(i).getRol();
		            modelo.addRow(fila);
		        }
				

			}
		});
        
        
        jButton2.setText("Crear usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        		
            new Object [][] {
            },
            new String [] {
            		//cabecera ce la tabla
            		
                "ID", "NOMBRE", "APELLIDO", "EMAIL", "DINERO", "ROL"
            }
        ));
        
        
        jScrollPane2.setViewportView(jTable1);

        //librerias externas  org.netbeans.lib.awtextra.AbsoluteConstraints
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 500, 110));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 490, -1));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	AnyadirUsuario jf1 = new AnyadirUsuario();
    	jf1.setVisible(true);
    }  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
    	
    	//llama al jframe para cambiar de ventana y lo pone visible
    	
    	
    	//metodo para cerrar la ventana actual y pasar a la siguiente
    	//close();
    	
	}
    
    public void close() {
    	WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
    }

    public static void main(String args[]) {
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarUsuarios().setVisible(true);
            }
        });
    }
                    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;      
}
