package negocio.entidadesJPA;

import java.io.Serializable;
import java.util.ArrayList;

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
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findByid", query = "select obj from Departamento obj where obj.id = :id"),
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findByempleado", query = "select obj from Departamento obj where obj.empleado = :empleado"),
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findBynombre", query = "select obj from Departamento obj where obj.nombre = :nombre"),
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findBydescripcion", query = "select obj from Departamento obj where obj.descripcion = :descripcion"),
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findByactivo", query = "select obj from Departamento obj where obj.activo = :activo"),
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findBypresupuesto", query = "select obj from Departamento obj where obj.presupuesto = :presupuesto"),
		@NamedQuery(name = "negocio.entidadesJPA.Departamento.findByintversion", query = "select obj from Departamento obj where obj.version = :version") })
public class Departamento implements Serializable 
{
	private static final long serialVersionUID = 0;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	@OneToMany(mappedBy = "departamento")
	private ArrayList<Empleado> empleado;
	private String nombre;
	private String descripcion;
	private boolean activo;
	@OneToMany(mappedBy = "departamento") 
	private ArrayList<Presupuesto> presupuesto;
	@Version private int version;
	
	public Departamento() {}
	
	public Departamento (int id, String nombre, String descripcion, boolean activo)
	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public Departamento (String nombre, String descripcion, boolean activo)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion()
	{
		return descripcion;
	}

	public boolean getActivo()
	{
		return activo;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	public void setActivo(boolean activo) 
	{
		this.activo = activo;
	}
}