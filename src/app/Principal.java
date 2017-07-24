package app;

import java.awt.Desktop;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import reporte.CrearReporte;

public class Principal {
    
    public static void main(String[] args) {
        
        try {
            final Map<String,Object> parametros =
                    new HashMap<String,Object>();
            parametros.put("datos",
                    Arrays.asList("JOSE LUIS",
                            "PEPE PERZ", "DOUGRLAS HERNANDEZ"));
            CrearReporte crea = new CrearReporte();
            String ruta = crea.conviertePDF
                          ("report4.jasper", parametros);
            try {
                File archivo = new File(ruta);
                Desktop.getDesktop().open(archivo);
            } catch (Exception e) {
            }
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
