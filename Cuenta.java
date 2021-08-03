import java.awt.*;
import java.util.ArrayList;

final class Cuenta extends Usuario{

//Campos de clase
//-----------------------------------------------------------------------------------------------------------------------
	double saldo=0;
	Usuario usuario = new Usuario(); //Este se pasará como parámetros al constructor de clase
	ArrayList<Gasto>gastos = new ArrayList<Gasto>();
	ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();

/*Constructor de clase
------------------------------------------------------------------------------------------------------------------------*/	
	public Cuenta(Usuario usuario) {
		this.usuario = usuario;
	}
	
/*Métodos de clase
------------------------------------------------------------------------------------------------------------------------*/
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	
	public Usuario getUsario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
		
	public double addIngresos(String description, double cantidad) {
		ingresos.add(new Ingreso(cantidad,description));//Se añaden los diferentes objetos Ingreso en el ArrayList ingresos.
		saldo +=cantidad;//Aquí se suma la cifra del parámetro cantidad a la variable saldo.
		System.out.println("\n¡Ingreso realizado correctamente! Volviendo al menú...");
		try {
			Thread.sleep(3000);//Paro el programa 3 segundos para recrear el procesamiento de la solicitud del ingreso.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}
	
	public double addGastos(String description, double cantidad) throws GastoException {
		
		//Se lanza la excepcion con el método por el lanzamiento manual dentro de él
		if(cantidad<saldo) {
			gastos.add(new Gasto(cantidad,description));
			saldo -=cantidad;
		}else {
			/*Se lanza manualmente la excepción para que se tenga que capturar el programa en caso de que el gasto sea mayor que el saldo
			del que se dispone*/
			throw new GastoException(); 
		}
		System.out.println("\n¡Pago realizado correctamente! Volviendo al menú...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}
	
	public ArrayList<Ingreso> getIngresos(){
		return ingresos;
	}
	public ArrayList<Gasto> getGastos(){
		return gastos;
	}
	
	public String toString() {//Devuelve los datos del usuario por consola
		
		Cuenta mi_cuenta = new Cuenta(usuario);
		
		return "USUARIO"
				+"\nNombre: "+usuario.getNombre()
				+"\nEdad: "+usuario.getEdad()
				+"\nDNI: "+usuario.DNI
				+"\nSaldo actual: "+saldo+"€";
	}
	
}
