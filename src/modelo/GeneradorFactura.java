package modelo;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorFactura {

    public static void generarFacturaTxt(Factura factura) {
        String nombreArchivo = "factura_" + factura.getnumeroFactura() + ".txt";

        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            // Escribir los datos en el archivo
            fileWriter.write("Número de factura: " + factura.getnumeroFactura() + "\n");
            fileWriter.write("Fecha: " + factura.getFecha() + "\n");
            fileWriter.write("Huésped: " + factura.getHuesped() + "\n");
            fileWriter.write("ID de habitación: " + factura.getidHabitacion() + "\n");
            fileWriter.write("Tipo de consumo: " + factura.gettipoConsumo() + "\n");
            fileWriter.write("Pagado: " + (factura.getpagado() ? "Sí" : "No") + "\n");
            fileWriter.write("Total: " + factura.getcosto() + "\n");

            System.out.println("La factura se ha generado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Se produjo un error al generar la factura.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Factura factura = new Factura("F001", "2023-06-04", "John Doe", "H001", "Consumo1", true);
        factura.getcosto(); // Supongamos que se calcula el total antes de generar la factura

        generarFacturaTxt(factura);
    }
}
