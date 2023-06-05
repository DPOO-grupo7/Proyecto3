package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import modelo.Habitacion;
import modelo.Hotel;
import posterityKeeper.Archivador;



public class HabitacionTest {
    private Habitacion habitacion;
    
    @BeforeEach
    public void setUp() {
        // Configuración inicial para cada prueba
        habitacion = new Habitacion(2, "Ubicación", "Tipo", 1, "Tamaño", "Cama", true, false,
                true, false, true, false, true, false, true, false, true, 100);
    }

    @Test
    public void testGetters() {
        assertEquals(2, habitacion.getCapacidad());
        assertEquals("Ubicación", habitacion.getUbicacion());
        assertEquals("Tipo", habitacion.getTipo());
        assertEquals("Tamaño", habitacion.getTamanio());
        assertTrue(habitacion.isAireAcondicionado());
        assertFalse(habitacion.isCalefaccion());
        assertEquals("Cama", habitacion.getTamanioCama());
        assertTrue(habitacion.isTv());
        assertFalse(habitacion.isCafetera());
        assertTrue(habitacion.isPlancha());
        assertFalse(habitacion.isRopaDeCama());
        assertTrue(habitacion.isSecador());
        assertFalse(habitacion.isVoltaje());
        assertTrue(habitacion.isUSBA());
        assertFalse(habitacion.isUSBC());
        assertTrue(habitacion.isDesayuno());
        assertEquals(100000, habitacion.getPrecio());
    }
    
    @Test
    public void testSetFechasReservadas() {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(2023, Calendar.JUNE, 1); // Establecer una fecha de ejemplo
        calendar2.set(2023, Calendar.JUNE, 5); // Establecer una fecha de ejemplo
        Date date1 = calendar1.getTime();
        Date date2 = calendar2.getTime();
        habitacion.setFechasReservadas(date1, date2);

        assertEquals(2, habitacion.getFechasReservadas().size());
        assertTrue(habitacion.getFechasReservadas().contains(date1));
        assertTrue(habitacion.getFechasReservadas().contains(date2));
    }
    
    @Test
    public void testActualizarTarifa() {
        Habitacion.actualizarTarifa("Tipo", 150);

        HashMap<String, Integer> preciosHabitaciones = getPreciosHabitaciones();
        assertTrue(preciosHabitaciones.containsKey("Tipo"));
        assertEquals(Integer.valueOf(150), preciosHabitaciones.get("Tipo")); // Specify Integer object
    }
    
    @Test
    public void testObtenerTarifa() {
        Habitacion.actualizarTarifa("Tipo", 150);
        
        int tarifa = Habitacion.obtenerTarifa("Tipo");
        assertEquals(150, tarifa);
        
        tarifa = Habitacion.obtenerTarifa("OtroTipo");
        assertEquals(0, tarifa);
    }
    
    private HashMap<String, Integer> getPreciosHabitaciones() {
        try {
            java.lang.reflect.Field field = Habitacion.class.getDeclaredField("preciosHabitaciones");
            field.setAccessible(true);
            return (HashMap<String, Integer>) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
