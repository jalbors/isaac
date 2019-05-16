package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;
import psp_2eval_practica4.ListarUsuariosController;
import psp_2eval_practica4.utilities.IconoAplicacion;
import psp_2eval_practiva4.model.Imagen;
import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;

@SuppressWarnings("serial")
public class ListarUsuarios extends javax.swing.JFrame {

	// guardo el token aqui desde login controller y en jButton2ActionPerformed se
	// lo envio a la siguiente clase
	private String tokenAEnv;
	private UsuarioLogin paquito;
	private String email;
	private boolean dist;

	// recojo el token que me llega y inicio la clase normal, no hago nada con el
	// token solo lo paso
	// el nombre es para dar la bienvenida la primera vez que se logea
	public ListarUsuarios(String token, String nombre, UsuarioLogin paco) {
		this.tokenAEnv = token;
		this.email = nombre;
		this.paquito = paco;
		System.out.println("nombre " + this.email);
		System.out.println("Listar us: " + tokenAEnv);
		System.out.println("pacazo listar -->   " + this.paquito);
		initComponents(nombre, paco);
	}

	private void initComponents(String email, UsuarioLogin paco) {
		dist = true;
		this.setTitle("SGE - Home");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);
		this.setIconImage(IconoAplicacion.icono());

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
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
        
        if(paco.getRol().equalsIgnoreCase("USER")) {
			jButton6.setVisible(false);
			jButton2.setVisible(false);
			jButton3.setVisible(false);
			jButton4.setVisible(false);
		}

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

    	// clase general que devuelve una iamgen
		Imagen ima = new Imagen();
		jLabel1.setIcon(ima.imagenDevolver("/resources/images/contactaConNosotros.jpg"));

		jButton1.setText("Listar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				System.out.println(paco.getRol());
				
				if (dist == false) {

					AlertasInformacionErrores errores = new AlertasInformacionErrores(11);
					errores.setVisible(true);
					// alerta de ya tienes todos los usuarios listados
					jButton1.setEnabled(false);

				} else {
					// llama a la clase get con el metodo get para listar usuarios
					ListarUsuariosController usuFinales = new ListarUsuariosController();
					usuFinales.usuariosFinales();
					// funcion para mostrar los datos en la table cada uno en su fila y columna
					DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
					List<Usuario> lista = usuFinales.getUserADevolver();
					Object fila[] = new Object[6];
					// System.out.println(lista.size());
					for (int i = 0; i < lista.size(); i++) {
						fila[0] = lista.get(i).getIdUser();
						fila[1] = lista.get(i).getName();
						fila[2] = lista.get(i).getSurname();
						fila[3] = lista.get(i).getEmail();
						fila[4] = lista.get(i).getMoney();
						fila[5] = lista.get(i).getRegisterDate();
						modelo.addRow(fila);
					}
					dist = false;
					
				}

			}
		});

		jButton2.setText("Añadir");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		
		

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] {
				// cabecera ce la tabla

				"ID", "Nombre", "Apellido", "Email", "Dinero/mes", "F. Contratación" }));
		jScrollPane2.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
			jTable1.getColumnModel().getColumn(1).setHeaderValue("Nombre");
			jTable1.getColumnModel().getColumn(2).setHeaderValue("Apellido");
			jTable1.getColumnModel().getColumn(3).setHeaderValue("Email");
			jTable1.getColumnModel().getColumn(4).setHeaderValue("Dinero/mes");
			jTable1.getColumnModel().getColumn(5).setHeaderValue("F. Contratación");
		}

		jButton3.setText("Editar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("Eliminar");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);

			}
		});

		jButton5.setText("Buscar por id");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		if (StringUtils.isNotEmpty(email)) {
			jLabel2.setText("Bienvenido usuario: " + email);
		} else {
			jLabel2.setText("Bienvenido de vuelta usuario");
		}


        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Elija la operación ha realizar:");

        jButton6.setText("Añadir datos");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
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

		jMenuItem6.setText("Ver datos añadidos");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem6);

		jMenuBar1.add(jMenu4);

		jMenu2.setText("Información Usuario Logueado   ");
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

		jMenu3.setText("Sobre mí   ");
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
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// cerrar la ventana actual
		this.setVisible(false);
		Editar edit = new Editar(this.tokenAEnv, this.paquito);
		edit.setVisible(true);

	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// cerrar la ventana actual
		this.setVisible(false);
		// abrir nueva ventana
		Eliminar eliminar = new Eliminar(this.tokenAEnv, this.paquito);
		eliminar.setVisible(true);

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		// clica al boton y se abre anyadir usuario enviando el token recogido antes
		// abro esta ventana y cierro la actual
		AnyadirUsuario jf1 = new AnyadirUsuario(this.tokenAEnv, this.paquito);
		jf1.setVisible(true);
		this.setVisible(false);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

		// abrir nueva ventana
		BuscarId buscar = new BuscarId();
		buscar.setVisible(true);

	}
	
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {

		// abrir nueva ventana
		new AnyadirDatos().setVisible(true);

	}

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here
    	
    }                                      

           
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	close();
    }    
    
	private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {

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

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {

		System.out.println("pakito el xoxo " + this.paquito);
		AlertaInformacion al = new AlertaInformacion(this.paquito, this.tokenAEnv);
		al.setVisible(true);
	}

	public void close() {
		WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
	}                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
