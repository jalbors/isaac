package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class Alerta extends javax.swing.JFrame {

	
	private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Alerta(String tok) {
		this.token = tok;
		System.out.println("alerta token "+this.token);
		initComponents();
	}
	
	public Alerta() {
		super();
	}
	

	private void initComponents() {

		jDialog1 = new javax.swing.JDialog();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Usuario eliminado");

		jButton1.setText("Aceptar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(jButton1))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//cierro esta españa y llamo a la de eliminar y la cierro tambien
		this.setVisible(false);
		
		//close();
		
		//vuelvo a listar usuarios
		ListarUsuarios lis = new ListarUsuarios(this.token);
		lis.setVisible(true);
		
		
	}

	public void close() {
		WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
		
		ListarUsuarios lis = new ListarUsuarios();
		lis.setVisible(true);
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
			java.util.logging.Logger.getLogger(Alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Alerta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Alerta().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JLabel jLabel1;
}
