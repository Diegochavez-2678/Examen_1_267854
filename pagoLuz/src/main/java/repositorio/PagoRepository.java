package repositorio;

import Modelo.Pago;
import java.util.ArrayList;
import java.util.List;

public class PagoRepository {

    private final List<Pago> pagos = new ArrayList<>();
    private int ultimoId = 0;

    public int siguienteId() {
        ultimoId++;
        return ultimoId;
    }

    public void guardar(Pago pago) {
        pagos.add(pago);
    }
}