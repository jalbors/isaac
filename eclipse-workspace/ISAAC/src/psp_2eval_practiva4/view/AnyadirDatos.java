package psp_2eval_practiva4.view;

import org.apache.commons.lang.StringUtils;

import psp_2eval_practica4.AnyadirDatosController;
import psp_2eval_practica4.utilities.IconoAplicacion;

@SuppressWarnings("serial")
public class AnyadirDatos extends javax.swing.JFrame {

	public AnyadirDatos() {
		initComponents();

	}

	private void initComponents() {

		this.setTitle("SGE - Añadir Datos");
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);
		this.setIconImage(IconoAplicacion.icono());

		jPanel1 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtp = new javax.swing.JTextField();
		txtn = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel6 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenu10 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		jButton2.setText("Agregar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);

				String id = jTextField2.getText();
				String nomb = jTextField1.getText();
				String apell = txtn.getText();
				String email = txtp.getText();
				String cont = jTextArea1.getText();

				if (StringUtils.isEmpty(String.valueOf(id)) || StringUtils.isEmpty(nomb) || StringUtils.isEmpty(apell)
						|| StringUtils.isEmpty(email) || StringUtils.isEmpty(cont)) {
					if (StringUtils.isEmpty(String.valueOf(id))) {
						AlertasInformacionErrores errores = new AlertasInformacionErrores(4);
						errores.setVisible(true);
					} else {
						AlertasInformacionErrores errores = new AlertasInformacionErrores(2);
						errores.setVisible(true);
					}

				} else {
					AnyadirDatosController controller = new AnyadirDatosController();
					int codigo = controller.editedUsuario(id, nomb, apell, email, cont);

					if (codigo == 1) {
						AlertasInformacionErrores errores = new AlertasInformacionErrores(15);
						errores.setVisible(true);
						jButton2.setEnabled(false);
					} else {
						AlertasInformacionErrores errores = new AlertasInformacionErrores(16);
						errores.setVisible(true);
					}
				}

			}
		});

		jButton4.setText("Volver");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("Vaciar datos");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
				txtp.setText("");
				txtn.setText("");
				jTextField2.setText("");
				jTextField1.setText("");
				jTextArea1.setText("");
				if (StringUtils.isEmpty(txtp.getText()) || StringUtils.isEmpty(txtn.getText())
						|| StringUtils.isEmpty(jTextField2.getText()) || StringUtils.isEmpty(jTextField1.getText())
						|| StringUtils.isEmpty(jTextArea1.getText())) {
					AlertasInformacionErrores errores = new AlertasInformacionErrores(18);
					errores.setVisible(true);
				}
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
						.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(35, 35, 35)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton5,
								javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)));

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		jLabel3.setText("Descripción:");

		jLabel2.setText("Años trabajados:");

		jLabel1.setText("Teléfono:");

		jLabel4.setText("Dirección:");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel6.setText("ID:");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
								.addGap(18, 18, 18)
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtn).addComponent(txtp).addComponent(jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE, 191,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel4).addComponent(jLabel6))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabel6)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
												.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)))
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(txtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtp, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 96,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel5.setText("Escriba el ID y añada información al usuario");

		jMenu2.setText("Información Usuario Logueado");
		jMenu2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu2ActionPerformed(evt);
			}
		});

		jMenuItem8.setText("Información");
		jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem8);

		jMenuBar1.add(jMenu2);

		jMenu10.setText("Salir");
		jMenu10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu10ActionPerformed(evt);
			}
		});

		jMenuItem1.setText("Salir");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu10.add(jMenuItem1);

		jMenuBar1.add(jMenu10);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel5,
								javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(31, 31, 31).addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)));

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {

		this.setVisible(false);
	}

	private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	public void eliminar(int id) {

	}

	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JMenu jMenu10;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField txtn;
	private javax.swing.JTextField txtp;
}
