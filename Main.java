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
			   S.nextLine();//Este Scanner se usa para limpiar el b�fer
			   System.out.println("Por favor, introduce una edad v�lida.");
		}
		S.nextLine();//Este act�a de limpieza para el retorno de carro que se queda en el b�fer si se entra en el try		
		
		
		/*Esto para introducir el DNI de usuario
		-----------------------------------------------------------------------------------------------------------------------------------*/
	System.out.println("- Introduce un DNI v�lido. Recuerda que debe tener 8 caracteres num�ricos y una letra final. Entre n�meros"
			+ "y letras puede haber un gui�n.\nAqu� tienes dos ejemplos: 78844112L / 78844112-L");
		String DNI;
		
		do {
			DNI =S.nextLine().toUpperCase();//Uso UpperCase para validar el DNI cuando se ponga may�scula o min�scula en la letra del DNI
			usuario.setDNI(DNI);
			
			//Si el DNI introducido no es v�lido saltar� el siguiente mensaje.
			if(usuario.setDNI(DNI)==false)
				System.out.println("DNI incorrecto. Por favor, respeta el formato que se pide en la descripcion\n");
			
		}while(usuario.setDNI(DNI)==false);//Hasta que pongamos un DNI v�lido, no saldremos del bucle.
		
	System.out.println("DNI agregado correctamente.\n�USUARIO CREADO!"
			+ "Creando cuenta, espere unos instantes...");
	
	try {
		/*Se para el programa durante 3 segundos para recrear el procesamiento de creaci�n de la cuenta.
		 Este m�todo obliga a capturar posibles errores.*/
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	/*MEN�
	 * ------------------------------------------------------------------------------------------------------------------------------------*/
	int eleccion=0;
	boolean eleccion_menu=false;
	/*Este booleano har� que siempre que escojamos un opci�n o cometamos un error, regresemos al men� principal. La �nica forma de salir del
	 * bucle, ser� seleccionar la opcion 0, en la que el booleano eleccion_menu tendr� el valor de true*/
	
	while(!eleccion_menu) {	
		
	 System.out.println("\nRealiza una nueva acci�n:"
	 		+ "\n1 Introduce un nuevo gasto"
	 		+ "\n2 Introduce un nuevo ingreso"
	 		+ "\n3 Mostrar gastos"
	 		+ "\n4 Mostrar ingresos"
	 		+ "\n5 Mostrar saldo"
	 		+ "\n0 Salir");
	 
	 try {
	 /*Si el usuario introduce un n�mero fuera del rango esperado en el men� o una letra, estar� caputrado y te har� elegir una opci�n en
		 el men� otra vez*/
	 eleccion = S.nextInt();
	 
	 //Cada case de este switch representa una opci�n del men� anterior.
	 if(eleccion >=0 && eleccion<6) {
		 
			switch(eleccion) {
			case 1://Introduce un nuevo gasto
				System.out.println("Introduce la cantidad a pagar");
				dinero = S.nextDouble();
				S.nextLine();
				System.out.println("Escribe un concepto de ingreso");
				description = S.nextLine();
				
				/*Esta excepci�n est� obligada a ser lanzada, ya que en el m�todo addGastos() de la clase cuenta se lanza manualmente esta
				 * excepci�n*/
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
				espacio();//Explicado en el mismo m�todo.
				}catch(RuntimeException e) {
					System.err.println("Error al realizar el ingreso.");
					S.nextLine();
				}
				break;
				
			case 3://Mostrar gastos
				
				for(int i=0;i<cuenta.getGastos().size();i++) {
					System.out.println(cuenta.getGastos().get(i).toString());//Imprime los elementos del ArrayList gastos de la clase cuenta 
				}
				
				System.out.println("Presione ENTER para volver al men� principal");
				S.nextLine();//Este m�todo limpia el b�fer y el siguiente es el que registra la tecla ENTER
				S.nextLine();
				espacio();
				break;
				
			case 4://Mostrar ingresos
				
				for(int i=0;i<cuenta.getIngresos().size();i++) {
					System.out.println(cuenta.getIngresos().get(i).toString());//Imprime los elementos del ArrayList ingresos de la clase cuenta 
				}
				
				System.out.println("Presione ENTER para volver al men� principal");
				S.nextLine();//Este m�todo limpia el b�fer y el siguiente es el que registra la tecla ENTER
				S.nextLine();
				espacio();
				
				break;
				
			case 5://Mostrar saldo
				
				System.out.println("Su saldo actual es de: "+cuenta.getSaldo()+" �");
				System.out.println("Presione ENTER para volver al men� princiapl");
				S.nextLine();//Este m�todo limpia el b�fer y el siguiente es el que registra la tecla ENTER
				S.nextLine();
				espacio();
				break;
				
			case 0://Salir del programa
				System.out.println("Fin del programa\nGracias por utilizar la aplicaci�n");
				eleccion_menu = true; //El valor true, permite salir del bucle que te hace volver al men� principal
				break;
					 
			}//Fin de switch
	 }else {
		//Este else actuar� si el usuario introduce un valor fuera del rango entre 0 y 5
		 System.err.println("Introduce una opci�n v�lida");
	 }
	 }catch(InputMismatchException e) {
		 S.nextLine();
		 System.err.println("Introduce una opci�n v�lida.");
		 }//Fin de catch

	}//Fin de bucle while	
	
		
	}//Fin del m�todo main
	
	//Este m�todo est�tico hace que hayan 100 saltos de l�neas para simular una limpieza de pantalla.
	static void espacio() {
		for(int i=0;i<100;i++) {
			System.out.println();
		}//Fin de bucle for
	}//Fin de m�todo espacio()
	

}//Fin de clase
