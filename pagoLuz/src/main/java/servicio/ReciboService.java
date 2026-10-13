package servicio;

import Modelo.Recibo;
import Modelo.Pago;


public class ReciboService {

    private int ultimoFolio = 0;

    public Recibo generarRecibo(Pago pago) {
        ultimoFolio++;
        String folio = String.format("REC%06d", ultimoFolio);
        return new Recibo(folio, pago.getImporte(), pago);
    }
}