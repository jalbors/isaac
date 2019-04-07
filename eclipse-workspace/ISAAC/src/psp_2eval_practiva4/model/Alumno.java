package psp_2eval_practiva4.model;

public class Alumno {
	private String id;
	private String dni;
	private String nombre;
	private String telefono;
	private String direccion;

	public Alumno(String id, String dni, String nombre, String telefono, String direccion) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Alumno(String dni, String nombre, String telefono, String direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Alumno(String id) {
		super();
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Este alumno es identificado por el id " + id + " y sus datos personales son:\n"
				+ "- Dni=" + dni + ".\n"
				+ "- Nombre=" + nombre + "\n"
				+ "- Telefono=" + telefono + "\n"
				+ "- Direccion=" +direccion +".\n";
	}

}
