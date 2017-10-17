package presentacion.vistas.vistaCliente.cliente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import negocio.cliente.imp.TransferCliente;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameModificarCliente extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField nombre;
	private JTextField tarjetaDeCredito;
	private JButton enviar;
	private JButton salir;

	public JFrameModificarCliente() 
	{
		this.setTitle("Modificar cliente");
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

		id = new JTextField("Id cliente");
		nombre = new JTextField("Nombre cliente");
		tarjetaDeCredito = new JTextField("Tarjeta de credito cliente");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		id.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerModificarCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(nombre);
		buttonPanel.add(tarjetaDeCredito);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerModificarCliente implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOMODIFICARCLIENTE, new TransferCliente(Integer.parseInt(id.getText()), nombre.getText(), tarjetaDeCredito.getText(), true));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato cliente no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar()
	{
		id.setText("Id cliente");
		nombre.setText("Nombre cliente");
		tarjetaDeCredito.setText("tarjeta de credito cliente");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACLIENTE, null);
	}
}