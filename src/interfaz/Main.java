package interfaz;

import java.util.LinkedList;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import logica.Deposito;
import logica.Direccion;
import logica.Encargado;
import logica.Gerente;
import logica.Producto;
import logica.Sucursal;
import logica.Usuario;
import logica.Vendedor;

public class Main {

	public static void main(String[] args) {
		
		String selec;
		int seleccion;
		Direccion d1 = new Direccion("12","32","23","localidad");
		Vendedor v1 = new Vendedor("Juan Navarro","40566554","asdasd@hotmail.com","4321","1");
		Vendedor v2 = new Vendedor("Juan NaVarro","40566554","asdasd@hotmail.com","4321","2");
		Vendedor v3 = new Vendedor("Juan Nabarro","40566554","asdasd@hotmail.com","4321","3");
		Gerente g1 = new Gerente("Juan Nabaro","40566554","asdasd@hotmail.com","4321","1");

		Encargado e1 = new Encargado("Juan Navarro","40566554","asdasd@hotmail.com","4321","3");
		e1.setLogin(true);
		
		

		// Testeo de listas
		
		Deposito dep = new Deposito("1", new ArrayList<Producto>());
		
		Sucursal s1 = new Sucursal("1",d1,dep,e1,g1,new LinkedList<Vendedor>());
		s1.getVendedores().add(v3);
		s1.getVendedores().add(v2);
		s1.getVendedores().add(v1);
		
		dep.getListaProductos().add( new Producto("1","calzado","Jordan",39.99,34));
		dep.getListaProductos().add( new Producto("2","remera","Jordan",35.99,5));
		dep.getListaProductos().add( new Producto("3","pantalon","Jordan",37.99,14));
		dep.getListaProductos().add( new Producto("4","gorra","Jordan",38.99,10));
		
		String info="";
		String infoS="";
		for (Producto listaproductos : dep.getListaProductos()) {
			info = info + listaproductos + "\n";
		}
		
		JOptionPane.showMessageDialog(null, info);
		
		
		for (Vendedor listaVendedores : s1.getVendedores()) {
			infoS = infoS + listaVendedores + "\n";
		}
		
		JOptionPane.showMessageDialog(null, infoS);
		
		
		
		//JOptionPane.showMessageDialog(null, dep.toString());
		System.out.println(s1.toString());
		

		// Testeo de funcionalidades de usuarios
		
	/*	
		


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
		/*
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
		

		
		
*/
		
		
		

		
		

	}

}
