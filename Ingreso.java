
public class Ingreso extends Dinero{

	/*Constructor de clase
     -------------------------------------------------------------------------------------------------------- */
	public Ingreso(double ingreso, String description) {
		dinero = ingreso;
		this.description = description;
	}//Fin de constructor
	
	/*M�todo de clase para ense�ar los datos del ingreso por consola.
	 --------------------------------------------------------------------------------------------------------*/
	public String toString() {
		int pago=0;
		pago++;
		return "Euros ingresados: "+dinero
				+"\nConcepto de ingreso: "+description+"\n";
	}
	
	/*M�todos heredados de la clase padre "Dinero" y que por lo tanto deben ser implementados, ya que en Dinero son m�todos abstractos
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
