package psp_2eval_practiva4.view;

import psp_2eval_practica4.utilities.IconoAplicacion;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class AlertasInformacionErrores extends javax.swing.JFrame {

	public AlertasInformacionErrores(int codigo) {
		initComponents(codigo);
	}

	private void initComponents(int codigo) {
		this.setIconImage(IconoAplicacion.icono());
		this.setTitle("SGE - Alerta");
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));

		switch (codigo) {
		case 1:
			jLabel1.setText("Las contraseñas no coinciden");
			break;
		case 2:
			jLabel1.setText("Introduzca los campos requeridos");
			break;
		case 3:
			jLabel1.setText("Introduzca números en el campo dinero a ingresar");
			break;
		case 4:
			jLabel1.setText("Introduzca un id a buscar");
			break;
		case 5:
			jLabel1.setText("Introduzca un numero no letras -.-");
			break;
		case 6:
			jLabel1.setText("El id de usuario a buscar no existe");
			break;
		case 7:
			jLabel1.setText("El id de usuario a buscar no existe");
			break;
		case 8:
			jLabel1.setText("Edite todos los campos");
			break;
		case 9:
			jLabel1.setText("Edite todos los campos");
			break;
		case 10:
			jLabel1.setText("Introduzca un id a eliminar");
			break;
		case 11:
			jLabel1.setText("Los usuarios ya han sido listados");
			break;
		case 12:
			jLabel1.setText("Introduzca un usuario o contraseña validos");
			break;
		case 13:
			jLabel1.setText("El usuario o la contraseña son erróneos");
			break;
		case 14:
			jLabel1.setText("Los administradores ya han sido listados");
			break;
		case 15:
			jLabel1.setText("Datos añadidos con exito");
			break;
		case 16:
			jLabel1.setText("Error insertando los datos");
			break;
		case 17:
			jLabel1.setText("Usuario eliminado");
			break;
	

		}

		jButton1.setText("Aceptar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jMenu1.setText("Salir");

		jMenuItem1.setText("Salir");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);

			}
		});

		jMenu1.add(jMenuItem1);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jButton1).addComponent(jLabel1))
								.addContainerGap(34, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addComponent(jButton1).addContainerGap()));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
}
