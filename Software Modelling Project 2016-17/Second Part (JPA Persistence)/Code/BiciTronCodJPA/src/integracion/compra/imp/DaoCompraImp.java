package integracion.compra.imp;

import integracion.compra.DaoCompra;
import integracion.transactionManager.TransactionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import negocio.compra.imp.TransferCompra;
import negocio.compra.imp.TransferLineaCompra;

public class DaoCompraImp implements DaoCompra 
{
	public int add(TransferCompra tCompra) 
	{
		int rs = 0;
		Connection cn = null;
		Statement st = null;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeUpdate("INSERT INTO compra(idCliente, costeTotal, fecha, activo) VALUES (" + tCompra.getIdCliente() + ", " + tCompra.getCosteTotal() + ", '"	+ tCompra.getFecha() + "', "	+ tCompra.getActivo() + ")");

			if (rs != 0) 
			{
				ResultSet rsUltima = st.executeQuery("SELECT LAST_INSERT_ID()");
				rsUltima.next();
				rs = rsUltima.getInt(1);

				Iterator<Entry<Integer, Integer>> it = tCompra.getLineaCompra().entrySet().iterator();

				while (it.hasNext())
				{
					Map.Entry<Integer, Integer> t = (Map.Entry<Integer, Integer>) it.next();
					ResultSet rsPrecio = st.executeQuery("SELECT precio FROM bicicleta WHERE id = '" + t.getKey() + "' FOR UPDATE");
					rsPrecio.next();
					st.executeUpdate("INSERT INTO lineaDeCompra(idCompra, idArticulo, cantidad, precioUnitario, activo) VALUES (" + rs + ", " + t.getKey() + ", " + t.getValue() + ", " + rsPrecio.getDouble(1) + ", 1)");
				}
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

	public TransferCompra searchId(int id)
	{
		TransferCompra t = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM compra WHERE id = " + id + " FOR UPDATE");

			if (rs.next())
			{
				t = new TransferCompra(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getBoolean(5));
				rs = st.executeQuery("SELECT idArticulo, cantidad FROM lineaDeCompra WHERE idCompra = "	+ id + " FOR UPDATE");

				while (rs.next())
					t.setLineaCompra(rs.getInt(1), rs.getInt(2));
			}
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

	public ArrayList<TransferCompra> list() 
	{
		ArrayList<TransferCompra> tList = new ArrayList<TransferCompra>();
		TransferCompra t = null;
		Connection cn = null;
		Statement stCompra = null;
		Statement stLinea = null;
		ResultSet rsCompra = null;
		ResultSet rsLinea = null;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			stCompra = cn.createStatement();
			stLinea = cn.createStatement();
			rsCompra = stCompra.executeQuery("SELECT * FROM compra FOR UPDATE");

			while (rsCompra.next()) 
			{
				t = new TransferCompra(rsCompra.getInt(1), rsCompra.getInt(2), rsCompra.getDouble(3), rsCompra.getDate(4),	rsCompra.getBoolean(5));

				rsLinea = stLinea.executeQuery("SELECT idArticulo, cantidad FROM lineaDeCompra WHERE idCompra = " + t.getId() + " FOR UPDATE");

				while (rsLinea.next()) 
				{
					t.setLineaCompra(rsLinea.getInt(1), rsLinea.getInt(2));
					tList.add(t);
				}
			}
		} 
		catch (SQLException e) {}
		finally 
		{
			try 
			{
				rsCompra.close();
				if (rsLinea != null)
					rsLinea.close();
				stCompra.close();
				stLinea.close();
			} 
			catch (SQLException e) {}
		}

		return tList;
	}

	@Override
	public TransferLineaCompra searchLineaCompra(TransferLineaCompra tLineaCompra) 
	{
		TransferLineaCompra lineaCompra = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();

			rs = st.executeQuery("SELECT cantidad, activo FROM lineaDeCompra WHERE idCompra = " + tLineaCompra.getIdCompra() + " && idArticulo = " + tLineaCompra.getIdArticulo() + " FOR UPDATE");

			if (rs.next())
				lineaCompra = new TransferLineaCompra(tLineaCompra.getIdCompra(), tLineaCompra.getIdArticulo(), rs.getInt(1), rs.getBoolean(2));
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

		return lineaCompra;
	}

	public int devolucionArticulo(TransferCompra tCompra, TransferLineaCompra tLineaCompra) 
	{
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int rsDevolucion = 0;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();

			rsDevolucion = st.executeUpdate("UPDATE lineaDeCompra SET cantidad = '"	+ tLineaCompra.getCantidadNueva() + "', activo = " + tLineaCompra.getActivo() + " WHERE idCompra = '" + tLineaCompra.getIdCompra() + "' && idArticulo = '"	+ tLineaCompra.getIdArticulo() + "'");

			if (rsDevolucion != 0) 
			{
				rs = st.executeQuery("SELECT count(*) FROM lineaDeCompra WHERE idCompra = "	+ tLineaCompra.getIdCompra() + " && activo = 1 FOR UPDATE");

				if (rs.next())
					if (rs.getInt(1) == 0)
						tCompra.setActivo(false);

				ResultSet rsPrecio = st.executeQuery("SELECT precioUnitario FROM lineaDeCompra WHERE idCompra = '" + tLineaCompra.getIdCompra()	+ "' && idArticulo = '" + tLineaCompra.getIdArticulo() + "' FOR UPDATE");
				rsPrecio.next();

				rsDevolucion = st.executeUpdate("UPDATE compra SET costeTotal = costeTotal-" + (rsPrecio.getDouble(1) * tLineaCompra.getCantidad())	+ ", activo = " + tCompra.getActivo() + " WHERE id = '" + tCompra.getId() + "'");
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

		return rsDevolucion;
	}
}