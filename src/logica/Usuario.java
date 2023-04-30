package logica;

import javax.swing.JOptionPane;

public abstract class Usuario  {
	
		protected String nombre;
		protected String dni;
		protected String email;
		protected String usuario;
		protected String contrase�a;
		protected boolean login=false;
	
	
		public Usuario(String n, String dni, String e, String u, String c) {
			nombre=n;
			this.dni = dni;
			email=e;
			usuario=u;
			contrase�a=c;
			
			
		}
		
	public void logear(String usuario, String contrase�a) {
		usuario=JOptionPane.showInputDialog("Ingrese su usuario");
		contrase�a= JOptionPane.showInputDialog("Ingrese su contrase�a");
		
		if (this.getUsuario().equals(usuario) && this.getContrase�a().equals(contrase�a)) {
			JOptionPane.showConfirmDialog(null, "Bienvenido!");
			setLogin(true);
			
		} else {
			JOptionPane.showConfirmDialog(null, "Contrase�a incorrecta");
			
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
	public void setContrase�a(String contrase�a) {
		this.contrase�a=contrase�a;
	}
	public String getContrase�a() {
		return contrase�a;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", email=" + email + ", usuario=" + usuario
				+ ", contrase�a=" + contrase�a + ", login=" + login + "]";
	}
	
	
	
}
