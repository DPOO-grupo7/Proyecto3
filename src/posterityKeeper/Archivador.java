package posterityKeeper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import modelo.Habitacion;
import modelo.Hotel;
import utilidades.Autenticador;


public class Archivador implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String RUTA_RESER="./data/reserva.txt";
	private static final String RUTA_HABITA="./data/habitaciones.txt";
	private static final String RUTA_HOTEL="./data/hotel.txt";
	private static final String RUTA_LOGINS="./data/logins.txt";
	public Archivador() {
	}
	public void guardarHabitaciones(ArrayList<Habitacion> habitaciones)
	{
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(RUTA_HABITA))) {
            stream.writeObject(habitaciones);
        } catch (IOException e) {
            System.out.println("Error writing binary file: " + e.getMessage());
        }
	}
	public ArrayList<Habitacion> cargarHabitaciones()  {
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(RUTA_HABITA))) {
            ArrayList<Habitacion> inventario = (ArrayList<Habitacion>) stream.readObject();
            System.out.println(inventario.size());
            return inventario;
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading binary file: " + e.getMessage());
        }
		return new ArrayList<Habitacion>();
	}
	public void guardarHotel(Hotel hotel) {

		try {
            FileOutputStream archivoSalida = new FileOutputStream(RUTA_HOTEL);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(hotel);
            objetoSalida.close();
            archivoSalida.close();
            System.out.println("Hotel serializado y guardado en el archivo: " + RUTA_HOTEL);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	public Hotel cargarHotel()
	{
		Hotel hotelDeserializado = null;
		try {
            FileInputStream archivoEntrada = new FileInputStream(RUTA_HOTEL);
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            Object object = (Hotel) objetoEntrada.readObject();
            objetoEntrada.close();
            archivoEntrada.close();
            if (object instanceof Hotel) {
                hotelDeserializado= (Hotel) object;
             
            } else {
                System.out.println("No se pudo deserializar el hotel.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
        }
		return hotelDeserializado;
        
        // Verificación del hotel deserializado
		
		

	}
	public Autenticador cargarAutenticador()
	{
		Autenticador hotelDeserializado = null;
		try {
            FileInputStream archivoEntrada = new FileInputStream(RUTA_LOGINS);
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            Object object = (Autenticador) objetoEntrada.readObject();
            objetoEntrada.close();
            archivoEntrada.close();
            if (object instanceof Autenticador) {
                hotelDeserializado= (Autenticador) object;
             
            } else {
                System.out.println("No se pudo deserializar el hotel.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
        }
		return hotelDeserializado;
	}
	
	public void guardarAutenticador(Autenticador hotel) {

		try {
            FileOutputStream archivoSalida = new FileOutputStream(RUTA_LOGINS);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(hotel);
            objetoSalida.close();
            archivoSalida.close();
            System.out.println("Autenticador serializado y guardado en el archivo: " + RUTA_LOGINS);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

