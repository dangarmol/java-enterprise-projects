package presentacion.vistas.vistaPrincipal;

import presentacion.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaPrincipal.principal.JFramePrincipal;

public class VistaPrincipalImp extends VistaPrincipal 
{
	private JFramePrincipal principal;

	public VistaPrincipalImp() 
	{
		createJFramePrincipal();
	}

	public void createJFramePrincipal()
	{
		principal = new JFramePrincipal();
	}

	@Override
	public void update(Contexto contexto) 
	{
		switch (contexto.getEvent())
		{
			case ListaComandos.VENTANAPRINCIPAL:
				principal.setVisible(true);
				break;
		}
	}
}