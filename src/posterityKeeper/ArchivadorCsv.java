package posterityKeeper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class ArchivadorCsv {

	public void guardarHabitacionesCSV(ArrayList<Habitacion> habitaciones) {
	    try (FileWriter writer = new FileWriter(RUTA_HABITA);
	         CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("numero", "tipo", "precio", "disponible").withIgnoreHeaderCase().withTrim());) {
	        for (Habitacion habitacion : habitaciones) {
	            csvPrinter.printRecord(habitacion.getNumero(), habitacion.getTipo(), habitacion.getPrecio(), habitacion.isDisponible());
	        }
	        csvPrinter.flush();
	    } catch (IOException e) {
	        System.out.println("Error writing CSV file: " + e.getMessage());
	    }
	}
	public ArrayList<Habitacion> cargarHabitaciones()  {
	    try (FileReader reader = new FileReader(RUTA_HABITA);
	         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("numero", "tipo", "precio", "disponible").withIgnoreHeaderCase().withTrim());) {
	        ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	        for (CSVRecord record : csvParser) {
	            int numero = Integer.parseInt(record.get("numero"));
	            String tipo = record.get("tipo");
	            double precio = Double.parseDouble(record.get("precio"));
	            boolean disponible = Boolean.parseBoolean(record.get("disponible"));
	            Habitacion habitacion = new Habitacion(numero, tipo, precio, disponible);
	            habitaciones.add(habitacion);
	        }
	        return habitaciones;
	    } catch (IOException e) {
	        System.out.println("Error reading CSV file: " + e.getMessage());
	    }
	    return new ArrayList<Habitacion>();
	}
}
