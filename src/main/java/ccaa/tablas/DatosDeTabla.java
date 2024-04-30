package ccaa.tablas;

import java.util.List;

import ccaa.controladores.ControladorProvincia;
import ccaa.entidades.Provincia;


public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Parent Code", "Code", "Label"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		ControladorProvincia cp = new ControladorProvincia();
		List<Provincia> provincias = (List<Provincia>) cp.findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[provincias.size()][3];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < provincias.size(); i++) {
			Provincia p = provincias.get(i);
			datos[i][0] = p.getParent_code();
			datos[i][1] = p.getCode();
			datos[i][2] = p.getLabel();
		}
		
		return datos;
	}
	
	
}
