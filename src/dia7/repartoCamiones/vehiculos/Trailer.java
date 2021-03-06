package dia7.repartoCamiones.vehiculos;

import dia7.repartoCamiones.Conductor;
import dia7.repartoCamiones.Paquete;
import dia7.repartoCamiones.Ruta;
import dia7.repartoCamiones.constantes.Constantes.Licencia;

import java.util.ArrayList;

public class Trailer extends VehiculoReparto{
    public Trailer(Conductor conductor, Ruta ruta, ArrayList<Paquete> listaDePaquetes) {
        super(conductor, ruta, listaDePaquetes, Licencia.D, 80);
    }
}
