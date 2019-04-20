package psp_2eval_practiva4.view;

import javax.swing.table.DefaultTableModel;

import psp_2eval_practica4.EditarController;
import psp_2eval_practiva4.model.Usuario;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class Editar extends javax.swing.JFrame {

	private Usuario user = null;
	private EditarController controller = null;

	public Editar() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		jLabel2 = new javax.swing.JLabel();
		jLabel2.setVisible(false);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setVisible(false);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setVisible(false);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setVisible(false);
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setVisible(false);

		jTextField2 = new javax.swing.JTextField();
		jTextField2.setVisible(false);
		jTextField3 = new javax.swing.JTextField();
		jTextField3.setVisible(false);
		jTextField4 = new javax.swing.JTextField();
		jTextField4.setVisible(false);
		jTextField5 = new javax.swing.JTextField();
		jTextField5.setVisible(false);
		jTextField6 = new javax.swing.JTextField();
		jTextField6.setVisible(false);

		jButton2 = new javax.swing.JButton();
		jButton2.setVisible(false);

		jButton3 = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Id a editar:");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jButton1.setText("Buscar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton1.setText("Buscar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				int idAEditar = Integer.parseInt(jTextField1.getText());
				controller = new EditarController();

				user = controller.devolver(idAEditar);
				System.out.println(user.toString());

				jLabel2.setVisible(true);
				jLabel3.setVisible(true);
				jLabel4.setVisible(true);
				jLabel5.setVisible(true);
				jLabel6.setVisible(true);

				jTextField2.setVisible(true);
				jTextField3.setVisible(true);
				jTextField4.setVisible(true);
				jTextField5.setVisible(true);
				jTextField6.setVisible(true);

				jTextField2.setText(user.getName());
				jTextField3.setText(user.getSurname());
				jTextField4.setText(user.getEmail());
				jTextField5.setText(user.getPassword());
				jTextField6.setText(String.valueOf(user.getMoney()));

				jButton2.setVisible(true);

			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Nombre", "Apellido", "Email", "Dinero" }));
		
		jScrollPane1.setViewportView(jTable1);

		jLabel2.setText("Nombre");

		jLabel3.setText("Apellido");

		jLabel4.setText("Email");

		jLabel5.setText("Contraseña");

		jLabel6.setText("Dinero");

		jButton2.setText("Editar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);

				int id = controller.getUsuario().getIdUser();
				System.out.println("id " + id);
				String nomb = jTextField2.getText();
				System.out.println(nomb);
				String apell = jTextField3.getText();
				String email = jTextField4.getText();
				String cont = jTextField5.getText();
				String dinero = String.valueOf(jTextField6.getText());

				controller.editedUsuario(id, nomb, apell, email, cont, Double.parseDouble(dinero));
				
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				int lista = 1;
				Object fila[] = new Object[6];
				for (int i = 0; i < lista; i++) {
					fila[0] = controller.getUsuario().getIdUser();
					fila[1] = controller.getUsuario().getName();
					fila[2] = controller.getUsuario().getSurname();
					fila[3] = controller.getUsuario().getEmail();
					fila[4] = controller.getUsuario().getMoney();
					fila[5] = controller.getUsuario().getRol();
					modelo.addRow(fila);
				}
				

			}
		});

		jButton3.setText("Volver");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel7.setText("Usuario Actualizado con exito: ");

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		jMenu3.setText("jMenu3");
		jMenuBar1.add(jMenu3);

		jMenu4.setText("jMenu4");
		jMenuBar1.add(jMenu4);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(24, 24, 24)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jButton3)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jButton2)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jButton1)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 64,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(121, 121, 121)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel2).addComponent(jLabel3)
														.addComponent(jLabel4).addComponent(jLabel5)
														.addComponent(jLabel6))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE,
																60, Short.MAX_VALUE)
														.addComponent(jTextField5).addComponent(jTextField4)
														.addComponent(jTextField3).addComponent(jTextField2))))
								.addComponent(jLabel7)))
				.addContainerGap(20, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(22, 22, 22)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jButton1)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(28, 28, 28)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
						.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(30, 30, 30)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
						.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(23, 23, 23)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
						.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(42, 42, 42).addComponent(jButton2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
				.addComponent(jLabel7).addGap(18, 18, 18)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(28, 28, 28).addComponent(jButton3).addContainerGap()));

		pack();
	}// </editor-fold>

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		ListarUsuarios listar = new ListarUsuarios();
		listar.setVisible(true);
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
			java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Editar().setVisible(true);
			}
		});
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
}
