package presentacion.vistas.vistaDepartamento;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.departamento.imp.TransferDepartamento;
import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaDepartamento.departamento.JFrameAltaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameBajaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameBotoneraDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameCalcularNominaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameDetalleDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameListaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameModificarDepartamento;

public class VistaDepartamentoImp extends VistaDepartamento
{
	private JFrameAltaDepartamento altaDepartamento;
	private JFrameBajaDepartamento bajaDepartamento;
	private JFrameBotoneraDepartamento botoneraDepartamento;
	private JFrameDetalleDepartamento detalleDepartamento;
	private JFrameListaDepartamento listaDepartamento;
	private JFrameModificarDepartamento modificarDepartamento;
	private JFrameCalcularNominaDepartamento calcularNominaDepartamento;
	
	public VistaDepartamentoImp() 
	{
		createJFrameAltaDepartamento();
		createJFrameBajaDepartamento();
		createJFrameBotoneraDepartamento();
		createJFrameDetalleDepartamento();
		createJFrameListaDepartamento();
		createJFrameModificarDepartamento();
		createJFrameCalcularNominaDepartamento();
	}	
	
	public void createJFrameAltaDepartamento() 
	{
		if(altaDepartamento == null)
			altaDepartamento = new JFrameAltaDepartamento();
	}

	public void createJFrameBajaDepartamento()
	{
		if(bajaDepartamento == null)
			bajaDepartamento = new JFrameBajaDepartamento();
	}

	public void createJFrameBotoneraDepartamento() 
	{
		if(botoneraDepartamento == null)
			botoneraDepartamento = new JFrameBotoneraDepartamento();
	}

	public void createJFrameDetalleDepartamento() 
	{
		if(detalleDepartamento == null)
			detalleDepartamento = new JFrameDetalleDepartamento();
	}

	public void createJFrameListaDepartamento() 
	{
		if(listaDepartamento == null)
			listaDepartamento = new JFrameListaDepartamento();
	}

	public void createJFrameModificarDepartamento() 
	{
		if(modificarDepartamento == null)
			modificarDepartamento = new JFrameModificarDepartamento();
	}
	
	public void createJFrameCalcularNominaDepartamento() 
	{
		if(calcularNominaDepartamento == null)
			calcularNominaDepartamento = new JFrameCalcularNominaDepartamento();
	}

	@Override
	public void update(Contexto contexto) 
	{
		switch(contexto.getEvent())
		{
			case ListaComandos.VENTANAALTADEPARTAMENTO:
				altaDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANABAJADEPARTAMENTO:
				bajaDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANABOTONERADEPARTAMENTO:
				botoneraDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANADETALLEDEPARTAMENTO:
				detalleDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANALISTADEPARTAMENTO:
				listaDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANAMODIFICARDEPARTAMENTO:
				modificarDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANACALCULARNOMINADEPARTAMENTO:
				calcularNominaDepartamento.setVisible(true);
				break;	
			case ListaComandos.MOSTRARALTADEPARTAMENTO:
				String mostrarAltaDepartamento = "";
				
				switch((int)contexto.getDatos())
				{
					case -10:
						mostrarAltaDepartamento = "Error transaccion";
						break;
					case -2:
						mostrarAltaDepartamento = "Departamento desactivado, lo hemos activado de nuevo";
						break;
					case -1:
						mostrarAltaDepartamento = "Existe un departamento con el mismo nombre y esta activo";
						break;
					default:
						mostrarAltaDepartamento = "Se ha insertado con exito el departamento con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarAltaDepartamento, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARBAJADEPARTAMENTO:
				String mostrarBajaDepartamento = "";
				
				switch((int)contexto.getDatos())
				{
					case -10:
						mostrarBajaDepartamento = "Error transaccion";
						break;
					case -4:
						mostrarBajaDepartamento = "No puede darse de baja el departamento ya que tiene una asignacion activa";
						break;
					case -3:
						mostrarBajaDepartamento = "No puede darse de baja el departamento ya que tiene empleados activos";
						break;		
					case -2:
						mostrarBajaDepartamento = "El departamento esta desactivado";
						break;
					case -1:
						mostrarBajaDepartamento = "El departamento no existe";
						break;
					default:
						mostrarBajaDepartamento = "Departamento dado de baja con exito con id: " + (int)contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarBajaDepartamento, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARMODIFICARDEPARTAMENTO:
				String mostrarModificarDepartamento = "";
				
				switch((int)contexto.getDatos())
				{
					case -10:
						mostrarModificarDepartamento = "Error transaccion";
						break;
					case -3:
						mostrarModificarDepartamento = "Ya existe un departamento con ese nombre";
						break;
					case -2:
						mostrarModificarDepartamento = "El departamento esta dado de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarDepartamento = "El departamento no existe";
						break;
					default:
						mostrarModificarDepartamento = "Departamento modificado con exito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarModificarDepartamento, "Informacion", JOptionPane.INFORMATION_MESSAGE);	
				break;	
			case ListaComandos.MOSTRARCALCULARNOMINADEPARTAMENTO:
				String mostrarCalcularNomina = "";
				double salario = (double)contexto.getDatos();
				
				if(salario == -2)
				{
					mostrarCalcularNomina = "Departamento no esta activo";
				}
				else if(salario == -1)
				{
					mostrarCalcularNomina = "Departamento no existe";
				}
				else
				{
					mostrarCalcularNomina = "La suma de los salarios de todos los empleados es: " + salario + "€";
				}
				
				JOptionPane.showMessageDialog(null, mostrarCalcularNomina, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRARDETALLEDEPARTAMENTO:
				String mostrarDetalleDepartamento = "";
				
				if (contexto.getDatos() == null)
					mostrarDetalleDepartamento = "No existe el departamento buscado";
				else
					mostrarDetalleDepartamento = contexto.getDatos().toString();				
				
				detalleDepartamento.setAreaDetalle(mostrarDetalleDepartamento);
				break;
			case ListaComandos.MOSTRARLISTADEPARTAMENTO:
				String mostrarListaDepartamento = "";

				@SuppressWarnings("unchecked")
				ArrayList<TransferDepartamento> lista = (ArrayList<TransferDepartamento>) contexto.getDatos();
				
				if (lista.size() > 0)
				{
					for (int k = 0; k < lista.size(); ++k)
						mostrarListaDepartamento += lista.get(k).toString() + "\n";
				}
				else
					mostrarListaDepartamento = "No hay ningun departamento";				
				
				listaDepartamento.setAreaDetalle(mostrarListaDepartamento);
				break;
		}
	}
}