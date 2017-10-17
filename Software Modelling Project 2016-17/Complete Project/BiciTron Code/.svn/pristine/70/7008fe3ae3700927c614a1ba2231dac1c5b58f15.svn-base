package presentacion.vistas.vistaEmpleado.empleado;

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
import javax.swing.JComboBox;
import javax.swing.JButton;

import negocio.empleado.imp.TransferDependiente;
import negocio.empleado.imp.TransferDirectivo;
import negocio.empleado.imp.TransferEmpleado;
import presentacion.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAltaEmpleado extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField dni;
	private JTextField telefono;
	private JTextField sueldo;
	private JTextField departamento;
	private JComboBox<String> tipo;
	private JTextField especifico1;
	private JTextField especifico2;
	private JButton enviar;
	private JButton salir;
	
	public JFrameAltaEmpleado() 
	{
		this.setTitle("Alta empleado");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) 
			{
				cerrar();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(10, 1));

		nombre = new JTextField("Nombre");
		dni = new JTextField("Dni");
		telefono = new JTextField("Telefono");
		sueldo = new JTextField("Sueldo");
		departamento = new JTextField("Departamento");
		String[] tiposEmpleado = {"Dependiente", "Directivo"};
		tipo = new JComboBox<String>(tiposEmpleado);
		tipo.setSelectedIndex(0);
		especifico1 = new JTextField("Horas trabajadas");
		especifico2 = new JTextField("Productividad");
		enviar = new JButton("Enviar");
		salir = new JButton("Salir");

		nombre.setPreferredSize(new Dimension(320, 35));

		tipo.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent event)
		    {
		        if (tipo.getSelectedIndex() == 0) 
		        {
		    		especifico1.setText("Horas trabajadas");
		    		especifico2.setText("Productividad");
		        } 
		        else
		        {
		    		especifico1.setText("Funcion");
		    		especifico2.setText("Sueldo base");
		        }
		    }
		});		
		
		enviar.addActionListener(new ActionListenerAltaBicicletaCarretera());

		salir.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cerrar();
			}
		});

		buttonPanel.add(nombre);
		buttonPanel.add(dni);
		buttonPanel.add(telefono);
		buttonPanel.add(sueldo);
		buttonPanel.add(departamento);
		buttonPanel.add(tipo);
		buttonPanel.add(especifico1);
		buttonPanel.add(especifico2);
		buttonPanel.add(enviar);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
	}

	public class ActionListenerAltaBicicletaCarretera implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				TransferEmpleado t = null;
		        if (tipo.getSelectedIndex() == 0) 
		        	t = new TransferDependiente(nombre.getText(), dni.getText(), Integer.parseInt(telefono.getText()), Double.parseDouble(sueldo.getText()), Integer.parseInt(departamento.getText()), true, Integer.parseInt(especifico1.getText()), Integer.parseInt(especifico2.getText()));
		        else
		        	t = new TransferDirectivo(nombre.getText(), dni.getText(), Integer.parseInt(telefono.getText()), Double.parseDouble(sueldo.getText()), Integer.parseInt(departamento.getText()), true, especifico1.getText(), Double.parseDouble(especifico2.getText()));			
		        
		        Controlador.getInstance().accion(ListaComandos.NEGOCIOALTAEMPLEADO, t);
			} 
			catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null,"Formato empleado no correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void cerrar() 
	{
		nombre.setText("Nombre");
		dni.setText("Dni");
		telefono.setText("Telefono");
		sueldo.setText("Sueldo");
		departamento.setText("Departamento");
		tipo.setSelectedIndex(0);
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANABOTONERAEMPLEADO, null);
	}
}