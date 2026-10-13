package Modelo;

import Modelo.ServicioLuz;
import java.math.BigDecimal;

public class Pago {

    private int idPago;
    private BigDecimal importe;
    private String estado;
    private ServicioLuz servicio;

    public Pago(int idPago, BigDecimal importe, String estado, ServicioLuz servicio) {
        this.idPago = idPago;
        this.importe = importe;
        this.estado = estado;
        this.servicio = servicio;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ServicioLuz getServicio() {
        return servicio;
    }

    public void setServicio(ServicioLuz servicio) {
        this.servicio = servicio;
    }
}