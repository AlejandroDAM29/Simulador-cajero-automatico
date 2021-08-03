import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	
	//Esta es la clase principal, que es la que va a iniciar el programa, ya que lleva el main.
	public static void main(String[] args) {
		
	//Creo el objeto usuario
		Usuario usuario = new Usuario();
		Cuenta cuenta = new Cuenta(usuario);
		Scanner S = new Scanner(System.in);
		String description;
		double dinero;
		
	/*Esto para introducir el nombre del usuario
	----------------------------------------------------------------------------------------------------------------------------------*/
	System.out.println("Bienvenido al programa de Sistema de gestion de usuarios Alejandro SL"
			+ ". Por favor, introduce un nombre de usuario para el registro");	
		String nombre=S.nextLine();
		usuario.setNombre(nombre);
		
		
		/*Esto para introducir la edad del usuario
		----------------------------------------------------------------------------------------------------------------------------------*/
		System.out.println("Introduce la edad del usuario: ");
		int edad;
		boolean edad_correcta=false;//Este booleano se usa para que el bucle siga hasta que se introduzca una edad realista.
		
		while(!edad_correcta)
			
			try {
				edad = S.nextInt();
				edad_correcta=true;
		   }catch(InputMismatchException e) {
			   S.nextLine();//Este Scanner se usa para limpiar el búfer
			   System.out.println("Por favor, introduce una edad válida.");
		}
		S.nextLine();//Este actúa de limpieza para el retorno de carro que se queda en el búfer si se entra en el try		
		
		
		/*Esto para introducir el DNI de usuario
		-----------------------------------------------------------------------------------------------------------------------------------*/
	System.out.println("- Introduce un DNI válido. Recuerda que debe tener 8 caracteres numéricos y una letra final. Entre números"
			+ "y letras puede haber un guión.\nAquí tienes dos ejemplos: 78844112L / 78844112-L");
		String DNI;
		
		do {
			DNI =S.nextLine().toUpperCase();//Uso UpperCase para validar el DNI cuando se ponga mayúscula o minúscula en la letra del DNI
			usuario.setDNI(DNI);
			
			//Si el DNI introducido no es válido saltará el siguiente mensaje.
			if(usuario.setDNI(DNI)==false)
				System.out.println("DNI incorrecto. Por favor, respeta el formato que se pide en la descripcion\n");
			
		}while(usuario.setDNI(DNI)==false);//Hasta que pongamos un DNI válido, no saldremos del bucle.
		
	System.out.println("DNI agregado correctamente.\n¡USUARIO CREADO!"
			+ "Creando cuenta, espere unos instantes...");
	
	try {
		/*Se para el programa durante 3 segundos para recrear el procesamiento de creación de la cuenta.
		 Este método obliga a capturar posibles errores.*/
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	/*MENÚ
	 * ------------------------------------------------------------------------------------------------------------------------------------*/
	int eleccion=0;
	boolean eleccion_menu=false;
	/*Este booleano hará que siempre que escojamos un opción o cometamos un error, regresemos al menú principal. La única forma de salir del
	 * bucle, será seleccionar la opcion 0, en la que el booleano eleccion_menu tendrá el valor de true*/
	
	while(!eleccion_menu) {	
		
	 System.out.println("\nRealiza una nueva acción:"
	 		+ "\n1 Introduce un nuevo gasto"
	 		+ "\n2 Introduce un nuevo ingreso"
	 		+ "\n3 Mostrar gastos"
	 		+ "\n4 Mostrar ingresos"
	 		+ "\n5 Mostrar saldo"
	 		+ "\n0 Salir");
	 
	 try {
	 /*Si el usuario introduce un número fuera del rango esperado en el menú o una letra, estará caputrado y te hará elegir una opción en
		 el menú otra vez*/
	 eleccion = S.nextInt();
	 
	 //Cada case de este switch representa una opción del menú anterior.
	 if(eleccion >=0 && eleccion<6) {
		 
			switch(eleccion) {
			case 1://Introduce un nuevo gasto
				System.out.println("Introduce la cantidad a pagar");
				dinero = S.nextDouble();
				S.nextLine();
				System.out.println("Escribe un concepto de ingreso");
				description = S.nextLine();
				
				/*Esta excepción está obligada a ser lanzada, ya que en el método addGastos() de la clase cuenta se lanza manualmente esta
				 * excepción*/
				try {
					cuenta.addGastos(description, dinero);
				} catch (GastoException e) {
					System.err.println("No es posible realizar el pago:saldo infuciente");
				}
				break;
				
			case 2://Realizar ingresos
				
				try {
				System.out.println("Introduce una cantidad a ingresar");
				dinero = S.nextDouble();
				S.nextLine();
				System.out.println("Escribe un concepto de ingreso");
				description = S.nextLine();
				cuenta.addIngresos(description, dinero);
				espacio();//Explicado en el mismo método.
				}catch(RuntimeException e) {
					System.err.println("Error al realizar el ingreso.");
					S.nextLine();
				}
				break;
				
			case 3://Mostrar gastos
				
				for(int i=0;i<cuenta.getGastos().size();i++) {
					System.out.println(cuenta.getGastos().get(i).toString());//Imprime los elementos del ArrayList gastos de la clase cuenta 
				}
				
				System.out.println("Presione ENTER para volver al menú principal");
				S.nextLine();//Este método limpia el búfer y el siguiente es el que registra la tecla ENTER
				S.nextLine();
				espacio();
				break;
				
			case 4://Mostrar ingresos
				
				for(int i=0;i<cuenta.getIngresos().size();i++) {
					System.out.println(cuenta.getIngresos().get(i).toString());//Imprime los elementos del ArrayList ingresos de la clase cuenta 
				}
				
				System.out.println("Presione ENTER para volver al menú principal");
				S.nextLine();//Este método limpia el búfer y el siguiente es el que registra la tecla ENTER
				S.nextLine();
				espacio();
				
				break;
				
			case 5://Mostrar saldo
				
				System.out.println("Su saldo actual es de: "+cuenta.getSaldo()+" €");
				System.out.println("Presione ENTER para volver al menú princiapl");
				S.nextLine();//Este método limpia el búfer y el siguiente es el que registra la tecla ENTER
				S.nextLine();
				espacio();
				break;
				
			case 0://Salir del programa
				System.out.println("Fin del programa\nGracias por utilizar la aplicación");
				eleccion_menu = true; //El valor true, permite salir del bucle que te hace volver al menú principal
				break;
					 
			}//Fin de switch
	 }else {
		//Este else actuará si el usuario introduce un valor fuera del rango entre 0 y 5
		 System.err.println("Introduce una opción válida");
	 }
	 }catch(InputMismatchException e) {
		 S.nextLine();
		 System.err.println("Introduce una opción válida.");
		 }//Fin de catch

	}//Fin de bucle while	
	
		
	}//Fin del método main
	
	//Este método estático hace que hayan 100 saltos de líneas para simular una limpieza de pantalla.
	static void espacio() {
		for(int i=0;i<100;i++) {
			System.out.println();
		}//Fin de bucle for
	}//Fin de método espacio()
	

}//Fin de clase
