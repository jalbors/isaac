
package psp_2eval_practiva4.view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import psp_2eval_practica4.ListarUsuariosController;
import psp_2eval_practiva4.model.Usuario;

@SuppressWarnings("serial")
public class ListarUsuarios extends javax.swing.JFrame {
	public static ArrayList<Usuario> USUARIOS = null;

	private List<Usuario> usuariosADevolver = null;

	// guardo el token aqui desde login controller y en jButton2ActionPerformed se
	// lo envio a la siguiente clase
	private String tokenAEnv;

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

	/**
	 * Creates new form NewJFrame
	 */
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
		jScrollPane3 = new javax.swing.JScrollPane();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jorge\\Pictures\\contactaConNosotros.jpg")); // NOI18N
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 170));

		jButton1.setText("Listar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				usuariosADevolver = new ArrayList<>();

				// llama a la clase get con el metodo get para listar usuarios
				ListarUsuariosController g = new ListarUsuariosController((ArrayList<Usuario>) usuariosADevolver);

				// funcion para mostrar los datos en la table cada uno en su fila y columna
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				ArrayList<Usuario> lista = g.getUserADevolver();
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
		getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

		jButton2.setText("Crear");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

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

		getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 500, 90));

		getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 490, -1));

		jButton3.setText("Editar");
		getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

		jButton4.setText("Eliminar");
		getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);

			}
		});

		jButton5.setText("Buscar Id");
		getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);

			}
		});

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		jMenu3.setText("Componentes");
		jMenuBar1.add(jMenu3);

		jMenu4.setText("Mi cuenta");
		jMenuBar1.add(jMenu4);

		setJMenuBar(jMenuBar1);

		pack();
	}// </editor-fold>

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		
		//clica al boton y se abre anyadir usuario enviando el token recogido antes
		//abro esta ventana y cierro la actual
		AnyadirUsuario jf1 = new AnyadirUsuario(this.tokenAEnv);
		jf1.setVisible(true);
		this.setVisible(false);

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

		// abrir nueva ventana
		BuscarId buscar = new BuscarId();
		buscar.setVisible(true);

	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		// abrir nueva ventana
		Eliminar eliminar = new Eliminar();
		eliminar.setVisible(true);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		// llama al jframe para cambiar de ventana y lo pone visible

		// metodo para cerrar la ventana actual y pasar a la siguiente
		// close();

	}

	public void close() {
		WindowEvent closing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
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
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jTable1;
	// End of variables declaration
}
