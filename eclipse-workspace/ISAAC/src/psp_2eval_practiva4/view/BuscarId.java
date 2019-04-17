/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;

import psp_2eval_practica4.BuscarIdController;

/**
 *
 * @author Jorge
 */
public class BuscarId extends javax.swing.JFrame {

	
	public BuscarId() {
		initComponents();
	}

	private void initComponents() {

		jTextField2 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});
		getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 50, -1));

		jLabel1.setText("Introduce el id a buscar");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 30));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NOMBRE", "APELLIDO", "EMAIL", "DINERO", "ROL" }));
		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 390, 50));

		jButton1.setText("Buscar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				int identi = Integer.parseInt(jTextField2.getText());

				BuscarIdController get = new BuscarIdController(identi);
				System.out.println(get.getUsuario().toString());

				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				int lista = 1;
				Object fila[] = new Object[6];
				for (int i = 0; i < lista; i++) {
					fila[0] = get.getUsuario().getIdUser();
					fila[1] = get.getUsuario().getName();
					fila[2] = get.getUsuario().getSurname();
					fila[3] = get.getUsuario().getEmail();
					fila[4] = get.getUsuario().getMoney();
					fila[5] = get.getUsuario().getRol();
					modelo.addRow(fila);
				}


			}
		});
		getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

		jButton2.setText("Volver");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
				
				

			}
		});
		
		getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

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
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		
		
		//para cerrar una ventana
		this.setVisible(false);
	}

	public void close() {
    	WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
    }
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BuscarId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BuscarId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BuscarId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BuscarId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BuscarId().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField2;
}
