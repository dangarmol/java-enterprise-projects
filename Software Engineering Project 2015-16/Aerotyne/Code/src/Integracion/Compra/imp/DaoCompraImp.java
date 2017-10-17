package Integracion.Compra.imp;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import Integracion.Compra.DaoCompra;
import Negocio.Compra.imp.TransferBilletes;
import Negocio.Compra.imp.TransferCompra;

public class DaoCompraImp implements DaoCompra {
	public boolean add(TransferCompra t) {
		if(t.getId() == -1)
		{
			t.setId(asignarIdCompra());
		}
		String nombArchCompra = "compra" + t.getId() + ".txt";
		String nombArchBillete = "";
		int idCreatorLoopCounter;
		String infoToWriteBillete;
		String infoToWriteCompra = t.getId() + " " + t.getDni() + " " + t.getNombre() + " _END_ " + t.getTarjetaDeCredito() + " ";
		infoToWriteCompra += " _COUNT_ " + t.getBilletes().size() + " _STARTTICKETIDS_ ";
		
		for (TransferBilletes p: t.getBilletes()) {
			if(p.getId() == -1)
			{
				idCreatorLoopCounter = 1;
				while(searchId(idCreatorLoopCounter) != null)
				{
					idCreatorLoopCounter++;
				}
				p.setId(idCreatorLoopCounter);
			}
			infoToWriteCompra += p.getId() + " ";
			nombArchBillete = "billete" + p.getId() + ".txt";
			infoToWriteBillete = "";
			infoToWriteBillete += p.getId() + " " + p.getDni() + " " + p.getInstanciaDeVuelo() + " " + p.getPrecio() + " ";
			infoToWriteBillete += p.getNombre() + " _END_ ";
			if(p.getActivo()) {
				infoToWriteBillete += "ACTIVO";
			} else {
				infoToWriteBillete += "NO_ACTIVO";
			}
			try {
				File archivo = new File(nombArchBillete);
				FileWriter escribir = new FileWriter(archivo, true);
				escribir.write(infoToWriteBillete);
				escribir.close();
			} catch (Exception e) {
				return false;
			}
		}
		
		if(t.getActivo()) {
			infoToWriteCompra += "ACTIVO";
		} else {
			infoToWriteCompra += "NO_ACTIVO";
		}
		try {
			File archivo = new File(nombArchCompra);
			FileWriter escribir = new FileWriter(archivo, true);
			escribir.write(infoToWriteCompra);
			escribir.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addBillete(TransferBilletes p) {
		if(p.getId() == -1)
		{
			int idCreatorLoopCounter = 1;
			while(searchId(idCreatorLoopCounter) != null)
			{
				idCreatorLoopCounter++;
			}
			p.setId(idCreatorLoopCounter);
		}
		String nombArchBillete = "billete" + p.getId() + ".txt";
		String infoToWriteBillete = "";
		infoToWriteBillete += p.getId() + " " + p.getDni() + " " + p.getInstanciaDeVuelo() + " " + p.getPrecio() + " _END_ ";
		infoToWriteBillete += p.getNombre() + " _END_ ";
		if(p.getActivo()) {
			infoToWriteBillete += "ACTIVO";
		} else {
			infoToWriteBillete += "NO_ACTIVO";
		}
		try {
			File archivo = new File(nombArchBillete);
			FileWriter escribir = new FileWriter(archivo, true);
			escribir.write(infoToWriteBillete);
			escribir.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public TransferBilletes searchId(int id) {
		String nombArch = "billete" + id + ".txt";
		String textAdder;
		String auxEnd;
		TransferBilletes t = new TransferBilletes();
		try {
			File archivo = new File(nombArch);
			Scanner sc = new Scanner(archivo);
			t.setId(sc.nextInt());
			t.setDni(sc.next());
			t.setInstanciaDeVuelo(sc.nextInt());
			t.setPrecio(Double.parseDouble(sc.next()));
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
			t.setActivo(sc.next().equals("ACTIVO"));
			sc.close();
			return t;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean update(TransferBilletes t) {
		String nombArch = "billete" + t.getId() + ".txt";
		try {
			File archivo = new File(nombArch);
			archivo.delete();
			return addBillete(t);
		} catch (Exception e) {
			return false;
		}
	}
	
	public int asignarIdCompra() {
		int counter = 1;
		String nombArch;
		while(true) {
			try {
				nombArch = "compra" + counter + ".txt";
				File archivo = new File(nombArch);
				Scanner sc = new Scanner(archivo);
				sc.nextInt();
				counter++;
			} catch (Exception e) {
				return counter;
			}
		}
	}
}