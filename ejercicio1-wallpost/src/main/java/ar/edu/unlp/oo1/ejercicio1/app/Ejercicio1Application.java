package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {

	
	
	public static void main(String[] args) throws SecurityException, IOException {
		//Logger del modelo, Level WARNING, persistiendo en un archivo de formato simple
		Logger modelLogger = Logger.getLogger("ar.edu.unlp.oo1.ejercicio1.impl.model");
		modelLogger.setLevel(Level.WARNING);
		FileHandler modelFileHandler = new FileHandler("model.log", true);
		modelFileHandler.setFormatter(new SimpleFormatter());
		modelLogger.addHandler(modelFileHandler);

		//Logger de la interfaz: INFO 
		Logger uiLogger = Logger.getLogger("ar.edu.unlp.oo1.ejercicio1.ui");
		uiLogger.setLevel(Level.INFO);
		uiLogger.info("Aplicación iniciada");



		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WallPostUI();
			}
		});
	}

}
