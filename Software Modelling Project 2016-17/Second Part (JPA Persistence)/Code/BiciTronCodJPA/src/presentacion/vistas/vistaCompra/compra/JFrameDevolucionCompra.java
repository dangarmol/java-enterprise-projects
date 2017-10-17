package presentacion.vistas.vistaCompra.compra;

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
import negocio.compra.imp.TransferLineaCompra;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameDevolucionCompra extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField idCompra;
	private JTextField idArticulo;
	private JTextField cantidadArticulo;
	private JButton enviar;
	private JButton salir;

	public JFrameDevolucionCompra()
	{
		this.setTitle("Devolucion articulo");
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

		idCompra = new JTextField("Id compra");
		idArticulo = new JTextField("Id articulo");
		cantidadArticulo = new JTextField("Cantidad articulo");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		idCompra.setPreferredSize(new Dimension(320, 35));

		enviar.addActionListener(new ActionListenerDevolucionCompra());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cerrar();
			}
		});

		buttonPanel.add(idCompra);
		buttonPanel.add(idArticulo);
		buttonPanel.add(cantidadArticulo);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerDevolucionCompra implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIODEVOLUCIONCOMPRA, new TransferLineaCompra(Integer.parseInt(idCompra.getText()), Integer.parseInt(idArticulo.getText()), Integer.parseInt(cantidadArticulo.getText())));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato devolucion incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		idCompra.setText("Id compra");
		idArticulo.setText("Id articulo");
		cantidadArticulo.setText("Cantidad articulo");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERACOMPRA, null);
	}
}