package negocio.entidadesJPA;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQueries({
		@NamedQuery(name = "negocio.entidadesJPA.Tienda.findByid", query = "select obj from Tienda obj where obj.id = :id"),
		@NamedQuery(name = "negocio.entidadesJPA.Tienda.findBynombre", query = "select obj from Tienda obj where obj.nombre = :nombre"),
		@NamedQuery(name = "negocio.entidadesJPA.Tienda.findBydireccion", query = "select obj from Tienda obj where obj.direccion = :direccion"),
		@NamedQuery(name = "negocio.entidadesJPA.Tienda.findByactivo", query = "select obj from Tienda obj where obj.activo = :activo"),
		@NamedQuery(name = "negocio.entidadesJPA.Tienda.findBypresupuesto", query = "select obj from Tienda obj where obj.presupuesto = :presupuesto"),
		@NamedQuery(name = "negocio.entidadesJPA.Tienda.findByversion", query = "select obj from Tienda obj where obj.version = :version") })
public class Tienda implements Serializable
{
	private static final long serialVersionUID = 0;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String direccion;
	private boolean activo;
	@OneToMany(mappedBy = "tienda")	private Set<Presupuesto> presupuesto;
	@Version private int version;
	
	public Tienda () { }
	
	public Tienda(int id, String nombre, String direccion, boolean activo) 
	{
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.activo = activo;
	}

	public Tienda(String nombre, String direccion, boolean activo) 
	{
		this.nombre = nombre;
		this.direccion = direccion;
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

	public String getDireccion() 
	{
		return direccion;
	}

	public boolean getActivo() 
	{
		return activo;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}

	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}

	public void asignarDepartamento() 
	{

	}

	public void desasignarDepartamento() 
	{

	}
}