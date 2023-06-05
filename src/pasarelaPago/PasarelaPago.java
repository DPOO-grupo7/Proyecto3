package pasarelaPago;


import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PasarelaPago {
	private Pagos newPago;

	@SuppressWarnings("unchecked")
	public void Pagar(String TipoPago, String InformacionTarjeta, String InformacionDueno, int Cobro) {
		try {

			@SuppressWarnings("rawtypes")
			Class clase = Class.forName(TipoPago);
			newPago = (Pagos) clase.getDeclaredConstructor().newInstance();
			newPago.Pago(InformacionTarjeta, InformacionDueno, Cobro);
			registrarEnLog(Cobro, TipoPago);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("No existe la clase " + TipoPago);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Hubo otro error construyendo la pasarela " + e.getMessage());
			e.printStackTrace();
		}
	}
	private void registrarEnLog(int cobro, String plataforma) {
		try {
	        String logEntry = "Fecha: " + obtenerFechaActual() + ", Hora: " + obtenerHoraActual() + ", Monto: $" + cobro
	                + ", ID de transacción: " + generarIDTransaccion();
	        FileWriter writer = new FileWriter("./logs/"+plataforma+".log", true); // El parámetro 'true' indica que se añadirá al final del archivo
	        writer.write(logEntry + "\n");
	        writer.close();
	    } catch (IOException e) {
	        System.out.println("Error al escribir en plataforma.log: " + e.getMessage());
	        e.printStackTrace();
	    }
    }   

	private String obtenerFechaActual() {
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaActual.format(formatter);
    }

    private String obtenerHoraActual() {
        LocalDateTime horaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horaActual.format(formatter);
    }

    private String generarIDTransaccion() {
        int longitudID = 10;
        StringBuilder sb = new StringBuilder();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < longitudID; i++) {
            int index = (int) (Math.random() * caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }
}
