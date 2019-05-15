package psp_2eval_practiva4.model;

import java.util.Date;

//clase para gestionar los usuarios
public class Usuario {

	private Integer idUser;
	private String name;
	private String surname;
	private String email;
	private String password;
	private double money;
	private Date registerDate;
	private Date removeDate;
	private String rol;
	private String token;
	private UsuarioLogin userLogin;
	private String adress, phone, yearsWork, description;

	public UsuarioLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UsuarioLogin userLogin) {
		this.userLogin = userLogin;
	}

	public Usuario(String adress, String phone, String yearsWork, String description) {
		super();
		this.adress = adress;
		this.phone = phone;
		this.yearsWork = yearsWork;
		this.description = description;
	}

	public Usuario(Integer idUser, String adress, String phone, String yearsWork, String description) {
		super();
		this.idUser = idUser;
		this.adress = adress;
		this.phone = phone;
		this.yearsWork = yearsWork;
		this.description = description;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario() {
	}

	public Usuario(String password) {
		super();
		this.password = password;
	}

	public Usuario(double money) {
		super();
		this.money = money;
	}

	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Usuario(String name, String surname, String email, String password, double money) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
	}

	public Usuario(Integer idUser, String name, String surname, String email, String password, double money) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
	}

	public Usuario(String name, String surname, String email, String password, double money, Date registerDate) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
		this.registerDate = registerDate;
	}

	public Usuario(Integer idUser, String name, String surname, String email, double money, Date registerDate) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.money = money;
		this.registerDate = registerDate;
	}

	public Usuario(String name, String surname, String email, String password, Date registerDate, String rol) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.registerDate = registerDate;
		this.rol = rol;
	}

	public Usuario(Integer idUser, String name, String surname, String email, String password, double money,
			Date registerDate, Date removeDate, String rol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
		this.registerDate = registerDate;
		this.removeDate = removeDate;
		this.rol = rol;
	}

	public Usuario(Integer idUser, String name, String surname, String email, String password, double money,
			String rol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
		this.rol = rol;
	}

	public Usuario(Integer idUser, String name, String surname, String email, String password, Date registerDate,
			String rol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.registerDate = registerDate;
		this.rol = rol;
	}

	public Usuario(Integer idUser, String name, String surname, String email, String password, double money,
			Date registerDate, String rol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
		this.registerDate = registerDate;
		this.rol = rol;
	}

	public Usuario(String name, String surname, String email, String password, double money, Date registerDate,
			Date removeDate) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
		this.registerDate = registerDate;
		this.removeDate = removeDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getYearsWork() {
		return yearsWork;
	}

	public void setYearsWork(String yearsWork) {
		this.yearsWork = yearsWork;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Usuario(UsuarioLogin userLogin) {
		super();
		this.userLogin = userLogin;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getRemoveDate() {
		return this.removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Usuario(String name, String surname, double money) {
		super();
		this.name = name;
		this.surname = surname;
		this.money = money;
	}

	public Usuario(String name, String surname, String email, String password, double money, String rol) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.money = money;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + ", money=" + money + ", registerDate=" + registerDate + ", removeDate="
				+ removeDate + ", rol=" + rol + ", token=" + token + ", userLogin=" + userLogin + "]";
	}

}
