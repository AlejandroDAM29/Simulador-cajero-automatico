//Clase abstracta
abstract class Dinero {
	
//Los campos y m�todos de esta clase est�n protegidos porque ser�n heredados por las clases Gasto e Ingreso	
	
	
/*Campos de clase
 ---------------------------------------------------------------------------------------------------------------*/
protected double dinero;
protected String description;

/*M�todos: los declaro en abstractos para poder desarrollarlos de forma independiente en subclases
----------------------------------------------------------------------------------------------------------------*/
protected abstract double getDinero();
protected abstract void setDinero(double dinero);
protected abstract String getDescription();
protected abstract void setDescription(String description);
}
