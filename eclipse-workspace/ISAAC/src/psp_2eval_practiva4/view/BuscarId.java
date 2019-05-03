package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import psp_2eval_practica4.BuscarIdController;
import psp_2eval_practica4.utilities.IconoAplicacion;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class BuscarId extends javax.swing.JFrame {

	/**
	 * Creates new form BuscarId
	 */
	public BuscarId() {
		initComponents();
	}

	private void initComponents() {
		this.setIconImage(IconoAplicacion.icono());
		this.setTitle("SGE - Buscar por id");
		this.setResizable(false);

		jTextField2 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jSeparator5 = new javax.swing.JPopupMenu.Separator();
		jMenuItem3 = new javax.swing.JMenuItem();
		jSeparator6 = new javax.swing.JPopupMenu.Separator();
		jMenuItem4 = new javax.swing.JMenuItem();
		jSeparator7 = new javax.swing.JPopupMenu.Separator();
		jMenuItem5 = new javax.swing.JMenuItem();
		jSeparator8 = new javax.swing.JPopupMenu.Separator();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenu10 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationByPlatform(true);

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel1.setText("Introduce el id a buscar:");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NOMBRE", "APELLIDO", "EMAIL", "DINERO", "F. Contratación" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("Buscar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				String identi = jTextField2.getText();

				try {
					if (StringUtils.isEmpty(identi)) {

						AlertasInformacionErrores errores = new AlertasInformacionErrores(4);
						errores.setVisible(true);

					} else {

						int finalMente = Integer.parseInt(identi);
						BuscarIdController get = new BuscarIdController();
						get.devolver(finalMente);
						System.out.println(get.getUsuario().toString());
						System.out.println(ToStringBuilder.reflectionToString(get.getUsuario()));

						DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
						int lista = 1;
						Object fila[] = new Object[6];
						for (int i = 0; i < lista; i++) {
							fila[0] = get.getUsuario().getIdUser();
							fila[1] = get.getUsuario().getName();
							fila[2] = get.getUsuario().getSurname();
							fila[3] = get.getUsuario().getEmail();
							fila[4] = get.getUsuario().getMoney();
							fila[5] = get.getUsuario().getRegisterDate();
							modelo.addRow(fila);
						}
					}
				} catch (NumberFormatException e) {

					AlertasInformacionErrores errores = new AlertasInformacionErrores(5);
					errores.setVisible(true);
					
				} catch (NullPointerException e) {
					AlertasInformacionErrores errores = new AlertasInformacionErrores(6);
					errores.setVisible(true);
				}

			}
		});

		jButton2.setText("Volver");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);

			}
		});

		jMenu4.setText("Filtrar por...   ");
		jMenu4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu4ActionPerformed(evt);
			}
		});

		jMenuItem2.setText("Administradores");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);

			}
		});
		jMenu4.add(jMenuItem2);
		jMenu4.add(jSeparator5);

		jMenuItem3.setText("Usuarios");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem3);
		jMenu4.add(jSeparator6);

		jMenuItem4.setText("Nombre");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem4);
		jMenu4.add(jSeparator7);

		jMenuItem5.setText("Salario");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem5);
		jMenu4.add(jSeparator8);

		jMenuItem6.setText("F. Contratación");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem6);

		jMenuBar1.add(jMenu4);

		jMenu3.setText("Sobre mí");
		jMenu3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu3ActionPerformed(evt);
			}
		});

		jMenuItem7.setText("Sobre mí");
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem7);

		jMenuBar1.add(jMenu3);

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
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(36, 36, 36).addComponent(jButton1).addGap(18, 18, 18)
										.addComponent(jButton2)))
						.addContainerGap(19, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1).addComponent(jButton2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(39, 39, 39)));

		pack();
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// disponse();

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		// para cerrar una ventana
		this.setVisible(false);
	}

	private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {

	}
	
	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {

		close();
	}


	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {

		new OrdenarPorAdministrador().setVisible(true);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {

		new OrdenarPorUsuarios().setVisible(true);
	}

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {

		new OrdenarPorSalario().setVisible(true);
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {

		new OrdenarPorNombre().setVisible(true);
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {

		new OrdenarPorFecha().setVisible(true);
	}

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {

		new AlertaYo().setVisible(true);
	}

	public void close() {
		WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu10;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPopupMenu.Separator jSeparator5;
	private javax.swing.JPopupMenu.Separator jSeparator6;
	private javax.swing.JPopupMenu.Separator jSeparator7;
	private javax.swing.JPopupMenu.Separator jSeparator8;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField2;

}
