package integracion.bicicleta.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import integracion.bicicleta.DaoBicicleta;
import integracion.transactionManager.TransactionManager;
import negocio.bicicleta.imp.TransferBicicleta;
import negocio.bicicleta.imp.TransferBicicletaCarretera;
import negocio.bicicleta.imp.TransferBicicletaMontana;

public class DaoBicicletaImp implements DaoBicicleta 
{
	public int add(TransferBicicleta t) 
	{
		Statement st = null;
		int rs = 0;

		try 
		{
			st = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			rs = st.executeUpdate("INSERT INTO bicicleta(material, marca, precio, activo) VALUES ('" + t.getMaterial() + "', '" + t.getMarca() + "', " + t.getPrecio() + ", " + t.getActivo() + ")");

			if (t instanceof TransferBicicletaCarretera)
				rs = st.executeUpdate("INSERT INTO bicicletaCarretera(id, velocidadMaxima) VALUES(LAST_INSERT_ID(), " + ((TransferBicicletaCarretera) t).getVelocidadMaxima()	+ ")");
			else if (t instanceof TransferBicicletaMontana)
				rs = st.executeUpdate("INSERT INTO bicicletaMontana(id, amortiguacion) VALUES(LAST_INSERT_ID(), '" + ((TransferBicicletaMontana) t).getAmortiguacion()	+ "')");

			if (rs > 0) 
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
			} catch (SQLException e) {}
		}

		return rs;
	}

	public int update(TransferBicicleta t)
	{
		Statement st = null;
		int rs = 0;

		try 
		{
			st = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			rs = st.executeUpdate("UPDATE bicicleta SET material = '" + t.getMaterial() + "', marca = '" + t.getMarca() + "', precio = '" + t.getPrecio() + "', activo = '" + (t.getActivo() ? 1 : 0) + "'  WHERE id = '" + t.getId() + "'");

			if (rs != 0)
			{
				if (t instanceof TransferBicicletaCarretera)
					rs = st.executeUpdate("UPDATE bicicletaCarretera SET velocidadMaxima = " + ((TransferBicicletaCarretera) t).getVelocidadMaxima()	+ " WHERE id = " + t.getId());
				else if (t instanceof TransferBicicletaMontana)
					rs = st.executeUpdate("UPDATE bicicletaMontana SET amortiguacion = '" + ((TransferBicicletaMontana) t).getAmortiguacion()	+ "' WHERE id = " + t.getId());

				rs = t.getId();
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

	public TransferBicicleta search(TransferBicicleta t)
	{
		Statement st = null;
		ResultSet rs = null;
		TransferBicicleta enviar = null;

		try 
		{
			st = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			rs = st.executeQuery("SELECT * FROM bicicleta WHERE marca like '" + t.getMarca() + "' FOR UPDATE");

			if (rs.next())
				enviar = new TransferBicicleta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getBoolean(5));
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

	public TransferBicicleta searchId(int id) 
	{
		Statement st = null;
		ResultSet rs = null;
		TransferBicicleta t = null;

		try 
		{
			st = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			rs = st.executeQuery("SELECT * FROM bicicleta INNER JOIN bicicletaCarretera USING(id) WHERE id = '" + id + "' FOR UPDATE");

			if (rs.next())
				t = new TransferBicicletaCarretera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(6), rs.getBoolean(5));
			else 
			{
				rs = st.executeQuery("SELECT * FROM bicicleta INNER JOIN bicicletaMontana USING(id) WHERE id = '" + id + "' FOR UPDATE");

				if (rs.next())
					t = new TransferBicicletaMontana(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(6), rs.getBoolean(5));
			}
		} 
		catch (SQLException e) {} 
		finally 
		{
			try 
			{
				rs.close();
				st.close();
			} catch (SQLException e) {}
		}

		return t;
	}

	public ArrayList<TransferBicicleta> list()
	{
		Statement st = null;
		ResultSet rs = null;
		ArrayList<TransferBicicleta> tList = new ArrayList<TransferBicicleta>();

		try 
		{
			st = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			rs = st.executeQuery("SELECT * FROM bicicleta INNER JOIN bicicletaCarretera USING(id) FOR UPDATE");

			while (rs.next())
				tList.add(new TransferBicicletaCarretera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(6), rs.getBoolean(5)));

			rs = st.executeQuery("SELECT * FROM bicicleta INNER JOIN bicicletaMontana USING(id) FOR UPDATE");

			while (rs.next())
				tList.add(new TransferBicicletaMontana(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(6), rs.getBoolean(5)));
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