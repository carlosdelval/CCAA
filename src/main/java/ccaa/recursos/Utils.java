package ccaa.recursos;

import java.awt.Toolkit;

import javax.swing.JDialog;

import ccaa.entidades.CCAA;
import ccaa.vista.PanelComunidad;

public class Utils {
	/**
	 * 
	 */
	public static void abrirNuevoDialogo(PanelComunidad panel) {
		
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión CCAA");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(panel);
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
}
