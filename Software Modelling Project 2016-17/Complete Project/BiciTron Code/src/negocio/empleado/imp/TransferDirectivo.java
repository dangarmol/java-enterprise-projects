package negocio.empleado.imp;

public class TransferDirectivo extends TransferEmpleado {

	private String funcion;
	private double sueldoBase;

	public TransferDirectivo(String nombre, String dni, int telefono, double sueldo, int departamento, boolean activo, String funcion, Double sueldoBase) 
	{
		super(nombre, dni, telefono, sueldo, departamento, activo);
		this.funcion = funcion;
		this.sueldoBase = sueldoBase;
	}
	
	public TransferDirectivo(int id, String nombre, String dni, int telefono, double sueldo, int departamento, boolean activo, String funcion, double sueldoBase) 
	{
		super(id, nombre, dni, telefono, sueldo, departamento, activo);
		this.funcion = funcion;
		this.sueldoBase = sueldoBase;
	}

	public String getFuncion() 
	{
		return funcion;
	}

	public double getSueldoBase() 
	{
		return sueldoBase;
	}	
	
	public void setFuncion(String funcion) 
	{
		this.funcion = funcion;
	}

	public void setSueldoBase(double sueldoBase) 
	{
		this.sueldoBase = sueldoBase;
	}
	
	public String toString() 
	{
		return "Id: " + id + " Nombre: " + nombre + " Dni: " + dni + " Telefono: " + telefono + " Sueldo: "+ sueldo + " Departamento: " + departamento + " Funcion: " + funcion + " Sueldo base: " + sueldoBase + " Activo: " + activo;
	}
}