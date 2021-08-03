
public class Ingreso extends Dinero{

	/*Constructor de clase
     -------------------------------------------------------------------------------------------------------- */
	public Ingreso(double ingreso, String description) {
		dinero = ingreso;
		this.description = description;
	}//Fin de constructor
	
	/*Método de clase para enseñar los datos del ingreso por consola.
	 --------------------------------------------------------------------------------------------------------*/
	public String toString() {
		int pago=0;
		pago++;
		return "Euros ingresados: "+dinero
				+"\nConcepto de ingreso: "+description+"\n";
	}
	
	/*Métodos heredados de la clase padre "Dinero" y que por lo tanto deben ser implementados, ya que en Dinero son métodos abstractos
	 -------------------------------------------------------------------------------------------------------------------------*/
	public double getDinero() {
		return dinero;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDinero(double dinero) {
		this.dinero=dinero;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}//Fin de clase
