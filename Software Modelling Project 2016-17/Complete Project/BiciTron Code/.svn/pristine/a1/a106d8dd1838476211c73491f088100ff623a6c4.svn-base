package presentacion.vistas.vistaTienda.tienda;

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

public class JFrameBotoneraTienda extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JButton altaTienda;
	private JButton bajaTienda;
	private JButton listaTienda;
	private JButton modificarTienda;
	private JButton detalleTienda;
	private JButton asignarDepartamentoTienda;
	private JButton desasignarDepartamentoTienda;
	private JButton asignarPresupuestoTienda;
	private JButton detallePresupuestoTienda;
	private JButton listaPresupuestoTienda;
	private JButton salir;
	
	public JFrameBotoneraTienda() 
	{
		this.setTitle("Botonera tienda");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(11, 1));

		altaTienda = new JButton("Alta tienda");
		bajaTienda = new JButton("Baja tienda");
		detalleTienda = new JButton("Detalle tienda");
		listaTienda = new JButton("Lista tienda");
		modificarTienda = new JButton("Modificar tienda");
		asignarDepartamentoTienda = new JButton("Asignar departamento a tienda");
		desasignarDepartamentoTienda = new JButton("Desasignar departamento a tienda");
		asignarPresupuestoTienda = new JButton("Asignar presupuesto a tienda");
		detallePresupuestoTienda = new JButton("Detalle presupuesto tienda");
		listaPresupuestoTienda = new JButton("Lista presupuesto tienda");
		salir = new JButton("Salir");

		altaTienda.setPreferredSize(new Dimension(320, 35));

		altaTienda.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaTienda.addActionListener(new ActionListenerBotoneraCliente(1));
		detalleTienda.addActionListener(new ActionListenerBotoneraCliente(2));
		listaTienda.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarTienda.addActionListener(new ActionListenerBotoneraCliente(4));
		asignarDepartamentoTienda.addActionListener(new ActionListenerBotoneraCliente(5));
		desasignarDepartamentoTienda.addActionListener(new ActionListenerBotoneraCliente(6));
		asignarPresupuestoTienda.addActionListener(new ActionListenerBotoneraCliente(7));
		detallePresupuestoTienda.addActionListener(new ActionListenerBotoneraCliente(8));
		listaPresupuestoTienda.addActionListener(new ActionListenerBotoneraCliente(9));
		
		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaTienda);
		buttonPanel.add(bajaTienda);
		buttonPanel.add(detalleTienda);
		buttonPanel.add(listaTienda);
		buttonPanel.add(modificarTienda);
		buttonPanel.add(asignarDepartamentoTienda);
		buttonPanel.add(desasignarDepartamentoTienda);
		buttonPanel.add(asignarPresupuestoTienda);
		buttonPanel.add(detallePresupuestoTienda);
		buttonPanel.add(listaPresupuestoTienda);
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
					comando = ListaComandos.VENTANAALTATIENDA;
					break;
				case 1:
					comando = ListaComandos.VENTANABAJATIENDA;
					break;
				case 2:
					comando = ListaComandos.VENTANADETALLETIENDA;
					break;
				case 3:
					comando = ListaComandos.VENTANALISTATIENDA;
					break;
				case 4:
					comando = ListaComandos.VENTANAMODIFICARTIENDA;
					break;
				case 5:
					comando = ListaComandos.VENTANAASIGNARDEPARTAMENTOTIENDA;
					break;
				case 6:
					comando = ListaComandos.VENTANADESASIGNARDEPARTAMENTOTIENDA;
					break;
				case 7:
					comando = ListaComandos.VENTANAASIGNARPRESUPUESTOTIENDA;
					break;
				case 8:
					comando = ListaComandos.VENTANADETALLEPRESUPUESTOTIENDA;
					break;
				case 9:
					comando = ListaComandos.VENTANALISTAPRESUPUESTOTIENDA;
					break;
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