package logica;

import javax.swing.JOptionPane;

public class Gerente extends Usuario {
	
	String id_gerente;
	
	
	
	public Gerente(String n, String dni, String e, String u, String c, String id) {
		super(n,dni,e,u,c);
		id_gerente= id;
	}
	
	
	public void crearUsuario(String n, String dni, String e, String u, String c, String id) {
		String selec;
		do {
		selec = JOptionPane.showInputDialog("Que tipo de usuario quiere crear? \n1-vendedor \n2-gerente \n3-salir");
		} while (!selec.equalsIgnoreCase("1") && !selec.equalsIgnoreCase("2") && !selec.equalsIgnoreCase("3"));
		
		int seleccion = Integer.parseInt(selec);
		
		switch (seleccion) {
		case 1:
			n= JOptionPane.showInputDialog("Ingrese nombre completo");
			dni=JOptionPane.showInputDialog("Ingrese DNI");
			e=JOptionPane.showInputDialog("Ingrese Email");
			u=JOptionPane.showInputDialog("Ingrese nombre de usuario");
			c= JOptionPane.showInputDialog("Ingrese contraseña");
			id=JOptionPane.showInputDialog("Ingrese id del vendedor");
			Vendedor vendedor1 = new Vendedor(n,dni,e,u,c,id);
			JOptionPane.showMessageDialog(null, "Usted esta creando un usuario con la siguiente informacion:\nnombre: " + n + "\nDNI: " + dni + "\nEmail: " + e + "\nUsername: " + u + 
				"\nContraseña: " + c + "\nid: " + id	);
			
			break;
		case 2:
			n= JOptionPane.showInputDialog("Ingrese nombre completo");
			dni=JOptionPane.showInputDialog("Ingrese DNI");
			e=JOptionPane.showInputDialog("Ingrese Email");
			u=JOptionPane.showInputDialog("Ingrese nombre de usuario");
			c= JOptionPane.showInputDialog("Ingrese contraseña");
			id=JOptionPane.showInputDialog("Ingrese id del gerente");
			Gerente gerente1 = new Gerente(n,dni,e,u,c,id);
			JOptionPane.showMessageDialog(null, "Usted esta creando un usuario con la siguiente informacion:\nnombre: " + n + "\nDNI: " + dni + "\nEmail: " + e + "\nUsername: " + u + 
					"\nContraseña: " + c + "\nid: " + id	);
			
			break;
		case 3: 
			JOptionPane.showMessageDialog(null, "Saliendo de crear usuario...");

		}
		

		
	}


	@Override
	public String toString() {
		return   super.toString() + "Gerente [id_gerente=" + id_gerente + "]";
	}
	
	
	
	

}
