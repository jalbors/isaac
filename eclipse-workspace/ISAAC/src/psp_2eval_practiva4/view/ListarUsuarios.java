
package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import psp_2eval_practica4.ListarUsuariosController;
import psp_2eval_practiva4.model.Usuario;

@SuppressWarnings("serial")
public class ListarUsuarios extends javax.swing.JFrame {

	// guardo el token aqui desde login controller y en jButton2ActionPerformed se
	// lo envio a la siguiente clase
	private String tokenAEnv;
	private List<Usuario> usuariosADevolver = null;

	public ListarUsuarios() {
		initComponents();
	}

	// recojo el token que me llega y inicio la clase normal, no hago nada con el
	// token solo lo paso
	public ListarUsuarios(String token) {
		this.tokenAEnv = token;
		System.out.println("Listar us: " + tokenAEnv);
		initComponents();
	}

	private void initComponents() {

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
		jMenu3 = new javax.swing.JMenu();
		jMenu10 = new javax.swing.JMenu();

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setIcon(imagen());
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 500, 170));

		jButton1.setText("Listar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				usuariosADevolver = new ArrayList<>();

				// llama a la clase get con el metodo get para listar usuarios
				ListarUsuariosController usuFinales = new ListarUsuariosController();
				usuFinales.usuariosFinales((ArrayList<Usuario>) usuariosADevolver);
				// funcion para mostrar los datos en la table cada uno en su fila y columna
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				List<Usuario> lista = usuFinales.getUserADevolver();
				Object fila[] = new Object[6];
				for (int i = 0; i < lista.size(); i++) {
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
		getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));


		jButton2.setText("Crear");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] {
				// cabecera ce la tabla

				"ID", "NOMBRE", "APELLIDO", "EMAIL", "DINERO", "ROL" }));
		jScrollPane2.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
			jTable1.getColumnModel().getColumn(1).setHeaderValue("NOMBRE");
			jTable1.getColumnModel().getColumn(2).setHeaderValue("APELLIDO");
			jTable1.getColumnModel().getColumn(3).setHeaderValue("EMAIL");
			jTable1.getColumnModel().getColumn(4).setHeaderValue("DINERO");
			jTable1.getColumnModel().getColumn(5).setHeaderValue("ROL");
		}

		getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 500, 90));

		jButton3.setText("jButton3");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

		jButton4.setText("jButton4");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);

			}
		});
		getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

		jButton5.setText("jButton5");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, -1, -1));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel2.setText("Bienvenido Usuaio");
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 240, 40));

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel3.setText("Elija la operación ha realizar:");
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

		jMenu4.setText("Menú rápido");

		jMenuItem2.setText("jMenuItem2");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem2);
		jMenu4.add(jSeparator5);

		jMenuItem3.setText("jMenuItem3");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem3);
		jMenu4.add(jSeparator6);

		jMenuItem4.setText("jMenuItem4");
		jMenu4.add(jMenuItem4);
		jMenu4.add(jSeparator7);

		jMenuItem5.setText("jMenuItem5");
		jMenu4.add(jMenuItem5);
		jMenu4.add(jSeparator8);

		jMenuItem6.setText("jMenuItem6");
		jMenu4.add(jMenuItem6);

		jMenuBar1.add(jMenu4);

		jMenu2.setText("Información Usuario Logueado");
		jMenu2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu2ActionPerformed(evt);
			}
		});
		jMenuBar1.add(jMenu2);

		jMenu3.setText("Sobre mí");
		jMenu3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu3ActionPerformed(evt);
			}
		});
		jMenuBar1.add(jMenu3);

		jMenu10.setText("Salir");
		jMenuBar1.add(jMenu10);

		setJMenuBar(jMenuBar1);

		pack();
	}// </editor-fold>

	//metodo que devuelve una imagen
	public ImageIcon imagen(){
		
		BufferedImage image;
		try {
			image = ImageIO.read(getClass().getResource("/resources/images/contactaConNosotros.jpg"));
			ImageIcon icon = new ImageIcon(image);
			return icon;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		// llama al jframe para cambiar de ventana y lo pone visible

		// metodo para cerrar la ventana actual y pasar a la siguiente
		// close();

	}
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		
		//clica al boton y se abre anyadir usuario enviando el token recogido antes
		//abro esta ventana y cierro la actual
		AnyadirUsuario jf1 = new AnyadirUsuario(this.tokenAEnv);
		jf1.setVisible(true);
		this.setVisible(false);

		
	}
	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		//cerrar la ventana actual
		this.setVisible(false);
		Editar edit = new Editar(this.tokenAEnv);
		edit.setVisible(true);
		
		

	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		//cerrar la ventana actual
		this.setVisible(false);
		// abrir nueva ventana
		Eliminar eliminar = new Eliminar(this.tokenAEnv);
		eliminar.setVisible(true);

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

		// abrir nueva ventana
		BuscarId buscar = new BuscarId();
		buscar.setVisible(true);

	}

	public void close() {
		WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
	}
  
  
  public String getToken() {
    return tokenAEnv;
  }
  
  public void setToken(String token) {
    this.tokenAEnv = token;
  }
  
  public List<Usuario> getUsuariosADevolver() {
    return usuariosADevolver;
  }
  
  public void setUsuariosADevolver(List<Usuario> usuariosADevolver) {
    this.usuariosADevolver = usuariosADevolver;
  }

	private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		//item del menu de arriuba
		Editar edi = new Editar();
		edi.setVisible(true);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ListarUsuarios().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JMenu jMenu10;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JPopupMenu.Separator jSeparator5;
	private javax.swing.JPopupMenu.Separator jSeparator6;
	private javax.swing.JPopupMenu.Separator jSeparator7;
	private javax.swing.JPopupMenu.Separator jSeparator8;
	private javax.swing.JTable jTable1;
	// End of variables declaration
}
