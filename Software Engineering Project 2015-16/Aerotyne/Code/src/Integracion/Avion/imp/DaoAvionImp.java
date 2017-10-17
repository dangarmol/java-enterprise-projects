package Integracion.Avion.imp;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import Integracion.Avion.DaoAvion;
import Negocio.Avion.imp.TransferAvion;


public class DaoAvionImp implements DaoAvion {

	public boolean add(TransferAvion t) {
		if(t.getId() == -1)
		{
			int cont = 1;
			while(searchId(cont) != null)
			{
				cont++;
			}
			t.setId(cont);
		}
		String nombArch = "avion" + t.getId() + ".txt";
		String infoToWrite = t.getId() + " " + t.getModelo() + " _END_ " + t.getNumPlazas() + " " + t.getMatricula() + " ";
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

	public TransferAvion search(String matricula) {
		String nombArch;
		String textAdder;
		String auxEnd;
		int cont = 1;
		TransferAvion t = new TransferAvion();
		try {
			do {
				nombArch = "avion" + cont + ".txt";
				cont++;
				File archivo = new File(nombArch);
				Scanner sc = new Scanner(archivo);
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
				t.setModelo(textAdder);
				t.setNumPlazas(sc.nextInt());
				t.setMatricula(sc.next());
				t.setActivo(sc.next().equals("ACTIVO"));
				sc.close();
			} while (!t.getMatricula().equals(matricula));
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public TransferAvion searchId(int id) {
		String nombArch = "avion" + id + ".txt";
		String textAdder;
		String auxEnd;
		TransferAvion t = new TransferAvion();
		try {
			File archivo = new File(nombArch);
			Scanner sc = new Scanner(archivo);
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
			t.setModelo(textAdder);
			t.setNumPlazas(sc.nextInt());
			t.setMatricula(sc.next());
			t.setActivo(sc.next().equals("ACTIVO"));
			sc.close();
			return t;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(TransferAvion t) {
		String nombArch = "avion" + t.getId() + ".txt";
		try {
			File archivo = new File(nombArch);
			archivo.delete();
			return add(t);
		} catch (Exception e) {
			return false;
		}
	}
}