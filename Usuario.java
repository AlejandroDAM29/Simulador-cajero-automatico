
class Usuario {
/*Campos de clase
 -----------------------------------------------------------------------------------------------------------------------------*/
	public String nombre;
	public int edad;
	public String DNI;
	
/*Constructor de clase sin par�metros
 -----------------------------------------------------------------------------------------------------------------------------*/
	public Usuario() {
		
	}//Fin del constructor
	
/*M�todos de clase
 -----------------------------------------------------------------------------------------------------------------------------*/
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public  void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	//En este m�todo se valora mediante un booleano, si el DNI introducido tiene el formato adecuado o no
	public boolean setDNI(String DNI) {
		
		if(DNI.matches("^[0-9]{8}[A-Z]$")||DNI.matches("^[0-9]{8}-[A-Z]$")) {
			this.DNI = DNI;
			return true;
		}else {
			return false;
		}
	}
	
	//En este m�todo se devuelve la informaci�n del usuario que est� usando esta cuenta
	public String toString() {
		return "INFORMACI�N DE USUARIO"
				+ "\n----------------------"
				+ "\nNombre: "+nombre+"."
				+ "\nEdad: "+edad+"."
				+ "\nDNI: "+DNI+".";
	}
}
