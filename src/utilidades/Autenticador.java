package utilidades;

import java.util.HashMap;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
//import Modelo.PersonaldelHotel;

public class Autenticador {
	private HashMap<String, String> usuariosConContraseña;
	private HashMap<String, String> usuariosConTipo;
//	private HashMap<String,PersonaldelHotel> personaldelhotel;

	public Autenticador() {
		// tiene que tener un administrador por defecto lo cual se hace en las
		// siguientes lineas de codigo
		// SOLO EXISTE UN ADMINISTRADOR

		// usuario: contraseña de ese usuario
		this.usuariosConContraseña = new HashMap<String, String>();
		// EXISTEN TRES TIPOS DE USUARIOS: ADMINISTRADOR, RECEPCIONISTA Y PERSONAL DEL
		// HOTEL

		// usuario : tipodeusuario
		this.usuariosConTipo = new HashMap<String, String>();

		// usuario: personal hotel
//		this.personaldelhotel = new HashMap<String,PersonaldelHotel>();

		// ADMINISTRADOR YA INNATO
		usuariosConContraseña.put("ADMINISTRADORDEFAULT", "12345");
		usuariosConTipo.put("ADMINISTRADORDEFAULT", "ADMINISTRADOR");

		// RECEPCIONISTA DE PRUEBA

		usuariosConContraseña.put("RES", "12345");
		usuariosConTipo.put("RES", "RECEPCIONISTA");

		// PERSONAL DEL HOTEL DE PRUEBA

		usuariosConContraseña.put("PER", "12345");
		usuariosConTipo.put("PER", "PERSONAL DEL HOTEL");

	}

	public boolean autenticar(String usuario, String contraseña) {
		Boolean resultado = false;

		if (usuariosConContraseña.containsKey(usuario)) {
			String contramapa;
			contramapa = usuariosConContraseña.get(usuario);

			if (contraseña.equals(contramapa)) {
				resultado = true;
			}
		}
		return resultado;
	}

	public void setUsuarios(String usuario, String contraseña, String tipo) {
		usuariosConContraseña.put(usuario, contraseña);
		usuariosConTipo.put(usuario, tipo);
	}

//	public void setPersonaldelHotel(String nom, String usuario, String contraseña) {
//		PersonaldelHotel personal = new PersonaldelHotel(nom, usuario, contraseña);
//		personaldelhotel.put(nom, personal);
//	}

	public String getTipo(String usuario) {
		return usuariosConTipo.get(usuario);
	}

}
