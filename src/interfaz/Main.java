package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Encargado;
import datos.Gerente;
import datos.Producto;
import datos.Usuario;
import datos.Vendedor;
import interfaces.Conexion;
import negocio.Verifica;

public class Main {
	public static void main(String[] args) {

		//conectar a la bdd
		Conexion con = new Conexion();
		Connection conexion = con.conectar();
		PreparedStatement stmt;
		
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		
		//Datos que traigo de la base de datos para iniciar sesion
		String sql = "SELECT nombre, apellido, dni, clave, fk_puesto " 
				   + "FROM usuario;";
		String[] datos = new String[5];

		try {
			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();

			while (result.next()) { //Guardo en array los Datos de la query
				datos[0] = result.getString(1);// nombre
				datos[1] = result.getString(2);// apellido
				datos[2] = result.getString(3);// dni
				datos[3] = result.getString(4);// clave
				datos[4] = result.getString(5);// puesto
				
				if (Integer.parseInt(datos[4]) == 1) { //Comparo el puesto con 1 = Gerente
					Gerente nuevoGerente = new Gerente(datos[0], datos[1], datos[2], null, null, datos[3], Integer.parseInt(datos[4]), 0);
					usuarios.add(nuevoGerente); //Guardo el objeto Gerente en lista usuarios.
					
				} else if (Integer.parseInt(datos[4]) == 2) { //Comparo el puesto con 2 = Vendedor
					Vendedor nuevoVendedor = new Vendedor(datos[0], datos[1], datos[2], null, null, datos[3], Integer.parseInt(datos[4]), 0);
					usuarios.add(nuevoVendedor); //Guardo el objeto Vendedor en lista usuarios.
					
				} else if (Integer.parseInt(datos[4]) == 3) { //Comparo el puesto con 3 = Encargado
					Encargado nuevoEncargado= new Encargado(datos[0], datos[1], datos[2], null, null, datos[3], Integer.parseInt(datos[4]), 0);
					usuarios.add(nuevoEncargado); //Guardo el objeto Encargado en lista usuarios.
				}
			}
		} catch (Exception excepcion) {
			JOptionPane.showMessageDialog(null, excepcion.getMessage());
		}
		
		//Inicio el login
		iniciarSesion(usuarios);
		
	} //Fin del Main
		
	public static void iniciarSesion(LinkedList<Usuario> usuarios) {
		String dni =  JOptionPane.showInputDialog("Ingrese su DNI");
		String clave = JOptionPane.showInputDialog("Ingrese su CLAVE");
		
			for (Usuario usuario : usuarios) { //Recorro lista usuarios
			//Si logueo exitoso abre el menu del puesto que corresponda
				if (usuario.login(dni, clave) && usuario.getPuesto()==1) {
					JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente!"
							+ "\n Bienvenido "+usuario.getNombre()+" "+usuario.getApellido() );
					menuGerente(usuarios);
				} else if(usuario.login(dni, clave) && usuario.getPuesto()==2){
					JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente!"
							+ "\n Bienvenido "+usuario.getNombre()+" "+usuario.getApellido() );
					menuVendedor(usuarios);
				} else if(usuario.login(dni, clave) && usuario.getPuesto()==3) {
					JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente!"
							+ "\n Bienvenido "+usuario.getNombre()+" "+usuario.getApellido() );
					menuEncargado(usuarios);
				} 
			}
			// Logueo NO exitoso
				JOptionPane.showMessageDialog(null, "Datos incorrectos\n"
						+ "Has escrito algo mal\n"
						+ "o has deslogeado \n"
						+ "o te han funado xD\n\n"
						+ "Vuelve a intentarlo");
				iniciarSesion(usuarios);
	}
	
	//Menu que debe aparecer si el usuario es Gerente
	public static void menuGerente(LinkedList<Usuario> usuarios) {
		Verifica ver = new Verifica();
		
		String[] opciones = { " Visualizar usuario",
							  " Agregar usuario",
							  " Mostrar lista usuarios",
							  " Eliminar usuario",
							  " Editar usuario",
							  " Ver sponsors disponibles",
							  " Ver equipos clasificados",
							  " Ver equipos pendientes",
							  " Salir" };
		
		String[] opcionesP = {"1", "2", "3"};
		String[] opcionesS = {"1", "2", "3"};
		String opcion="";
		
		do {
			opcion = (String)JOptionPane.showInputDialog(null, "Seleccione la opcion deseada",
					"SPORTIVA - MENU GERENTE",JOptionPane.DEFAULT_OPTION,null, opciones,opciones[0]);
			
			switch (opcion) {
			case " Visualizar usuario":
				int idE=0;
				do {
					try {
						idE= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado a traer"));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
					}
				} while (idE<=0);
				
				try {
					if (ver.verificaUsuario(idE).isEmpty()) {
						
					} else {
					JOptionPane.showMessageDialog(null, ver.verificaUsuario(idE));
					}
				} catch (Exception e) {
					
				}
				break;
			case " Agregar usuario":
					
					String nombre= JOptionPane.showInputDialog("Ingrese nombre del nuevo usuario");
					String apellido= JOptionPane.showInputDialog("Ingrese apellido del nuevo usuario");
					String dni= JOptionPane.showInputDialog("Ingrese dni del nuevo usuario");
					String email= JOptionPane.showInputDialog("Ingrese email del nuevo usuario");
					String telefono= JOptionPane.showInputDialog("Ingrese telefono del nuevo usuario");
					int puesto= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Seleccione el puesto\n1-Gerente\n2-Vendedor\n3-Encargado",
							"SPORTIVA - MENU GERENTE",JOptionPane.DEFAULT_OPTION,null, opcionesP,opcionesP[0]));
					int sucursal= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese la sucursal\n1-Corrientes\n2-Brasil\n3-Gaona",
							"SPORTIVA - MENU GERENTE",JOptionPane.DEFAULT_OPTION,null, opcionesS,opcionesS[0]));
					String clave= JOptionPane.showInputDialog("Ingrese clave del nuevo usuario");
					
					if (ver.verificarAgregar(nombre, apellido, dni, email, telefono, clave, puesto, sucursal)) {
						JOptionPane.showMessageDialog(null, "Usuario creado con exito");
						
					} else {
						JOptionPane.showMessageDialog(null, "Error al crear el usuario");
					}
				
				break;
			case " Mostrar lista usuarios":
				
				if( ver.verificaLista().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay usuarios");
				}else {
					JOptionPane.showMessageDialog(null, ver.verificaLista());
				}
				
				break;
			case " Eliminar usuario":
				
				// Verifico que la Base de datos tenga usuarios que eliminar
			    if (ver.verificaLista().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "No hay usuarios disponibles para eliminar");
			    }
			    // Comienzo a eliminar
			    else {
			    	// Creo la lista de usuarios de mi BDD
			        LinkedList<Gerente> usuariosE = ver.verificaLista();
			        String[] nombres = new String[usuariosE.size()];
			        // Recorro la BDD y lleno la lista de usuarios con todos los usuarios de la BDD
			        for (int i = 0; i < usuariosE.size(); i++) {
			            nombres[i] = usuariosE.get(i).getNombre();
			        }
			        // Selecciono el usuario que quiero eliminar
			        String nombreselecionado = (String) JOptionPane.showInputDialog(null, "Elija que usuario quiere eliminar", "Menu eliminar",
			                JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
			        // Creo la variable "Aeliminar" donde voy a poner el usuario que quiero borrar de mi BDD
			        Gerente Aeliminar = null;
			        // Ingreso el usuario a eliminar en la variable "Aeliminar"
			        for (Gerente usuario : usuariosE) {
			            if (usuario.getNombre().equals(nombreselecionado)) {
			                Aeliminar = usuario;
			            }
			        
				
				
				
				

				
				try {
					if (ver.verificaUsuario(Integer.parseInt( Aeliminar.getId())).isEmpty()) {
						
					} else if (ver.verificarEliminar(Integer.parseInt( Aeliminar.getId()))) {
						JOptionPane.showMessageDialog(null, "Se elimino correctamente el usuario");
					}
					else {
					JOptionPane.showMessageDialog(null, ver.verificaUsuario(Integer.parseInt( Aeliminar.getId())));
					}
				} catch (Exception e) {
					
			}
				
				
			     }
	}
			    break;
			case " Editar usuario":
				
				// Verifico que la Base de datos tenga usuarios que editar
			    if (ver.verificaLista().isEmpty()) {
			        JOptionPane.showMessageDialog(null, "No hay usuarios disponibles para editar");
			    }
			    // Comienzo a editar
			    else {
			    	// Creo la lista de usuarios de mi BDD
			        LinkedList<Gerente> usuariosL = ver.verificaLista();
			        String[] nombres = new String[usuariosL.size()];
			        // Recorro la BDD y lleno la lista de usuarios con todos los usuarios de la BDD
			        for (int i = 0; i < usuariosL.size(); i++) {
			            nombres[i] = usuariosL.get(i).getNombre();
			        }
			        // Selecciono el usuario que quiero editar
			        String nombreselecionado = (String) JOptionPane.showInputDialog(null, "Elija que usuario quiere editar", "Menu editar",
			                JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
			        // Creo la variable "Aeditar" donde voy a colocar todos los datos de la persona a editar
			        Gerente Aeditar = null;
			        // Ingreso el usuario a editar en la variable "Aeditar"
			        for (Gerente usuario : usuariosL) {
			            if (usuario.getNombre().equals(nombreselecionado)) {
			                Aeditar = usuario;
			                JOptionPane.showMessageDialog(null,"Usuario a editar: \n" +  ver.verificaUsuario(Integer.parseInt(Aeditar.getId())));
			            }
			        }
			        

			        String[] editar = { "Nombre", "Apellido", "Dni", "Email", "Telefono", "Clave", "Sucursal", "Puesto",  "Finalizar" };
			        String seleccionar = "";

			        do {
			            seleccionar = (String) JOptionPane.showInputDialog(null,
			                    "Elija qué dato va a editar del usuario " + Aeditar.getNombre() + " " + Aeditar.getApellido() , "", JOptionPane.DEFAULT_OPTION,
			                    null, editar, editar[0]);

			            switch (seleccionar) {
			                case "Nombre":
			                    Aeditar.setNombre(JOptionPane.showInputDialog("Elija nombre nuevo"));
			                    break;
			                case "Apellido":
			                    Aeditar.setApellido(JOptionPane.showInputDialog("Elija apellido nuevo"));
			                    break;
			                case "Dni":
			                    Aeditar.setDni(JOptionPane.showInputDialog("Elija DNI nuevo"));
			                    break;
			                case "Email":
			                	Aeditar.setEmail(JOptionPane.showInputDialog("Elija email nuevo"));
			                	break;
			                case "Telefono":
			                	Aeditar.setTelefono(JOptionPane.showInputDialog("Elija telefono nuevo"));
			                	break;
			                case "Clave":
			                	Aeditar.setClave(JOptionPane.showInputDialog("Elija Clave nueva"));
			                	break;
			                case "Sucursal":
								Aeditar.setSucursal(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Ingrese la sucursal\n1-Corrientes\n2-Brasil\n3-Gaona",
										"SPORTIVA - MENU GERENTE",JOptionPane.DEFAULT_OPTION,null, opcionesS,opcionesS[0])));
			                	break;
			                case "Puesto":
			                	Aeditar.setPuesto(Integer.parseInt((String) JOptionPane.showInputDialog(null, "Seleccione el puesto\n1-Gerente\n2-Vendedor\n3-Encargado",
										"SPORTIVA - MENU GERENTE",JOptionPane.DEFAULT_OPTION,null, opcionesP,opcionesP[0])));
			                	break;
			                default:
			                    break;
			            }
			        } while (!seleccionar.equals("Finalizar"));
			        
			        ver.verificaEditar(Aeditar);
			        JOptionPane.showMessageDialog(null,"Usuario editado: \n" +  ver.verificaUsuario(Integer.parseInt(Aeditar.getId())));
			    }
			    break;
			case " Ver sponsors disponibles":
				
				break;
			case " Ver equipos clasificados":
				
				break;
			case " Ver equipos pendientes":
				
				break;
				
			default:
				break;
			}
			
		} while(!opcion.equals(" Salir" ));
	}
	//Menu que debe aparecer si el usuario es Vendedor
	public static void menuVendedor(LinkedList<Usuario> usuarios) {
		//Vendedor nuevoVendedor = new Vendedor ("", "", "", "", "", false, 0);
		LinkedList<Producto> productos = new LinkedList<Producto>();
		LinkedList<Producto> stockEnCorrientes = new LinkedList<Producto>();
		LinkedList<Producto> stockEnBrasil = new LinkedList<Producto>();
		LinkedList<Producto> stockEnGaona = new LinkedList<Producto>();

		//conectar a bdd	
		Conexion con = new Conexion();
		Connection conexion = con.conectar();
		PreparedStatement stmt;
		
		Verifica verifica = new Verifica();
		
		String[] opciones = { " Realizar una venta",
							  " Imprimir factura",
							  " Revisar stock de un producto",
							  " Ver stock de todos los productos",
							  " Realizar pedido al deposito",
							  " Ver ventas realizadas",
							  " Recaudacion Total",
							  " Salir" };
		String opcion="";
		
		do {
			opcion = (String)JOptionPane.showInputDialog(null, "Seleccione la opcion deseada",
				"SPORTIVA - MENU VENDEDOR",JOptionPane.DEFAULT_OPTION,null, opciones,opciones[0]);
			switch (opcion) {
			case " Realizar una venta":
				String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
				String[] cajas = {"1","2","3"};
				
				String fecha = (String) JOptionPane.showInputDialog(
						null, "Seleccione el dia de hoy","SPORTIVA"
						,JOptionPane.QUESTION_MESSAGE ,null ,dias, dias[0]);
				
				String caja = (String) JOptionPane.showInputDialog(
						null, "Seleccione en cual caja esta operando:","SPORTIVA"
						,JOptionPane.QUESTION_MESSAGE ,null ,cajas, cajas[0]);
				
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad de productos:"));
				
				break;
			case " Imprimir factura":
				
				break;
			case " Revisar stock de un producto":
					if(verifica.stockPorProducto().isEmpty()) {
						JOptionPane.showMessageDialog(null, "No se encontro producto");
					}else {
						JOptionPane.showMessageDialog(null, verifica.stockPorProducto());
					}
				
				break;
			case " Ver stock de todos los productos":
				if( verifica.verStockProductos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lista vacia, no hay stock");
				}else {
					JOptionPane.showMessageDialog(null, verifica.verStockProductos());
				}
				break;
			case "Mostrar lista personas":
				break;
			case " Realizar pedido al deposito":
				
				break;
			case " Ver ventas realizadas":
				
				break;
			case " Recaudacion Total":
				
				break;
				
			default: iniciarSesion(usuarios);
				break;			
			}
		
		} while(!opcion.equals(" Salir" ));
		
	}
	//Menu que debe aparecer si el usuario es Encargado
	public static void menuEncargado(LinkedList<Usuario> usuarios) {
		String[] opciones = { " Ver stock de todos los productos",
							  " Ver stock de un producto",
							  " Agregar nuevo producto",
							  " Renovar stock de un producto",
							  " Hacer pedido al proveedor",
							  " Salir" };
		String opcion="";
			
			do {
				opcion = (String)JOptionPane.showInputDialog(null, "Seleccione la opcion deseada",
						"SPORTIVA - MENU ENCARGADO",JOptionPane.DEFAULT_OPTION,null, opciones,opciones[0]);
				
				switch (opcion) {
				case " Ver stock de todos los productos":
					
					break;
				case " Ver stock de un producto":
					
					break;
				case " Agregar nuevo producto":
					
					break;
				case  " Renovar stock de un producto":
					
					break;
				case " Hacer pedido al proveedor":
					
					break;
					
				default: iniciarSesion(usuarios);
					break;			
				}
			
			} while(!opcion.equals(" Salir" ));
	}


}
	
