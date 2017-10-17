package presentacion.vistas.vistaTienda.tienda;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.tienda.imp.TransferPresupuesto;

import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAsignarPresupuestoTienda extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField departamento;
	private JTextField tienda;
	private JTextField cantidad;
	private JButton enviar;
	private JButton salir;
	
	public JFrameAsignarPresupuestoTienda() 
	{
		this.setTitle("Asignar presupuesto tienda");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));

		departamento = new JTextField("Id departamento");
		tienda = new JTextField("Id tienda");
		cantidad = new JTextField("Cantidad");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		departamento.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerAltaCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				cerrar();
			}
		});

		buttonPanel.add(departamento);
		buttonPanel.add(tienda);
		buttonPanel.add(cantidad);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerAltaCliente implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOASIGNARPRESUPUESTOTIENDA, new TransferPresupuesto(Integer.parseInt(departamento.getText()), Integer.parseInt(tienda.getText()), Double.parseDouble(cantidad.getText()), true));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null,	"Formato no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		tienda.setText("Id tienda");
		departamento.setText("Id departamento");
		cantidad.setText("Cantidad");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERATIENDA, null);
	}	
}
