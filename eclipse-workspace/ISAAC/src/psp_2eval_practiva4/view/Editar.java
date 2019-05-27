package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

import ch.qos.logback.core.net.SyslogOutputStream;
import psp_2eval_practica4.EditarController;
import psp_2eval_practica4.utilities.IconoAplicacion;
import psp_2eval_practiva4.model.Imagen;
import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class Editar extends javax.swing.JFrame {

	private Usuario user = null;
	private EditarController controller = null;
	private String token = "";
	private UsuarioLogin pacazo;
	private int haEditado = 0;

	public Editar() {
		initComponents();
	}

	public Editar(String tokenAEnv, UsuarioLogin pake) {
		// guardo el token
		this.token = tokenAEnv;
		this.pacazo = pake;
		System.out.println("pacazo editar " + this.pacazo);
		initComponents();
	}

	private void initComponents() {
		this.setIconImage(IconoAplicacion.icono());
		this.setTitle("SGE - Editar usuario");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

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

		jLabel7.setVisible(false);

		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jTextField4 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
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
		jMenu2 = new javax.swing.JMenu();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenu10 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
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

				if (StringUtils.isEmpty(jTextField1.getText())) {

					new AlertasInformacionErrores(4).setVisible(true);

				} else {
					try {
						// recojo el id y se lo paso al controlador para recuperar el usuario ya creado
						int idAEditar = Integer.parseInt(jTextField1.getText());
						controller = new EditarController();
						user = controller.devolver(idAEditar);
						System.out.println(user.toString());

						// hago visible etiquetas para editarlas
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

						// del usuario de la BD relleno los campos ya visibles con los valores
						jTextField2.setText(user.getName());
						jTextField3.setText(user.getSurname());
						jTextField4.setText(user.getEmail());
						jTextField5.setText(user.getPassword());
						jTextField6.setText(String.valueOf(user.getMoney()));

						jButton2.setVisible(true);

						jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
						jLabel10.setText("Introduzca los datos a editar de: " + user.getName());
						jButton1.setEnabled(false);

					} catch (NumberFormatException e) {

						AlertasInformacionErrores errores = new AlertasInformacionErrores(5);
						errores.setVisible(true);

					} catch (NullPointerException e) {
						AlertasInformacionErrores errores = new AlertasInformacionErrores(6);
						errores.setVisible(true);
					}

				}

			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Nombre", "Apellido", "Email", "Dinero" }));

		jScrollPane1.setViewportView(jTable1);

		jButton2.setText("Editar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);

				int id = 0;
				String nomb = "";
				String apell = "";
				String email = "";
				String cont = "";
				String dinero = "";
				String contra2 = "";

				try {
					// recojo los campos ya editados por el usuario
					id = controller.getUsuario().getIdUser();
					System.out.println("id " + id);
					nomb = jTextField2.getText();
					System.out.println(nomb);
					apell = jTextField3.getText();
					email = jTextField4.getText();
					cont = jTextField5.getText();
					contra2 = jTextField7.getText();
					dinero = String.valueOf(jTextField6.getText());

					if (StringUtils.isEmpty(String.valueOf(id)) || StringUtils.isEmpty(nomb)
							|| StringUtils.isEmpty(apell) || StringUtils.isEmpty(email) || StringUtils.isEmpty(contra2)
							|| StringUtils.isEmpty(dinero)) {
						if(StringUtils.isEmpty(String.valueOf(id))) {
							System.out.println("id nulo fdallaa");
						}else {
							AlertasInformacionErrores errores = new AlertasInformacionErrores(2);
							errores.setVisible(true);
						}
						
					} else if (!jTextField7.getText().equalsIgnoreCase(jTextField5.getText())) {
						AlertasInformacionErrores errores = new AlertasInformacionErrores(1);
						errores.setVisible(true);
					} else {
						// llamo al controlador
						haEditado = (int) controller.editedUsuario(id, nomb, apell, email, cont,
								Double.parseDouble(dinero));
						System.out.println("a editado??" + haEditado);

						if (haEditado == 1) {
							// relleno la tabla con los nuevos datos
							jLabel10.setVisible(true);
							DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
							int lista = 1;
							Object fila[] = new Object[6];
							for (int i = 0; i < lista; i++) {

								fila[0] = id;
								fila[1] = nomb;
								fila[2] = apell;
								fila[3] = email;
								fila[4] = dinero;
								fila[5] = "USER";
								modelo.addRow(fila);
							}
							jLabel7.setVisible(true);
							jButton2.setEnabled(false);

						} else {
							AlertasInformacionErrores errores = new AlertasInformacionErrores(9);
							errores.setVisible(true);
						}
					}

				} catch (NullPointerException e) {
					AlertasInformacionErrores errores = new AlertasInformacionErrores(9);
					errores.setVisible(true);
					e.printStackTrace();
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

		Imagen imagen = new Imagen();
		jLabel8.setIcon(imagen.imagenDevolver("/resources/images/edi.jpg"));

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); 
		jLabel9.setText("Editar usuario:");

		jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); 
		jLabel10.setText("Introduzca los datos a editar de: ");

		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		jLabel6.setText("Dinero");

		jButton2.setText("Editar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
		jLabel2.setText("Nombre");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		jLabel3.setText("Apellido");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		jLabel5.setText("Contraseña");

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		jLabel11.setText("Repita contraseña");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		jLabel4.setText("Email");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(30, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel6)
												.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel11).addComponent(jLabel5)
														.addComponent(jLabel4).addComponent(jLabel3)
														.addComponent(jLabel2)).addGap(19, 19, 19)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jTextField2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 88,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGroup(jPanel1Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																		.addComponent(jTextField3,
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(jTextField4,
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(jTextField5,
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(jTextField7,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				88,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))))))
						.addGap(27, 27, 27)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel11)
								.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

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

		jMenuItem6.setText("Ver datos añadidos");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem6);

		jMenuBar1.add(jMenu4);

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
				.addGroup(layout.createSequentialGroup().addGap(122, 122, 122)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(122, 122, 122).addComponent(jLabel7))
						.addGroup(layout.createSequentialGroup().addGap(105, 105, 105).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(83, 83, 83)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 214,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addGap(105, 105, 105).addComponent(jLabel9)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 289,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(70, 70, 70)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup().addGap(95, 95, 95).addComponent(jLabel10).addGap(19, 19, 19)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel9).addGap(44, 44, 44)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(30, 30, 30).addComponent(jLabel8).addGap(69, 69, 69)))
				.addComponent(jLabel7).addGap(31, 31, 31).addComponent(jScrollPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(31, 31, 31)));

		pack();
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		ListarUsuarios listar = new ListarUsuarios(this.token, "", this.pacazo);
		listar.setVisible(true);
	}

	private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

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

		new OrdenarPorDatos().setVisible(true);
	}

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {

		new AlertaYo().setVisible(true);
	}

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {

		System.out.println("pakito el xoxo " + this.pacazo);
		AlertaInformacion al = new AlertaInformacion(this.pacazo, this.token);
		al.setVisible(true);
	}

	public void close() {
		WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioLogin getPacazo() {
		return pacazo;
	}

	public void setPacazo(UsuarioLogin pacazo) {
		this.pacazo = pacazo;
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu10;
	private javax.swing.JMenu jMenu2;
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
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPopupMenu.Separator jSeparator5;
	private javax.swing.JPopupMenu.Separator jSeparator6;
	private javax.swing.JPopupMenu.Separator jSeparator7;
	private javax.swing.JPopupMenu.Separator jSeparator8;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
}
