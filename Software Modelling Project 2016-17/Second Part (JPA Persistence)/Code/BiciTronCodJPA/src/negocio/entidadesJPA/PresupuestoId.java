package negocio.entidadesJPA;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PresupuestoId implements Serializable
{
	private static final long serialVersionUID = 0;
	private int departamento;
	private int tienda;
	
	public PresupuestoId() {}
	
	public PresupuestoId(int departamento, int tienda)
	{
		this.departamento = departamento;
		this.tienda = tienda;
	}
	
	public int getDepartamento() 
	{
		return departamento;
	}

	public int getTienda()
	{
		return tienda;
	}
	
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof PresupuestoId))
			return false;
		PresupuestoId pk = (PresupuestoId) obj;
		if (!(departamento == pk.departamento))
			return false;
		if (!(tienda == pk.tienda))
			return false;
		return true;
	}

	public int hashCode() 
	{
		int hashcode = 0;
		hashcode += departamento;
		hashcode += tienda;
		return hashcode;
	}
}