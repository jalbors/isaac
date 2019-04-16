package psp_2eval_practiva4.model;

//clase para el login de usuarios
public class UsuarioLogin{

	private String email;
	private String password;
	private String token;
	private String idUser;
	private Usuario usuario;

	public UsuarioLogin(String email, String password, String token) {
		super();
		this.email = email;
		this.password = password;
		this.token = token;
	}

	public UsuarioLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UsuarioLogin(Usuario us) {
		this.usuario = us;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String RecivirToken() {
		return email;
		
	}

	@Override
	public String toString() {
		return "UsuarioLogin [email=" + email + ", password=" + password + ", token=" + token + ", idUser=" + idUser
				+ ", usuario=" + usuario + "]";
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioLogin() {
		super();
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
