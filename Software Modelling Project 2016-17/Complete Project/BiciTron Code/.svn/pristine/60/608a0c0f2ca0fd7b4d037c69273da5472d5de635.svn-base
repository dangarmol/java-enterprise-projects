package integracion.query.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import presentacion.controlador.PareadoQuery;
import integracion.query.Query;
import integracion.transactionManager.TransactionManager;

public class CantidadBicicletasQuery implements Query 
{
	@Override
	public Object execute(Object datos) 
	{
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int enviar = 0;

		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT SUM(cantidad) FROM lineaDeCompra WHERE idArticulo = '"	+ ((PareadoQuery) datos).getSegundoObjeto() + "' && idCompra IN (SELECT id FROM compra WHERE idCliente LIKE '" + ((PareadoQuery) datos).getPrimeroObjeto() + "') FOR UPDATE");

			if (rs.next())
				enviar = rs.getInt(1);
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
}
