package servicio;

import repositorio.PagoRepository;
import Modelo.Recibo;
import Modelo.Pago;
import Modelo.ServicioLuz;
import java.math.BigDecimal;


public class PagoService {

    private static final int LONGITUD_TARJETA = 16;

    private final PagoRepository pagoRepository;
    private final ReciboService reciboService;

    public PagoService(PagoRepository pagoRepository, ReciboService reciboService) {
        this.pagoRepository = pagoRepository;
        this.reciboService = reciboService;
    }

    public Recibo procesarPago(ServicioLuz servicio, BigDecimal importe, String tarjeta) {
        String numeroTarjeta = limpiarTarjeta(tarjeta);
        if (!tarjetaValida(numeroTarjeta)) {
            throw new IllegalArgumentException("Numero de tarjeta invalido, debe tener 16 digitos");
        }

        Pago pago = new Pago(pagoRepository.siguienteId(), importe, "APROBADO", servicio);
        pagoRepository.guardar(pago);
        return reciboService.generarRecibo(pago);
    }

    private String limpiarTarjeta(String tarjeta) {
        if (tarjeta == null) {
            return "";
        }
        return tarjeta.replace(" ", "");
    }

    private boolean tarjetaValida(String numeroTarjeta) {
        if (numeroTarjeta.length() != LONGITUD_TARJETA) {
            return false;
        }
        for (int i = 0; i < numeroTarjeta.length(); i++) {
            if (!Character.isDigit(numeroTarjeta.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
