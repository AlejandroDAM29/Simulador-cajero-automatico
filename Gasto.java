
public class Gasto extends Dinero{

	/*Constructor de clase
	 -------------------------------------------------------------------------------------------------------------------*/
	public Gasto(double gasto, String description) {
		dinero = gasto;
		this.description = description;
	}
	
	/*Método de clase para mostrar los datos del pago por consola
	 -------------------------------------------------------------------------------------------------------------------*/
	public String toString() {
	return "Euros ingresados: "+dinero
			+"\nConcepto de pago: "+description+"\n";
	}
	
	/*Métodos heredados de la clase padre "Dinero" y que por lo tanto deben ser implementados, ya que en Dinero son métodos abstractos
	 -------------------------------------------------------------------------------------------------------------------*/
	
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
