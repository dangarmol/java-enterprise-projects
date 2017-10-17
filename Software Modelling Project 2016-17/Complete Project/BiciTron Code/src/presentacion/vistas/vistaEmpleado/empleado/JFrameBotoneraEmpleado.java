package presentacion.vistas.vistaEmpleado.empleado;

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

public class JFrameBotoneraEmpleado extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JButton altaEmpleado;
	private JButton bajaEmpleado;
	private JButton detalleEmpleado;
	private JButton listaEmpleado;
	private JButton modificarEmpleado;
	private JButton salir;
	
	public JFrameBotoneraEmpleado() 
	{
		this.setTitle("Botonera empleado");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));

		altaEmpleado = new JButton("Alta empleado");
		bajaEmpleado = new JButton("Baja empleado");
		detalleEmpleado = new JButton("Detalle empleado");
		listaEmpleado = new JButton("Lista empleado");
		modificarEmpleado = new JButton("Modificar empleado");
		salir = new JButton("Salir");

		altaEmpleado.setPreferredSize(new Dimension(320, 35));

		altaEmpleado.addActionListener(new ActionListenerBotoneraBicicleta(0));
		bajaEmpleado.addActionListener(new ActionListenerBotoneraBicicleta(1));
		detalleEmpleado.addActionListener(new ActionListenerBotoneraBicicleta(2));
		listaEmpleado.addActionListener(new ActionListenerBotoneraBicicleta(3));
		modificarEmpleado.addActionListener(new ActionListenerBotoneraBicicleta(4));

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaEmpleado);
		buttonPanel.add(bajaEmpleado);
		buttonPanel.add(detalleEmpleado);
		buttonPanel.add(listaEmpleado);
		buttonPanel.add(modificarEmpleado);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerBotoneraBicicleta implements ActionListener
	{
		private int event;

		public ActionListenerBotoneraBicicleta(int event)
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
					comando = ListaComandos.VENTANAALTAEMPLEADO;
					break;
				case 1:
					comando = ListaComandos.VENTANABAJAEMPLEADO;
					break;
				case 2:
					comando = ListaComandos.VENTANADETALLEEMPLEADO;
					break;
				case 3:
					comando = ListaComandos.VENTANALISTAEMPLEADO;
					break;
				case 4:
					comando = ListaComandos.VENTANAMODIFICAREMPLEADO;
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