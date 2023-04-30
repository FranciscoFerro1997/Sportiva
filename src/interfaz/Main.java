package interfaz;

import javax.swing.JOptionPane;

import logica.Gerente;
import logica.Usuario;
import logica.Vendedor;

public class Main {

	public static void main(String[] args) {
		
		Gerente u1 = new Gerente("Juan Gil Navarro","40566554","asdasd@hotmail.com","ElGil","1234","3");
		String selec;
		int seleccion;
		do {
			
		
		do {
		selec = (String) JOptionPane.showInputDialog("Bienvenido! Elija que accion quiere hacer \n1-logear \n2-crear usuario \n3-salir");
		} while (!selec.equalsIgnoreCase("1") && !selec.equalsIgnoreCase("2") && !selec.equalsIgnoreCase("3") );
		
		seleccion = Integer.parseInt(selec);
		
		switch (seleccion) {
		case 1:
			
			u1.logear(null, null);
			
			break;
		case 2:
			
			if (u1.isLogin()) {
			u1.crearUsuario(null, null, null, null, null, null);	
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no esta logeado");
			}
			
			break;
		case 3: 
			JOptionPane.showMessageDialog(null, "Adios!");
		}
		} while (seleccion != 3);
		

		
		
		
		
		
		
		
		
		
		

		
		
		

		
		

	}

}
