package modelo;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersonaldelHotel {
	private String nombre;
	private String usuarioSistema;
	private String contraseñaSistema;

	public PersonaldelHotel(String nom, String usuario, String contraseña) {

		this.usuarioSistema = usuario;
		this.contraseñaSistema = contraseña;
		this.nombre = nom;
	}

	public String getUsuario() {
		return usuarioSistema;
	}

	public String getContraseña() {
		return contraseñaSistema;
	}

	public String getnombre() {
		return nombre;
	}

}
