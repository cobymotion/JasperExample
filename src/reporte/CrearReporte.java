package reporte;

import java.io.File;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class CrearReporte {
    
    
    public String conviertePDF (String nombreReporte, 
             Map<String,Object> parametros ) throws JRException{
        
        final String reporteSource = 
                getClass().getClassLoader(). 
                  getResource("reporte/"
                          + nombreReporte).getPath();
        System.out.println(reporteSource);
        final JasperReport reporte = (JasperReport)
                JRLoader.loadObject(new 
                    File(reporteSource)); 
        
        final JasperPrint print = JasperFillManager
                .fillReport(reporte,parametros, 
                        new JREmptyDataSource()); 
        
        final String reportRuta = 
                reporteSource.substring
                (0,reporteSource.lastIndexOf("/"))
                .concat(nombreReporte).concat(".pdf");
        
        JasperExportManager.exportReportToPdfFile
        (print,reportRuta); 
        
        return reportRuta; 
        
    }
    
}
