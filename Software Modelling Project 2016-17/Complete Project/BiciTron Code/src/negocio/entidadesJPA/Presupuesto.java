package negocio.entidadesJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

@Entity
@IdClass(PresupuestoId.class)
@NamedQueries({
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findBydepartamento", query = "select obj from Presupuesto obj where obj.departamento = :departamento"),
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findBytienda", query = "select obj from Presupuesto obj where obj.tienda = :tienda"),
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findBycantidad", query = "select obj from Presupuesto obj where obj.cantidad = :cantidad"),
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findBydepartamentotienda", query="select obj from Presupuesto obj where obj.departamento = :departamento AND obj.tienda = :tienda"),
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findBydepartamentoAsignado", query="select obj from Presupuesto obj where obj.departamento = :departamento AND obj.activo = :activo"),
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findBytiendaAsignado", query="select obj from Presupuesto obj where obj.tienda = :tienda AND obj.activo = :activo"),
		@NamedQuery(name = "negocio.entidadesJPA.Presupuesto.findByversion", query = "select obj from Presupuesto obj where obj.version = :version") })
public class Presupuesto implements Serializable 
{
	private static final long serialVersionUID = 0;
	@Id @ManyToOne private Departamento departamento;
	@Id @ManyToOne private Tienda tienda;
	private double cantidad;
	private boolean activo;
	@Version private int version;
	
	public Presupuesto() {}
	
	public Presupuesto(Departamento departamento, Tienda tienda, double cantidad, boolean activo)
	{
		this.departamento = departamento;
		this.tienda = tienda;
		this.cantidad = cantidad;
		this.activo = activo;
	}
	
	public Departamento getDepartamento()
	{
		return departamento;
	}
	
	public Tienda getTienda()
	{
		return tienda;
	}
	
	public double getCantidad() 
	{
		return cantidad;
	}
	
	public boolean getActivo()
	{
		return activo;
	}
	
	public void setDepartamento(Departamento departamento)
	{
		this.departamento = departamento;
	}
	
	public void setTienda(Tienda tienda)
	{
		this.tienda = tienda;
	}
	
	public void setCantidad(double cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}
}