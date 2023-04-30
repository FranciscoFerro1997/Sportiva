package logica;

import javax.swing.JOptionPane;

public abstract class Usuario  {
	
		protected String nombre;
		protected String dni;
		protected String email;
		protected String usuario;
		protected String contraseña;
		protected boolean login=false;
	
	
		public Usuario(String n, String dni, String e, String u, String c) {
			nombre=n;
			this.dni = dni;
			email=e;
			usuario=u;
			contraseña=c;
			
			
		}
		
	public void logear(String usuario, String contraseña) {
		usuario=JOptionPane.showInputDialog("Ingrese su usuario");
		contraseña= JOptionPane.showInputDialog("Ingrese su contraseña");
		
		if (this.getUsuario().equals(usuario) && this.getContraseña().equals(contraseña)) {
			JOptionPane.showConfirmDialog(null, "Bienvenido!");
			setLogin(true);
			
		} else {
			JOptionPane.showConfirmDialog(null, "Contraseña incorrecta");
			
		}
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setContraseña(String contraseña) {
		this.contraseña=contraseña;
	}
	public String getContraseña() {
		return contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", email=" + email + ", usuario=" + usuario
				+ ", contraseña=" + contraseña + ", login=" + login + "]";
	}
	
	
	
}
