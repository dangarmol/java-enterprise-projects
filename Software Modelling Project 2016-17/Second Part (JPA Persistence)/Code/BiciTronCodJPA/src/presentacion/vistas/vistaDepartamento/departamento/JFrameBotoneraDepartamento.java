package presentacion.vistas.vistaDepartamento.departamento;

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

public class JFrameBotoneraDepartamento extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JButton altaDepartamento;
	private JButton bajaDepartamento;
	private JButton detalleDepartamento;
	private JButton listaDepartamento;
	private JButton modificarDepartamento;
	private JButton calcularNominaDepartamento;
	private JButton salir;
	
	public JFrameBotoneraDepartamento() 
	{
		this.setTitle("Botonera departamento");
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

		altaDepartamento = new JButton("Alta departamento");
		bajaDepartamento = new JButton("Baja departamento");
		detalleDepartamento = new JButton("Detalle departamento");
		listaDepartamento = new JButton("Lista departamento");
		modificarDepartamento = new JButton("Modificar departamento");
		calcularNominaDepartamento = new JButton("Calcular nomina departamento");
		salir = new JButton("Salir");

		altaDepartamento.setPreferredSize(new Dimension(320, 35));

		altaDepartamento.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaDepartamento.addActionListener(new ActionListenerBotoneraCliente(1));
		detalleDepartamento.addActionListener(new ActionListenerBotoneraCliente(2));
		listaDepartamento.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarDepartamento.addActionListener(new ActionListenerBotoneraCliente(4));
		calcularNominaDepartamento.addActionListener(new ActionListenerBotoneraCliente(5));

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaDepartamento);
		buttonPanel.add(bajaDepartamento);
		buttonPanel.add(detalleDepartamento);
		buttonPanel.add(listaDepartamento);
		buttonPanel.add(modificarDepartamento);
		buttonPanel.add(calcularNominaDepartamento);
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
					comando = ListaComandos.VENTANAALTADEPARTAMENTO;
					break;
				case 1:
					comando = ListaComandos.VENTANABAJADEPARTAMENTO;
					break;
				case 2:
					comando = ListaComandos.VENTANADETALLEDEPARTAMENTO;
					break;
				case 3:
					comando = ListaComandos.VENTANALISTADEPARTAMENTO;
					break;
				case 4:
					comando = ListaComandos.VENTANAMODIFICARDEPARTAMENTO;
					break;
				case 5:
					comando = ListaComandos.VENTANACALCULARNOMINADEPARTAMENTO;
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