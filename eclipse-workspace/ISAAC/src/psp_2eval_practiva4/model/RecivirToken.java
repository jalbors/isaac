package psp_2eval_practiva4.model;

public class RecivirToken {

	private String tokenTT;
	private UsuarioLogin userL;
	private String token2;
	
	public RecivirToken(String token) {
		// este token sera igual al resultado del metodo guardar
		this.tokenTT = guardar(token);

	}

	public String guardar(String token) {
		// guardo en otra variable el token que me llega del user
		//para poder llamarla con su respectivo get
		this.token2 = token;

		// esto lo imprime bien, no sale nulo
		System.out.println("token tttt" + token2);

		//de echo me estoy guardando el resultado en dos variables
		//y al llamarlas luego siempre son nulas ambas
		return token2;
	}

	public RecivirToken() {
		super();
	}

	public RecivirToken(UsuarioLogin userLog) {
		super();
		this.userL = userLog;
		guardarUsuario(userL);
	}

	private void guardarUsuario(UsuarioLogin userL2) {
		UsuarioLogin guar = userL2;
		guar.setToken(userL2.getToken().toString());

		tokenTT = userL2.getToken();
	}

	public String getToken2() {
		return token2;
	}

	public void setToken2(String token2) {
		this.token2 = token2;
	}

	public String getToken() {
		return tokenTT;
	}

	public String getTokenTT() {
		return tokenTT;
	}

	public void setTokenTT(String tokenTT) {
		this.tokenTT = tokenTT;
	}

	public UsuarioLogin getUserL() {
		return userL;
	}

	public void setUserL(UsuarioLogin userL) {
		this.userL = userL;
	}

	public void setToken(String token) {
		this.tokenTT = token;
	}
	
	

}
