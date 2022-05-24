package com.kevyn.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.kevyn.ws.vo.PersonaVo;

public class PersonasUtilidades {
	
	public final static int TIPO_ADMIN = 1;
	public final static int TIPO_EMPLEADO = 2;
	static int bandera = 0;
	
	public static List<PersonaVo> listaPersonas = new ArrayList<PersonaVo>();
	
	public static void iniciarLista() {
		if (bandera == 0) {
			listaPersonas.add(new PersonaVo("admin","Administrador","NA", 0,"NA","admin",1));
			listaPersonas.add(new PersonaVo("111","Kevyn santigo","315315", 22 ,"Estudiante","111",TIPO_ADMIN));
			listaPersonas.add(new PersonaVo("222","maria antonia","4774455", 50 ,"Ingeniero","222",TIPO_EMPLEADO));
			listaPersonas.add(new PersonaVo("333","Pepe Grillo","55214", 30 ,"Profesor","333",TIPO_EMPLEADO));
			bandera = 1;
		}
	}
}
