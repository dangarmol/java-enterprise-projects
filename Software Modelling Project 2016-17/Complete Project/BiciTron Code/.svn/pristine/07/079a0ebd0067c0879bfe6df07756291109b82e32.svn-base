package integracion.cliente.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import integracion.cliente.DaoCliente;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.imp.TransferCliente;

public class DaoClienteImp implements DaoCliente 
{
	public int add(TransferCliente t) 
	{
		int rs = 0;
		Connection cn = null;
		Statement st = null;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeUpdate("INSERT INTO cliente(nombre, tarjetaDeCredito, activo) VALUES ('" + t.getNombre()	+ "', '" + t.getTarjetaDeCredito() + "', " + t.getActivo() + ")");

			if (rs != 0) 
			{
				ResultSet rsultima = st.executeQuery("SELECT LAST_INSERT_ID()");
				rsultima.next();
				rs = rsultima.getInt(1);
			}
		} 
		catch (SQLException e) {} 
		finally 
		{
			try 
			{
				st.close();
			} 
			catch (SQLException e) {}
		}

		return rs;
	}

	public int update(TransferCliente t) 
	{
		Connection cn = null;
		Statement st = null;
		int rs = 0;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeUpdate("UPDATE cliente SET nombre = '" + t.getNombre() + "', tarjetaDeCredito = '"	+ t.getTarjetaDeCredito() + "', activo = '"	+ (t.getActivo() ? 1 : 0) + "'  WHERE id = '" + t.getId() + "'");

			if (rs != 0)
				rs = t.getId();
		} 
		catch (SQLException e) {} 
		finally 
		{
			try
			{
				st.close();
			}
			catch (SQLException e) {}
		}

		return rs;
	}

	public TransferCliente search(TransferCliente t)
	{
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		TransferCliente enviar = null;
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente WHERE tarjetaDeCredito like '" + t.getTarjetaDeCredito() + "' FOR UPDATE");

			if (rs.next())
				enviar = new TransferCliente(rs.getInt(1), rs.getString(2),	rs.getString(3), rs.getBoolean(4));
		} 
		catch (SQLException e) {} 
		finally 
		{
			try 
			{
				rs.close();
				st.close();
			} 
			catch (SQLException e) {}
		}

		return enviar;
	}

	public TransferCliente searchId(int id) 
	{
		TransferCliente t = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente WHERE id = " + id + " FOR UPDATE");

			if (rs.next())
				t = new TransferCliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
		} 
		catch (SQLException e) {}
		finally 
		{
			try 
			{
				rs.close();
				st.close();
			}
			catch (SQLException e) {}
		}

		return t;
	}

	public ArrayList<TransferCliente> list() 
	{
		ArrayList<TransferCliente> tList = new ArrayList<TransferCliente>();
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente FOR UPDATE");

			while (rs.next())
				tList.add(new TransferCliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
		} 
		catch (SQLException e) {} 
		finally 
		{
			try 
			{
				rs.close();
				st.close();
			} 
			catch (SQLException e) {}
		}

		return tList;
	}
}