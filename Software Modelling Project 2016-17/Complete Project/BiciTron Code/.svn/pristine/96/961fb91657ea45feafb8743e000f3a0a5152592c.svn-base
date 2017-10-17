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
import negocio.bicicleta.imp.TransferBicicletaCarretera;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameModificarBicicletaCarretera extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField material;
	private JTextField marca;
	private JTextField precio;
	private JTextField velocidadMaxima;
	private JButton enviar;
	private JButton salir;

	public JFrameModificarBicicletaCarretera() 
	{
		this.setTitle("Modificar bicicleta carretera");
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

		id = new JTextField("Id bicicleta");
		material = new JTextField("Material bicicleta");
		marca = new JTextField("Marca bicicleta");
		precio = new JTextField("precio bicicleta");
		velocidadMaxima = new JTextField("Velocidad maxima bicicleta");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		id.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerModificarBicicletaCarretera());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cerrar();
			}
		});

		buttonPanel.add(id);
		buttonPanel.add(material);
		buttonPanel.add(marca);
		buttonPanel.add(precio);
		buttonPanel.add(velocidadMaxima);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerModificarBicicletaCarretera implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIOMODIFICARBICICLETA, new TransferBicicletaCarretera(Integer.parseInt(id.getText()), material.getText(), marca.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(velocidadMaxima.getText()), true));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato bicicleta no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		id.setText("Id bicicleta");
		material.setText("Material bicicleta");
		marca.setText("Marca bicicleta");
		precio.setText("Precio bicicleta");
		velocidadMaxima.setText("Velocidad maxima bicicleta");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERABICICLETA, null);
	}
}