package presentacion.vistas.vistaBicicleta.bicicleta;

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

public class JFrameCantidadBicicletas extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField idCliente;
	private JTextField idBicicleta;
	private JButton enviar;
	private JButton salir;

	public JFrameCantidadBicicletas()
	{
		this.setTitle("Cantidad de Bicicletas");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));

		idCliente = new JTextField("Id cliente");
		idBicicleta = new JTextField("Id bicicleta");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		idCliente.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerCantidadBicicletasCompra());

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});

		buttonPanel.add(idCliente);
		buttonPanel.add(idBicicleta);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerCantidadBicicletasCompra implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOCANTIDADBICICLETASQUERY, new PareadoQuery(Integer.parseInt(idCliente.getText()), Integer.parseInt(idBicicleta.getText())));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato incorrecto","Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		idCliente.setText("Id cliente");
		idBicicleta.setText("Id bicicleta");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERABICICLETA, null);
	}
}