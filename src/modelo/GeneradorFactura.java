package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;

public class GeneradorFactura {

    public static void generarFacturaTxt(Factura factura) {
        String nombreArchivo = "./data/factura.txt";

        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            // Escribir los datos en el archivo
            fileWriter.write("Número de factura: " + factura.getnumeroFactura() + "\n");
            fileWriter.write("Fecha: " + factura.getFecha() + "\n");
            fileWriter.write("Huésped: " + factura.getHuesped() + "\n");
            fileWriter.write("ID de habitación: " + factura.getidHabitacion() + "\n");
            fileWriter.write("ID de la reserva: " + factura.getIdReserva() + "\n");
            fileWriter.write("Tipo de consumo: " + factura.gettipoConsumo() + "\n");
            fileWriter.write("Pagado: " + (factura.getpagado() ? "Sí" : "No") + "\n");
            fileWriter.write("Total: " + factura.getcosto() + "\n");
            try {
                File archivo = new File(nombreArchivo);
                if (archivo.exists() && archivo.isFile()) {
                    Desktop.getDesktop().open(archivo);
                    //System.out.println("El archivo se ha abierto correctamente.");
                } else {
                    //System.out.println("El archivo no existe o no es válido.");
                }
            } catch (IOException e) {
                System.out.println("Se produjo un error al abrir el archivo.");
                e.printStackTrace();
            }
            System.out.println("La factura se ha generado correctamente en el archivo " + nombreArchivo);
            
        } catch (IOException e) {
            System.out.println("Se produjo un error al generar la factura.");
            e.printStackTrace();
        }
        
    }
    
 

}
