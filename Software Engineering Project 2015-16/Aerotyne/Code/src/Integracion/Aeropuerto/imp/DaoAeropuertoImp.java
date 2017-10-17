package Integracion.Aeropuerto.imp;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import Integracion.Aeropuerto.DaoAeropuerto;
import Negocio.Aeropuerto.imp.TransferAeropuerto;
import Negocio.Aeropuerto.imp.TransferAeropuertoNoSeguro;
import Negocio.Aeropuerto.imp.TransferAeropuertoSeguro;

public class DaoAeropuertoImp implements DaoAeropuerto {

	public boolean add(TransferAeropuerto t) {
		if(t.getId() == -1)
		{
			int cont = 1;
			while(searchId(cont) != null)
			{
				cont++;
			}
			t.setId(cont);
		}
		String nombArch = "aeropuerto" + t.getId() + ".txt";
		String infoToWrite = "";
		if(t instanceof TransferAeropuertoSeguro)
		{
			infoToWrite += "SEGURO" + " " + ((TransferAeropuertoSeguro) t).getGradoSeguridad() + " ";
		}
		else
		{
			infoToWrite += "NO_SEGURO" + " " + ((TransferAeropuertoNoSeguro) t).getDescripcion() + " _END_ ";
		}
		infoToWrite += t.getId() + " " + t.getNombre() + " _END_ " + t.getCiudad() + " _END_ " + t.getPais() + " _END_ ";
		if(t.getActivo()) {
			infoToWrite += "ACTIVO";
		} else {
			infoToWrite += "NO_ACTIVO";
		}
		try {
			File archivo = new File(nombArch);
			FileWriter escribir = new FileWriter(archivo, true);
			escribir.write(infoToWrite);
			escribir.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public TransferAeropuerto search(String nombre) {
		String nombArch;
		String auxEnd;
		String textAdder;
		int cont = 1;
		TransferAeropuerto t;
		String seguroAux;
		try {
			do {
				nombArch = "aeropuerto" + cont + ".txt";
				cont++;
				File archivo = new File(nombArch);
				Scanner sc = new Scanner(archivo);
				seguroAux = sc.next();
				if(seguroAux.equals("SEGURO"))
				{
					t = new TransferAeropuertoSeguro();
					((TransferAeropuertoSeguro) t).setGradoSeguridad(sc.nextInt());
				}
				else
				{
					t = new TransferAeropuertoNoSeguro();
					textAdder = "";
					auxEnd = sc.next();
					while(!auxEnd.equals("_END_"));
					{
						textAdder += auxEnd;
						auxEnd = sc.next();
						if(!auxEnd.equals("_END_"))
							textAdder += " ";
					}
					((TransferAeropuertoNoSeguro) t).setDescripcion(textAdder);
				}
				t.setId(sc.nextInt());
				textAdder = "";
				auxEnd = sc.next();
				while(!auxEnd.equals("_END_"))
				{
					textAdder += auxEnd;
					auxEnd = sc.next();
					if(!auxEnd.equals("_END_"))
						textAdder += " ";
				}
				t.setNombre(textAdder);
				textAdder = "";
				auxEnd = sc.next();
				while(!auxEnd.equals("_END_"))
				{
					textAdder += auxEnd;
					auxEnd = sc.next();
					if(!auxEnd.equals("_END_"))
						textAdder += " ";
				}
				t.setCiudad(textAdder);
				textAdder = "";
				auxEnd = sc.next();
				while(!auxEnd.equals("_END_"))
				{
					textAdder += auxEnd;
					auxEnd = sc.next();
					if(!auxEnd.equals("_END_"))
						textAdder += " ";
				}
				t.setPais(textAdder);
				t.setActivo(sc.next().equals("ACTIVO"));
				sc.close();
			} while (!t.getNombre().equals(nombre));
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public TransferAeropuerto searchId(int id) {
		String nombArch = "aeropuerto" + id + ".txt";
		String seguroAux;
		String auxEnd;
		String textAdder;
		TransferAeropuerto t;
		try {
			File archivo = new File(nombArch);
			Scanner sc = new Scanner(archivo);
			seguroAux = sc.next();
			if(seguroAux.equals("SEGURO"))
			{
				t = new TransferAeropuertoSeguro();
				((TransferAeropuertoSeguro) t).setGradoSeguridad(sc.nextInt());
			}
			else
			{
				t = new TransferAeropuertoNoSeguro();
				textAdder = "";
				auxEnd = sc.next();
				while(!auxEnd.equals("_END_"))
				{
					textAdder += auxEnd;
					auxEnd = sc.next();
					if(!auxEnd.equals("_END_"))
						textAdder += " ";
				}
				((TransferAeropuertoNoSeguro) t).setDescripcion(textAdder);
			}
			t.setId(sc.nextInt());
			textAdder = "";
			auxEnd = sc.next();
			while(!auxEnd.equals("_END_"))
			{
				textAdder += auxEnd;
				auxEnd = sc.next();
				if(!auxEnd.equals("_END_"))
					textAdder += " ";
			}
			t.setNombre(textAdder);
			textAdder = "";
			auxEnd = sc.next();
			while(!auxEnd.equals("_END_"))
			{
				textAdder += auxEnd;
				auxEnd = sc.next();
				if(!auxEnd.equals("_END_"))
					textAdder += " ";
			}
			t.setCiudad(textAdder);
			textAdder = "";
			auxEnd = sc.next();
			while(!auxEnd.equals("_END_"))
			{
				textAdder += auxEnd;
				auxEnd = sc.next();
				if(!auxEnd.equals("_END_"))
					textAdder += " ";
			}
			t.setPais(textAdder);
			t.setActivo(sc.next().equals("ACTIVO"));
			sc.close();
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(TransferAeropuerto t) {
		String nombArch = "aeropuerto" + t.getId() + ".txt";
		try {
			File archivo = new File(nombArch);
			archivo.delete();
			return add(t);
		} catch (Exception e) {
			return false;
		}
	}
}