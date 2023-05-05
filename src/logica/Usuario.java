package logica;

import javax.swing.JOptionPane;

public abstract class Usuario  {
	
		protected String nombre;
		protected String dni;
		protected String email;
		protected String clave;
		protected boolean login=false;
	
	
		public Usuario(String n, String dni, String e,  String c) {
			nombre=n;
			this.dni = dni;
			email=e;
			clave=c;
			
			
		}
		
	public void logear(String usuario, String clave) {
		usuario=JOptionPane.showInputDialog("Ingrese su DNI");
		clave= JOptionPane.showInputDialog("Ingrese su contraseña");
		
		if (this.getDni().equals(usuario) && this.getClave().equals(clave)) {
			JOptionPane.showMessageDialog(null, "Bienvenido!");
			setLogin(true);
			
		} else {
			JOptionPane.showConfirmDialog(null, "Contraseña incorrecta");
			
		}
	}
	
	public void logOut() {
		setLogin(false);

	}
	
	
	
	
	
	
	
	
	
	
	

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
	public void setClave(String contraseña) {
		this.clave=contraseña;
	}
	public String getClave() {
		return clave;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nInformacion del empleado: \nnombre: " + nombre + "\nDNI: " + dni + "\nEmail: " + email
				+ "\nContraseña: " + clave;
	}
	
	
	
}
