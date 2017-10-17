package integracion.transactionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionMySQL extends Transaction 
{
	private Connection connection;

	public TransactionMySQL() 
	{
		try
		{
			this.connection = DriverManager.getConnection("jdbc:mysql://91.121.136.118:3306/BiciTron", "clase",	"12345");
		} 
		catch (SQLException e) {}
	}

	@Override
	public void start()
	{
		try 
		{
			connection.setAutoCommit(false);
		} 
		catch (SQLException e) {}
	}

	@Override
	public void commit()
	{
		try 
		{
			connection.commit();
			connection.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public void rollback() 
	{
		try 
		{
			connection.rollback();
			connection.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public Object getResource() 
	{
		return connection;
	}
}