package psp_2eval_practiva4.view;

import psp_2eval_practica4.LoginController;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame {

	public Login() {
		initComponents();

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel1.setText("Email");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
		jLabel2.setText("Contraseña");

		jButton1.setText("Login");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				// aqui es cuando el usuario se loguea y pulsa el boton de login
				String nombre = jTextField1.getText();
				String apellido = jTextField2.getText();

				// con los campos recuperados por el user los envio
				LoginController control = new LoginController();
				control.prueba(nombre, apellido);

			}
		});

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); 
		jLabel3.setText("Bienvenido, logueate.");

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(116, 116, 116).addComponent(jLabel3))
						.addGroup(layout.createSequentialGroup().addGap(154, 154, 154)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 127,
												Short.MAX_VALUE)
										.addComponent(jTextField1)))
						.addGroup(layout.createSequentialGroup().addGap(183, 183, 183).addComponent(jLabel2))
						.addGroup(layout.createSequentialGroup().addGap(189, 189, 189).addComponent(jButton1))
						.addGroup(layout.createSequentialGroup().addGap(200, 200, 200).addComponent(jLabel1)))
				.addContainerGap(102, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(27, 27, 27).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(63, 63, 63).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(43, 43, 43).addComponent(jButton1).addContainerGap(59, Short.MAX_VALUE)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		
		// se cierra la ventana
		this.setVisible(false);
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
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
}
