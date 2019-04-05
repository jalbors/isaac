package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Usuario;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {
	public Main() {
		Object[][] datos = { 
				{ "Juan", new Integer(25), new Boolean(false) },
				{ "Sonia", new Integer(33), new Boolean(true) },
				{ "Pedro", new Integer(42), new Boolean(false) },
				};
		
		String[] columnNames = { "Nombre", "Años", "Apto", "QUe"};
		
		DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
		final JTable table = new JTable(dtm);
		
		// Agregar nueva columna
		String[] columnaNueva1 = { "vago", "diestro", "normal", };
		dtm.addColumn("Tipo", columnaNueva1);
		
		
		// Agregar nueva fila
		Object[] newRow = { "Maria", new Integer(55), new Boolean(false) };
		dtm.addRow(newRow);
		
		
		// Modificar celda especifica
		dtm.setValueAt("XXX", 3, 3); // Row/Col
		table.setPreferredScrollableViewportSize(new Dimension(500, 220));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		Main frame = new Main();
		frame.pack();
		frame.setVisible(true);
	}
	
	public static String get() {
		try {

			Gson gson = new Gson();
			int opcion = 0;
			int responseCode = 0;
			HttpURLConnection http = null;
			@SuppressWarnings("resource")
			Scanner tec = new Scanner(System.in);
			String token = "";
			URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/");

			http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String respuesta;

			while ((respuesta = br.readLine()) != null) {

				sb.append(respuesta);

			}

			responseCode = http.getResponseCode();
			System.out.println("Codigo respuesta: " + responseCode);

			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = gson.fromJson(sb.toString(), new TypeToken<List<Usuario>>() {
			}.getType());

			for (Usuario zones : usuarios) {
				return (zones.toString());
			}

			http.disconnect();

		} catch (Exception e) {

			e.printStackTrace();
			return "";

		}
		return null;
		
	}
	
}