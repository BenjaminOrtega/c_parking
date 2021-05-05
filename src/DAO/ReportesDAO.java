package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
public class ReportesDAO {	
	public void buscarAutos() throws JRException, SQLException {

		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"PDFJasper\\auto_general.jasper", null, Conexion.getConnection());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reportes\\ReporteAutosGeneral.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"PDFJasper\\auto_general.jasper", null,Conexion.getConnection());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);
		jasperViewer.setVisible(true);
		System.out.println("ya genero");
		Conexion.getConnectionClose();

	}
	
	public void BuscarPersonas() throws JRException {

		// descarga dentro del mismo proyecto
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"PDFJasper\\persona_general.jasper", null, Conexion.getConnection());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reportes\\ReportePersonasGeneral.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"PDFJasper\\persona_general.jasper", null, Conexion.getConnection());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);//es para mostrarlo
		jasperViewer.setVisible(true);//aqui cambialo por false con un metodo o algo para cerrar la vistacpor que la clase usa el metodo System.exit(0) por default
		System.out.println("ya genero");//mensaje de ya estubo

	}
	public void buscarRegistrosGenerales() throws JRException {

		// descarga dentro del mismo proyecto
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"PDFJasper\\ingresos_general.jasper", null, Conexion.getConnection());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reportes\\ingresos_general.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"PDFJasper\\ingresos_general.jasper", null, Conexion.getConnection());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);//es para mostrarlo
		jasperViewer.setVisible(true);//aqui cambialo por false con un metodo o algo para cerrar la vistacpor que la clase usa el metodo System.exit(0) por default
		System.out.println("ya genero");//mensaje de ya estubo

	}
	
	public void generarTicket() throws JRException {

		// descarga dentro del mismo proyecto
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"PDFJasper\\ticket.jasper", null, Conexion.getConnection());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reportes\\ticket"+buscarId()+".pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"PDFJasper\\ticket.jasper", null, Conexion.getConnection());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);//es para mostrarlo
		jasperViewer.setVisible(true);//aqui cambialo por false con un metodo o algo para cerrar la vistacpor que la clase usa el metodo System.exit(0) por default
		System.out.println("ya genero");//mensaje de ya estubo
	}
	

	public void BuscarFiltroPersona() throws JRException {

		// descarga dentro del mismo proyecto
		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"PDFJasper\\personas_filtro.jasper", null, Conexion.getConnection());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reportes\\ReportePersonasFiltro.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"PDFJasper\\personas_filtro.jasper", null, Conexion.getConnection());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);//es para mostrarlo
		jasperViewer.setVisible(true);//aqui cambialo por false con un metodo o algo para cerrar la vistacpor que la clase usa el metodo System.exit(0) por default
		System.out.println("ya genero");//mensaje de ya estubo
	}
	
	public void buscarFiltroAuto() throws JRException {		JasperPrint jasperPrint = JasperFillManager.fillReport(
				"PDFJasper\\auto_filtro.jasper", null, Conexion.getConnection());
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reportes\\ReporteAutosFiltro.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();

		// se muestra en una ventana aparte para su descarga
		
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"PDFJasper\\auto_filtro.jasper", null, Conexion.getConnection());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow, false);//es para mostrarlo
		jasperViewer.setVisible(true);//aqui cambialo por false con un metodo o algo para cerrar la vistacpor que la clase usa el metodo System.exit(0) por default
		System.out.println("ya genero");//mensaje de ya estubo

	}
	
	private int buscarId() {
		int ID=0;
		String sql = "Select id_registro from r_ingresos order by id_registro desc Limit 1";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) ID=rs.getInt("id_registro");
			Conexion.getConnectionClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ID;
	}
	
}
