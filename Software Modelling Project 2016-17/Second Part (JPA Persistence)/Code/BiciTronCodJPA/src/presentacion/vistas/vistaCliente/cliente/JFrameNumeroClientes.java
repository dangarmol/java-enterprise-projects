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
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;
import presentacion.controlador.PareadoQuery;

public class JFrameNumeroClientes extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField nFacturas;
	private JTextField nImporte;
	private JButton enviar;
	private JButton salir;

	public JFrameNumeroClientes()
	{
		this.setTitle("Numero de clientes");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

		nFacturas = new JTextField("Numero de facturas");
		nImporte = new JTextField("Importe minimo");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		nFacturas.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerNumeroClientesCompra());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cerrar();
			}
		});

		buttonPanel.add(nFacturas);
		buttonPanel.add(nImporte);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerNumeroClientesCompra implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIONUMEROCLIENTESQUERY, new PareadoQuery(Integer.parseInt(nFacturas.getText()),	Integer.parseInt(nImporte.getText())));
			}
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato articulo incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar()
	{
		nFacturas.setText("Numero de facturas");
		nImporte.setText("Importe minimo");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACLIENTE, null);
	}
}