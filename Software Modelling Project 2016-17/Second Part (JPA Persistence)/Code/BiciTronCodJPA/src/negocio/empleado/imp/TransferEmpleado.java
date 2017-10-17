package negocio.empleado.imp;

public class TransferEmpleado 
{
	protected int id;
	protected String nombre;
	protected String dni;
	protected int telefono;
	protected double sueldo;
	protected int departamento;
	protected boolean activo;

	public TransferEmpleado(int id, String nombre, String dni, int telefono, double sueldo, int departamento, boolean activo) 
	{
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.activo = activo;
	}

	public TransferEmpleado(String nombre, String dni, int telefono, double sueldo, int departamento, boolean activo) 
	{
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.activo = activo;
	}

	public int getId() 
	{
		return id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public String getDni() 
	{
		return dni;
	}

	public int getTelefono() 
	{
		return telefono;
	}
	
	public double getSueldo() 
	{
		return sueldo;
	}	
	
	public int getDepartamento()
	{
		return departamento;
	}

	public boolean getActivo() 
	{
		return activo;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setDni(String dni) 
	{
		this.dni = dni;
	}

	public void setTelefono(int telefono) 
	{
		this.telefono = telefono;
	}

	public void setSueldo(double sueldo) 
	{
		this.sueldo = sueldo;
	}
	
	public void setDepartamento(int departamento)
	{
		this.departamento = departamento;
	}
	
	public void setActivo(boolean activo) 
	{
		this.activo = activo;
	}
}