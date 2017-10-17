package negocio.departamento;

import java.util.ArrayList;

import negocio.departamento.imp.TransferDepartamento;

public interface ServicioAplicacionDepartamento 
{
	public int altaDepartamento(TransferDepartamento t);
	public int bajaDepartamento(int id);
	public int modificarDepartamento(TransferDepartamento t);
	public TransferDepartamento detalleDepartamento(int id);
	public ArrayList<TransferDepartamento> listaDepartamento();
	public double calcularNomina(int id);
}