package presentacion;

public class ListaComandos 
{
	// Vista Principal
	
    public static final int VENTANAPRINCIPAL		 					= 101;
    
    // Vista Bicicleta
    
    public static final int VENTANAALTABICICLETACARRETERA 				= 201;
    public static final int VENTANAALTABICICLETAMONTANA 				= 202;
    public static final int VENTANABAJABICICLETA						= 203;
    public static final int VENTANABOTONERABICICLETA 					= 204;
    public static final int VENTANADETALLEBICICLETA 					= 205;
    public static final int VENTANALISTABICICLETA 						= 206;
    public static final int VENTANAMODIFICARBICICLETACARRETERA 			= 207;
    public static final int VENTANAMODIFICARBICICLETAMONTANA 			= 208;
    
    // Vista Cliente
    
    public static final int VENTANAALTACLIENTE		 					= 301;
    public static final int VENTANABAJACLIENTE							= 302;
    public static final int VENTANABOTONERACLIENTE	 					= 303;
    public static final int VENTANADETALLECLIENTE 						= 304;
    public static final int VENTANALISTACLIENTE	 						= 305;
    public static final int VENTANAMODIFICARCLIENTE			 			= 306;
    
    // Vista Compra
    
    public static final int VENTANAAGREGARARTICULOCOMPRA 				= 401;
    public static final int VENTANABOTONERACOMPRA						= 402;
    public static final int VENTANADETALLECOMPRA 						= 403;
    public static final int VENTANADEVOLUCIONCOMPRA 					= 404;
    public static final int VENTANAELIMINARARTICULOCOMPRA				= 405;
    public static final int VENTANAGESTIONCARRITOCOMPRA					= 406;
    public static final int VENTANAINICIARCOMPRA 						= 407;
    public static final int VENTANALISTACOMPRA 							= 408;

    // Negocio Bicicleta
    
    public static final int NEGOCIOALTABICICLETA		 				= 211;
    public static final int NEGOCIOBAJABICICLETA						= 212;
    public static final int NEGOCIODETALLEBICICLETA 					= 213;
    public static final int NEGOCIOLISTABICICLETA 						= 214;
    public static final int NEGOCIOMODIFICARBICICLETA					= 215;
   
    // Negocio Cliente
    
    public static final int NEGOCIOALTACLIENTE 							= 311;
    public static final int NEGOCIOBAJACLIENTE 							= 312;
    public static final int NEGOCIODETALLECLIENTE						= 313;
    public static final int NEGOCIOLISTACLIENTE 						= 314;
    public static final int NEGOCIOMODIFICARCLIENTE						= 315;
   
    // Negocio Compra
    
    public static final int NEGOCIOAGREGARARTICULOCOMPRA 				= 411;
    public static final int NEGOCIODETALLECOMPRA 						= 412;
    public static final int NEGOCIODEVOLUCIONCOMPRA 					= 413;
    public static final int NEGOCIOELIMINARARTICULOCOMPRA				= 414;
    public static final int NEGOCIOGESTIONCARRITOCOMPRA					= 415;
    public static final int NEGOCIOLISTACOMPRA 							= 416;
    public static final int NEGOCIOFINALIZARCOMPRA						= 417;

    // Mostrar Bicicleta
    
    public static final int MOSTRARALTABICICLETA		 				= 221;
    public static final int MOSTRARBAJABICICLETA						= 222;
    public static final int MOSTRARDETALLEBICICLETA 					= 223;
    public static final int MOSTRARLISTABICICLETA 						= 224;
    public static final int MOSTRARMODIFICARBICICLETA		 			= 225;
    
    // Mostrar Cliente
    
    public static final int MOSTRARALTACLIENTE		 					= 321;
    public static final int MOSTRARBAJACLIENTE							= 322;
    public static final int MOSTRARDETALLECLIENTE 						= 323;
    public static final int MOSTRARLISTACLIENTE 						= 324;
    public static final int MOSTRARMODIFICARCLIENTE		 				= 325;
    
    // Mostrar Compra
    public static final int MOSTRARGESTIONCARRITOCOMPRA					= 431;
    public static final int MOSTRARAGREGARARTICULOCOMPRA				= 432;
    public static final int MOSTRARELIMINARARTICULOCOMPRA				= 433;
    public static final int MOSTRARDEVOLUCIONARTICULOCOMPRA				= 434;
    public static final int MOSTRARBAJACOMPRA							= 435;
    public static final int MOSTRARDETALLECOMPRA						= 436;
    public static final int MOSTRARLISTACOMPRA 							= 437;
    public static final int MOSTRARFINALIZARCOMPRA						= 438;
    
    
    // Vista Query
    
    public static final int VENTANANUMEROCLIENTESQUERY					= 501;
    public static final int VENTANACANTIDADBICICLETASQUERY				= 502;
    
    // Negocio query
    
    public static final int NEGOCIONUMEROCLIENTESQUERY					= 511;
    public static final int NEGOCIOCANTIDADBICICLETASQUERY				= 512;
    
    // Mostrar Query
    
    public static final int MOSTRARNUMEROCLIENTESQUERY					= 531;
    public static final int MOSTRARCANTIDADBICICLETASQUERY				= 532;
    
    // Modulo JPA
    
    // Vista Departamento
    
    public static final int VENTANAALTADEPARTAMENTO		 				= 601;
    public static final int VENTANABAJADEPARTAMENTO						= 602;
    public static final int VENTANABOTONERADEPARTAMENTO	 				= 603;
    public static final int VENTANADETALLEDEPARTAMENTO 					= 604;
    public static final int VENTANALISTADEPARTAMENTO					= 605;
    public static final int VENTANAMODIFICARDEPARTAMENTO		 		= 606;
    public static final int VENTANACALCULARNOMINADEPARTAMENTO	 		= 607;
    
    // Vista Empleado
    
    public static final int VENTANAALTAEMPLEADO			 				= 701;
    public static final int VENTANABAJAEMPLEADO							= 703;
    public static final int VENTANABOTONERAEMPLEADO 					= 704;
    public static final int VENTANADETALLEEMPLEADO 						= 705;
    public static final int VENTANALISTAEMPLEADO						= 706;
    public static final int VENTANAMODIFICAREMPLEADO		 			= 707;
    
    // Vista Tienda
    
    public static final int VENTANAALTATIENDA 							= 801;
    public static final int VENTANABAJATIENDA							= 802;
    public static final int VENTANABOTONERATIENDA 						= 803;
    public static final int VENTANADETALLETIENDA						= 804;
    public static final int VENTANALISTATIENDA							= 805;
    public static final int VENTANAMODIFICARTIENDA						= 806;
    public static final int VENTANAASIGNARTIENDA 						= 807;
    public static final int VENTANADESASIGNARTIENDA						= 808;
    public static final int VENTANAASIGNARDEPARTAMENTOTIENDA			= 809;
    public static final int VENTANADESASIGNARDEPARTAMENTOTIENDA			= 810;
    public static final int VENTANAASIGNARPRESUPUESTOTIENDA				= 811;
    public static final int VENTANADETALLEPRESUPUESTOTIENDA				= 812;
    public static final int VENTANALISTAPRESUPUESTOTIENDA				= 813;
    
    // Negocio Departamento
    
    public static final int NEGOCIOALTADEPARTAMENTO		 				= 611;
    public static final int NEGOCIOBAJADEPARTAMENTO						= 612;
    public static final int NEGOCIODETALLEDEPARTAMENTO 					= 613;
    public static final int NEGOCIOLISTADEPARTAMENTO					= 614;
    public static final int NEGOCIOMODIFICARDEPARTAMENTO				= 615;
    public static final int NEGOCIOCALCULARNOMINADEPARTAMENTO			= 616;
    
    // Negocio Empleado
    
    public static final int NEGOCIOALTAEMPLEADO		 					= 711;
    public static final int NEGOCIOBAJAEMPLEADO							= 712;
    public static final int NEGOCIODETALLEEMPLEADO 						= 713;
    public static final int NEGOCIOLISTAEMPLEADO						= 714;
    public static final int NEGOCIOMODIFICAREMPLEADO					= 715;
    
    // Negocio Tienda
    
    public static final int NEGOCIOALTATIENDA 							= 821;
    public static final int NEGOCIOBAJATIENDA							= 822;
    public static final int NEGOCIODETALLETIENDA						= 823;
    public static final int NEGOCIOLISTATIENDA							= 824;
    public static final int NEGOCIOMODIFICARTIENDA						= 825;
    public static final int NEGOCIOASIGNARDEPARTAMENTOTIENDA			= 826;
    public static final int NEGOCIODESASIGNARDEPARTAMENTOTIENDA			= 827;
    public static final int NEGOCIOASIGNARPRESUPUESTOTIENDA				= 828;
    public static final int NEGOCIODETALLEPRESUPUESTOTIENDA				= 829;
    public static final int NEGOCIOLISTAPRESUPUESTOTIENDA				= 830;
    
    // Mostrar Departamento
    
    public static final int MOSTRARALTADEPARTAMENTO		 				= 621;
    public static final int MOSTRARBAJADEPARTAMENTO						= 622;
    public static final int MOSTRARDETALLEDEPARTAMENTO 					= 623;
    public static final int MOSTRARLISTADEPARTAMENTO 					= 624;
    public static final int MOSTRARMODIFICARDEPARTAMENTO		 		= 625;
    public static final int MOSTRARCALCULARNOMINADEPARTAMENTO	 		= 626;
    
    // Mostrar Empleado
    
    public static final int MOSTRARALTAEMPLEADO		 					= 721;
    public static final int MOSTRARBAJAEMPLEADO							= 722;
    public static final int MOSTRARDETALLEEMPLEADO 						= 723;
    public static final int MOSTRARLISTAEMPLEADO 						= 724;
    public static final int MOSTRARMODIFICAREMPLEADO		 			= 725;
    public static final int MOSTRARCALCULARNOMINAEMPLEADO	 			= 726;
    
    // Mostrar Tienda
    
    public static final int MOSTRARALTATIENDA 							= 841;
    public static final int MOSTRARBAJATIENDA							= 842;
    public static final int MOSTRARDETALLETIENDA						= 843;
    public static final int MOSTRARLISTATIENDA							= 844;
    public static final int MOSTRARMODIFICARTIENDA						= 845;
    public static final int MOSTRARASIGNARTIENDA 						= 846;
    public static final int MOSTRARDESASIGNARTIENDA						= 847;
    public static final int MOSTRARASIGNARDEPARTAMENTOTIENDA			= 848;
    public static final int MOSTRARDESASIGNARDEPARTAMENTOTIENDA			= 849;
    public static final int MOSTRARASIGNARPRESUPUESTOTIENDA				= 850;   
    public static final int MOSTRARDETALLEPRESUPUESTOTIENDA				= 851;
    public static final int MOSTRARLISTAPRESUPUESTOTIENDA				= 852;
}
