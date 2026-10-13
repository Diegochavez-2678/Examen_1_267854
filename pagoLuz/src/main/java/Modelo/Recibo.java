package Modelo;

import java.math.BigDecimal;

public class Recibo {

    private String folio;
    private BigDecimal montoPagado;
    private Pago pago;

    public Recibo(String folio, BigDecimal montoPagado, Pago pago) {
        this.folio = folio;
        this.montoPagado = montoPagado;
        this.pago = pago;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}