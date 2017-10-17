package presentacion.vistas.vistaPrincipal.principal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFramePrincipal extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JButton bicicleta;
	private JButton cliente;
	private JButton compra;
	private JButton departamento;
	private JButton empleado;
	private JButton tienda;
	private JButton salir;

	public JFramePrincipal()
	{
		this.setTitle("BiciMod");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));

		bicicleta = new JButton("Modulo Bicicleta");
		cliente = new JButton("Modulo Cliente");
		compra = new JButton("Modulo Compra");
		departamento = new JButton("Modulo Departamento");
		empleado = new JButton("Modulo Empleado");
		tienda = new JButton("Modulo Tienda");
		salir = new JButton("Salir");

		bicicleta.setPreferredSize(new Dimension(300, 35));

		bicicleta.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
				Controlador.getInstance().accion(ListaComandos.VENTANABOTONERABICICLETA, null);
			}
		});

		cliente.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
				Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACLIENTE, null);
			}
		});

		compra.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
				Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACOMPRA, null);
			}
		});
		
		departamento.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
				Controlador.getInstance().accion(ListaComandos.VENTANABOTONERADEPARTAMENTO, null);
			}
		});

		empleado.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
				Controlador.getInstance().accion(ListaComandos.VENTANABOTONERAEMPLEADO, null);
			}
		});

		tienda.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
				Controlador.getInstance().accion(ListaComandos.VENTANABOTONERATIENDA, null);
			}
		});

		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrarAplicacion();
			}
		});

		this.getContentPane().add(bicicleta);
		this.getContentPane().add(cliente);
		this.getContentPane().add(compra);
		this.getContentPane().add(departamento);
		this.getContentPane().add(empleado);
		this.getContentPane().add(tienda);
		this.getContentPane().add(salir);

		buttonPanel.add(bicicleta);
		buttonPanel.add(cliente);
		buttonPanel.add(compra);
		buttonPanel.add(departamento);
		buttonPanel.add(empleado);
		buttonPanel.add(tienda);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public void cerrar() 
	{
		this.setVisible(false);
	}

	public void cerrarAplicacion() 
	{
		this.dispose();
		System.exit(0);
	}
}