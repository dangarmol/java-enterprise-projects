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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import negocio.tienda.imp.TransferPresupuesto;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameDetallePresupuestoTienda extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField departamento;
	private JTextField tienda;
	private JTextArea mostrar;
	private JButton enviar;
	private JButton salir;
	
	public JFrameDetallePresupuestoTienda() 
	{
		this.setTitle("Detalle presupuesto");
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

		departamento = new JTextField("Departamento");
		tienda = new JTextField("Tienda");
		mostrar = new JTextArea("Detalle");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		mostrar.setWrapStyleWord(true);
		mostrar.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(mostrar);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		departamento.setPreferredSize(new Dimension(800, 35));

		enviar.addActionListener(new ActionListenerDetalleCliente());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				cerrar();
			}
		});

		buttonPanel.add(scrollPane);
		buttonPanel.add(departamento);
		buttonPanel.add(tienda);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerDetalleCliente implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				Controlador.getInstance().accion(ListaComandos.NEGOCIODETALLEPRESUPUESTOTIENDA, new TransferPresupuesto(Integer.parseInt(departamento.getText()) , Integer.parseInt(tienda.getText())));
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Formato no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void setAreaDetalle(String msg)
	{
		mostrar.setText(msg);
	}

	public void cerrar() 
	{
		departamento.setText("Departamento");
		tienda.setText("Tienda");
		mostrar.setText("Detalle");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERATIENDA, null);
	}
}