
class Usuario {
/*Campos de clase
 -----------------------------------------------------------------------------------------------------------------------------*/
	public String nombre;
	public int edad;
	public String DNI;
	
/*Constructor de clase sin parámetros
 -----------------------------------------------------------------------------------------------------------------------------*/
	public Usuario() {
		
	}//Fin del constructor
	
/*Métodos de clase
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
	
	//En este método se valora mediante un booleano, si el DNI introducido tiene el formato adecuado o no
	public boolean setDNI(String DNI) {
		
		if(DNI.matches("^[0-9]{8}[A-Z]$")||DNI.matches("^[0-9]{8}-[A-Z]$")) {
			this.DNI = DNI;
			return true;
		}else {
			return false;
		}
	}
	
	//En este método se devuelve la información del usuario que está usando esta cuenta
	public String toString() {
		return "INFORMACIÓN DE USUARIO"
				+ "\n----------------------"
				+ "\nNombre: "+nombre+"."
				+ "\nEdad: "+edad+"."
				+ "\nDNI: "+DNI+".";
	}
}
