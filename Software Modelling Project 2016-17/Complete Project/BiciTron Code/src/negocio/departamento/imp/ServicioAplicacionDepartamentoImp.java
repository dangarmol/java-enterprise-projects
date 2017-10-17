package negocio.departamento.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.departamento.ServicioAplicacionDepartamento;
import negocio.entidadesJPA.Departamento;
import negocio.entidadesJPA.Empleado;
import negocio.entidadesJPA.Presupuesto;

public class ServicioAplicacionDepartamentoImp implements ServicioAplicacionDepartamento
{	
	public int altaDepartamento(TransferDepartamento t)
	{
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("BiciTronCod").createEntityManager();
		eM.getTransaction().begin();
		TypedQuery<Departamento> findByName = eM.createNamedQuery("negocio.entidadesJPA.Departamento.findBynombre", Departamento.class);
		findByName.setParameter("nombre", t.getNombre());
		findByName.setLockMode(LockModeType.OPTIMISTIC);
		
		if (findByName.getResultList().size() == 0)
		{
			Departamento aux = new Departamento(t.getNombre(), t.getDescripcion(), true);
			eM.persist(aux);
			try
			{
				eM.getTransaction().commit();
				result = aux.getId();
			}
			catch(Exception e)
			{
				eM.getTransaction().rollback();
				result = -10;
			}	
		}
		else
		{
			Departamento aux = findByName.getSingleResult();
			
			if(!aux.getActivo())
			{
				aux.setActivo(true);
				try
				{
					eM.getTransaction().commit();
					result = -2;
				}
				catch(Exception e)
				{
					eM.getTransaction().rollback();
					result = -10;
				}
				
			}
			else
				result = -1;
		}
		
		eM.close();
		
		return result;
	}

	public int bajaDepartamento(int id) 
	{
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("BiciTronCod").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) 
		{
			if (aux.getActivo())
			{				
				TypedQuery<Empleado> findByDepartamentoActivo = eM.createNamedQuery("negocio.entidadesJPA.Empleado.findBydepartamentoActivo", Empleado.class);
				findByDepartamentoActivo.setParameter("departamento", aux);
				findByDepartamentoActivo.setParameter("activo", true);
				findByDepartamentoActivo.setLockMode(LockModeType.OPTIMISTIC);
				
				if(findByDepartamentoActivo.getResultList().size() == 0)
				{
					TypedQuery<Presupuesto> findByDepartamentoAsignado = eM.createNamedQuery("negocio.entidadesJPA.Presupuesto.findBydepartamentoAsignado", Presupuesto.class);
					findByDepartamentoAsignado.setParameter("departamento", aux);
					findByDepartamentoAsignado.setParameter("activo", true);
					findByDepartamentoAsignado.setLockMode(LockModeType.OPTIMISTIC);
					
					if(findByDepartamentoAsignado.getResultList().size() == 0)
					{
						aux.setActivo(false);
						try
						{
							eM.getTransaction().commit();
							result = id;
						}
						catch(Exception e)
						{
							eM.getTransaction().rollback();
							result = -10;
						}
					}
					else
						result = -4;
				}
				else
					result = -3;
			}
			else 
				result = -2;
		}
		else 
			result = -1;
		
		eM.close();
		return result;
	}

	public TransferDepartamento detalleDepartamento(int id) 
	{
		TransferDepartamento result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("BiciTronCod").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) 
			result = new TransferDepartamento(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo());
		return result;
	}

	public ArrayList<TransferDepartamento> listaDepartamento() 
	{
		ArrayList<TransferDepartamento> lista = new ArrayList<TransferDepartamento> ();
		EntityManager eM = Persistence.createEntityManagerFactory("BiciTronCod").createEntityManager();
		eM.getTransaction().begin();
		
		List<Departamento> l = eM.createQuery("SELECT obj FROM Departamento obj", Departamento.class).getResultList();
		Departamento aux;
		
		for(int k = 0; k < l.size(); k++)
		{
			aux = l.get(k);
			lista.add(new TransferDepartamento(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo()));
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}
	
	public int modificarDepartamento(TransferDepartamento t) 
	{
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("BiciTronCod").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) 
		{
			if (aux.getActivo())
			{
				TypedQuery<Departamento> findByName = eM.createNamedQuery("negocio.entidadesJPA.Departamento.findBynombre", Departamento.class);
				findByName.setParameter("nombre", t.getNombre());
				findByName.setLockMode(LockModeType.OPTIMISTIC);
				
				if (findByName.getResultList().size() == 0 || (aux.getId() == findByName.getSingleResult().getId())) 
				{
					aux.setNombre(t.getNombre());
					aux.setDescripcion(t.getDescripcion());
					try
					{
						eM.getTransaction().commit();
						result = t.getId();
					}
					catch(Exception e)
					{
						eM.getTransaction().rollback();
						result = -1;
					}
				}
				else
					result = -3;
			}
			else 
				result = -2;
		}
		else 
			result = -1;
		
		eM.close();
		return result;
	}


	public double calcularNomina(int id) 
	{
		double result = 0;
		EntityManager eM = Persistence.createEntityManagerFactory("BiciTronCod").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null)
		{
			if(aux.getActivo())
			{
				TypedQuery<Empleado> findByDepartamento = eM.createNamedQuery("negocio.entidadesJPA.Empleado.findBydepartamentoActivo", Empleado.class);
				findByDepartamento.setParameter("departamento", aux);
				findByDepartamento.setParameter("activo", true);
				findByDepartamento.setLockMode(LockModeType.OPTIMISTIC);
				
				List<Empleado> l = findByDepartamento.getResultList();
				
				for(int k=0; k<l.size(); k++)
				{
					Empleado auxEmpleado = l.get(k);
					eM.lock(auxEmpleado, LockModeType.OPTIMISTIC);
					result += auxEmpleado.calcularSueldo();
				}
				eM.getTransaction().commit();
			}
			else
				result = -2;
		}
		else
			result = -1;
		
		eM.close();
		return result;
	}
}