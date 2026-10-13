package Modelo;

import java.math.BigDecimal;

public class Consumo {

    private int idConsumo;
    private String periodo;
    private BigDecimal importe;
    private String estado;
    private ServicioLuz servicio;

    public Consumo(int idConsumo, String periodo, BigDecimal importe, String estado, ServicioLuz servicio) {
        this.idConsumo = idConsumo;
        this.periodo = periodo;
        this.importe = importe;
        this.estado = estado;
        this.servicio = servicio;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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