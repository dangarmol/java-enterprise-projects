package presentacion.vistas.vistaCompra.compra;

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
import negocio.compra.imp.TransferCompra;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameEliminarArticulo extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField idProducto;
	private JTextField cantidadProducto;
	TransferCompra tCompra;
	private JButton enviar;
	private JButton salir;

	public JFrameEliminarArticulo()
	{
		this.setTitle("Eliminar articulo");
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

		idProducto = new JTextField("Id producto");
		cantidadProducto = new JTextField("Cantidad de producto");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		idProducto.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerEliminarArticuloCompra());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cerrar();
			}
		});

		buttonPanel.add(idProducto);
		buttonPanel.add(cantidadProducto);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerEliminarArticuloCompra implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try {
				if (tCompra.getExisteArticulo(Integer.parseInt(idProducto.getText()))) 
				{
					tCompra.setLineaCompra(Integer.parseInt(idProducto.getText()), Integer.parseInt(cantidadProducto.getText()) * -1);
					Controlador.getInstance().accion(ListaComandos.NEGOCIOELIMINARARTICULOCOMPRA, tCompra);
					cerrar();
				} 
				else
					JOptionPane.showMessageDialog(null, "Ese producto no esta en el carrito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato articulo incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void setTransferCompra(TransferCompra tCompra) 
	{
		this.tCompra = tCompra;
	}

	public void cerrar() 
	{
		idProducto.setText("Id producto");
		cantidadProducto.setText("Cantidad de producto");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANAGESTIONCARRITOCOMPRA, null);
	}
}