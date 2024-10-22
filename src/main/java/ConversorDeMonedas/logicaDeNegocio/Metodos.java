package ConversorDeMonedas.logicaDeNegocio;

import ConversorDeMonedas.model.DatosConsulta;
import ConversorDeMonedas.model.Moneda;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Metodos {

    //metodo redondear decimar en 2 digitos
    public BigDecimal Redondeo(Double numero){

        BigDecimal valor = new BigDecimal(numero);

        BigDecimal valorRedondeado = valor.setScale(2, RoundingMode.HALF_UP);

        return valorRedondeado;
    }

    //metodo para obtener el valor de monedas.
    public Moneda TasaActualDeMoneda(DatosConsulta datosConsulta, Moneda moneda, String monedaOriginal, String monedaAConvertir){

        moneda.setMonedaOrigen(monedaOriginal);
        moneda.setValorMonedaOrigen(datosConsulta.conversion_rates().getOrDefault(monedaOriginal.toUpperCase(),0.0));
        moneda.setMonedaAConvertir(monedaAConvertir);
        moneda.setValorMonedaAConvertir(datosConsulta.conversion_rates().getOrDefault(monedaAConvertir.toUpperCase(),0.0));
        return moneda;
    }

    //metodo conversion de monedas.
    public double ConversorMoneda(Moneda moneda){
        //realizamos la operacion.
        return moneda.getImporteACambiar() * moneda.getValorMonedaAConvertir();
    }
}



