package presentacion.vistas.vistaCliente.cliente;

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

public class JFrameBotoneraCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaCliente;
	private JButton bajaCliente;
	private JButton detalleCliente;
	private JButton listaCliente;
	private JButton modificarCliente;
	private JButton numeroClientes;
	private JButton salir;

	public JFrameBotoneraCliente() 
	{
		this.setTitle("Botonera Cliente");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));

		altaCliente = new JButton("Crear Cliente");
		bajaCliente = new JButton("Eliminar Cliente");
		detalleCliente = new JButton("Detalle cliente");
		listaCliente = new JButton("Lista cliente");
		modificarCliente = new JButton("Modificar cliente");
		numeroClientes = new JButton("Numero clientes");
		salir = new JButton("Salir");

		altaCliente.setPreferredSize(new Dimension(320, 35));

		altaCliente.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaCliente.addActionListener(new ActionListenerBotoneraCliente(1));
		detalleCliente.addActionListener(new ActionListenerBotoneraCliente(2));
		listaCliente.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarCliente.addActionListener(new ActionListenerBotoneraCliente(4));
		numeroClientes.addActionListener(new ActionListenerBotoneraCliente(5));

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaCliente);
		buttonPanel.add(bajaCliente);
		buttonPanel.add(detalleCliente);
		buttonPanel.add(listaCliente);
		buttonPanel.add(modificarCliente);
		buttonPanel.add(numeroClientes);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerBotoneraCliente implements ActionListener
	{
		private int event;

		public ActionListenerBotoneraCliente(int event) 
		{
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			int comando = 0;

			switch (event) 
			{
				case 0:
					comando = ListaComandos.VENTANAALTACLIENTE;
					break;
				case 1:
					comando = ListaComandos.VENTANABAJACLIENTE;
					break;
				case 2:
					comando = ListaComandos.VENTANADETALLECLIENTE;
					break;
				case 3:
					comando = ListaComandos.VENTANALISTACLIENTE;
					break;
				case 4:
					comando = ListaComandos.VENTANAMODIFICARCLIENTE;
					break;
				case 5:
					comando = ListaComandos.VENTANANUMEROCLIENTESQUERY;
			}

			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}

	public void cerrarParaVistaPropia()
	{
		this.setVisible(false);
	}

	public void cerrarBotonera() 
	{
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANAPRINCIPAL, null);
	}
}