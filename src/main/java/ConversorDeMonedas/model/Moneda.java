package ConversorDeMonedas.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Moneda {

    String monedaOrigen;
    double ValorMonedaOrigen;
    String monedaAConvertir;
    double valorMonedaAConvertir;

    double ImporteACambiar;

    BigDecimal ImporteCambiado;

    String FechaDeConversion;

    public Moneda() {
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public double getValorMonedaOrigen() {
        return ValorMonedaOrigen;
    }

    public void setValorMonedaOrigen(double ValorMonedaOrigen) {
        this.ValorMonedaOrigen = ValorMonedaOrigen;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public void setMonedaAConvertir(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
    }

    public double getValorMonedaAConvertir() {
        return valorMonedaAConvertir;
    }

    public void setValorMonedaAConvertir(double valorMonedaAConvertir) {
        this.valorMonedaAConvertir = valorMonedaAConvertir;
    }

    public double getImporteACambiar() {
        return ImporteACambiar;
    }

    public void setImporteACambiar(double importeACambiar) {
        ImporteACambiar = importeACambiar;
    }

    public BigDecimal getImporteCambiado() {
        return ImporteCambiado;
    }

    public void setImporteCambiado(BigDecimal importeCambiado) {
        ImporteCambiado = importeCambiado;
    }

    public void setFechaDeConversion(String fechaDeConversion) {
        FechaDeConversion = fechaDeConversion;
    }

    @Override
    public String toString() {
        return "------------DATOS DE OPERACION-----------------------" + '\n' +
                "Fecha y hora: "+ FechaDeConversion + '\n' +
                "Moneda: " + monedaOrigen + '\n' +
                "Moneda a convertir: " + monedaAConvertir + '\n' +
                "Tipo de cambio: "+ "$" + valorMonedaAConvertir +" "+ monedaAConvertir +'\n' +
                "Importe a cambiar: "+ "$" + ImporteACambiar +" "+ monedaOrigen + '\n' +
                "Importe a Recibir = "+ "$" + ImporteCambiado +" " + monedaAConvertir+  '\n' +
                "**NO SE CONTENPLAN LOS IMPUESTOS SOBRE LA TASA DE CAMBIO PERTENECIENTE A CADA PAIS**"+'\n'+
                "----------------------------------------------------";

    }
}
