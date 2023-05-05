package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Deposito;
import logica.Encargado;
import logica.Gerente;
import logica.Usuario;
import logica.Vendedor;

public class Main {

	public static void main(String[] args) {
		Usuario users[] = new Usuario[10];
		Gerente g[] = new Gerente[10];
		Vendedor v[] = new Vendedor[10];
		String selec;
		int seleccion;
		
		Gerente g1 = new Gerente("Juan Gil Navarro","40566554","asdasd@hotmail.com","1234","3");
		Gerente g2 = new Gerente("Juan Navarro","40566554","asdasd@hotmail.com","4321","3");
		Encargado e1 = new Encargado("Juan Navarro","40566554","asdasd@hotmail.com","4321","3");
		e1.setLogin(true);
		
		
		LinkedList<Gerente> ge = new LinkedList<Gerente> ();
		
		
	//	Deposito deposito = new Deposito(null, null); 

		do {
			
		
		do {
		selec = (String) JOptionPane.showInputDialog("Bienvenido! Elija que accion quiere hacer \n1-logear \n2-ABM usuario \n3-Log out \n4-Salir");
		} while (!selec.equalsIgnoreCase("1") && !selec.equalsIgnoreCase("2") && !selec.equalsIgnoreCase("3") && !selec.equalsIgnoreCase("4") );
		
		seleccion = Integer.parseInt(selec);
		
		switch (seleccion) {
		// Login // 
		case 1:
			
			
			if (g1.isLogin()) {
				JOptionPane.showMessageDialog(null, "Ya esta logeado");
				
			} else {
				g1.logear(null, null);
			}
			
			break;
			
			
			// ABM Usuario // 
		case 2:
			
			
			if (g1.isLogin()) {
			do {
				selec = (String) JOptionPane.showInputDialog("Elija que accion quiere hacer \n1-crear usuario \n2-Modificar usuario \n3-eliminar usuario \n4-salir");
				} while (!selec.equalsIgnoreCase("1") && !selec.equalsIgnoreCase("2") && !selec.equalsIgnoreCase("3") && !selec.equalsIgnoreCase("4") );
				
				seleccion = Integer.parseInt(selec);
				
				switch (seleccion) {
				case 1:
					
						g1.crearUsuario(null, null, null, null, null, null);	
						
					break;
					
					
					
				case 2:
				/*	seleccion = Integer.parseInt(JOptionPane.showInputDialog("elija que tipo de usuario modificar \n 1-vendedor \n2-gerente"));
					if (seleccion==1) {
						JOptionPane.showMessageDialog(null, "Lista de vendedores: ");
						for (int i = 0; i < v.length; i++) {
							JOptionPane.showMessageDialog(null, g[i]);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Lista de gerentes: ");
						for (int i = 0; i < g.length; i++) {
							JOptionPane.showMessageDialog(null, g[i]);
						}

					}
					
				 	*/ 
					g1.editarUsuario();
					
					
					
					break;
				case 3:

					JOptionPane.showMessageDialog(null, g1.toString());
					g1.eliminarUsuario();
					JOptionPane.showMessageDialog(null, g1.toString());
					break;
					
				case 4:
					JOptionPane.showMessageDialog(null, "Saliendo...");


				}
		} else {
			JOptionPane.showMessageDialog(null, "El usuario no esta logeado");
		}
			
			break;
			
			
			
			// Log Out // 
		case 3:

			if (g1.isLogin()) {
				g1.logOut();
				JOptionPane.showMessageDialog(null, "Log out exitoso");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no esta logeado");
			}
			break;
			
			// Salir // 
		case 4: 
			JOptionPane.showMessageDialog(null, "Adios!");
		}
		
		} while (seleccion != 4);
		

		
		e1.agregarProducto();
		

		
		

		
		
		

		
		

	}

}
