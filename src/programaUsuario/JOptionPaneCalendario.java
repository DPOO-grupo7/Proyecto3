package programaUsuario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import com.toedter.calendar.JCalendar;

public class JOptionPaneCalendario {

    public static Date mostrarCalendario() {
        JCalendar calendar = new JCalendar();
        JOptionPane.showMessageDialog(null, calendar, "Seleccione una fecha", JOptionPane.PLAIN_MESSAGE);

        Calendar fechaSeleccionada = calendar.getCalendar();
        Date fecha = fechaSeleccionada.getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
        String fechaFormateada = formatoFecha.format(fecha);
        try {
            fecha = formatoFecha.parse(fechaFormateada);
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error con la fecha", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return fecha;
    }
    
 
    
}