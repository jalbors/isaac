package psp_2eval_practiva4.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import psp_2eval_practica4.OrdenarPorSalarioController;
import psp_2eval_practica4.utilities.IconoAplicacion;
import psp_2eval_practiva4.model.Usuario;

/**
 *
 * @author Jorge
 */
@SuppressWarnings("serial")
public class OrdenarPorFecha extends javax.swing.JFrame {

	private boolean dist;

	public OrdenarPorFecha() {
		initComponents();
	}

	private void initComponents() {
		this.setIconImage(IconoAplicacion.icono());
		dist = true;

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);
		setLocationByPlatform(true);
		this.setTitle("SGE - Administradores");
		setSize(new java.awt.Dimension(512, 253));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel1.setText("Usuarios: ");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] {
				// cabecera ce la tabla

				"ID", "Nombre", "Apellido", "Email", "Dinero/mes", "F. Contratación" }));
		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
			jTable1.getColumnModel().getColumn(1).setHeaderValue("Nombre");
			jTable1.getColumnModel().getColumn(2).setHeaderValue("Apellido");
			jTable1.getColumnModel().getColumn(3).setHeaderValue("Email");
			jTable1.getColumnModel().getColumn(4).setHeaderValue("Dinero/mes");
			jTable1.getColumnModel().getColumn(5).setHeaderValue("F. Contratación");
		}

		jButton1.setText("Listar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				if (dist == false) {

					new AlertasInformacionErrores(11).setVisible(true);
					jButton1.setEnabled(false);

				} else {
					// llama a la clase get con el metodo get para listar usuarios
					OrdenarPorSalarioController usuFinales = new OrdenarPorSalarioController();
					usuFinales.usuariosFinales();
					// funcion para mostrar los datos en la table cada uno en su fila y columna
					DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
					List<Usuario> lista = usuFinales.getUsuariosADevolver();
					Object fila[] = new Object[6];
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

		jButton2.setText("Volver");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
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
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton1).addGap(26, 26, 26).addComponent(jButton2))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
																423, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(30, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(17, 17, 17)
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1)
						.addComponent(jButton2))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
}
