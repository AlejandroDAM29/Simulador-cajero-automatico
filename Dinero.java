//Clase abstracta
abstract class Dinero {
	
//Los campos y métodos de esta clase están protegidos porque serán heredados por las clases Gasto e Ingreso	
	
	
/*Campos de clase
 ---------------------------------------------------------------------------------------------------------------*/
protected double dinero;
protected String description;

/*Métodos: los declaro en abstractos para poder desarrollarlos de forma independiente en subclases
----------------------------------------------------------------------------------------------------------------*/
protected abstract double getDinero();
protected abstract void setDinero(double dinero);
protected abstract String getDescription();
protected abstract void setDescription(String description);
}
