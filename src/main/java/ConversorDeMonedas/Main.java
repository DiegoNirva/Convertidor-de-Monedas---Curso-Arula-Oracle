package ConversorDeMonedas;

import ConversorDeMonedas.apiConvertidor.ApiConvertidor;
import ConversorDeMonedas.logicaDeNegocio.Metodos;
import ConversorDeMonedas.model.DatosConsulta;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ApiConvertidor prueba = new ApiConvertidor();
        Metodos metodo = new Metodos();

        DatosConsulta prueba1 = prueba.GetDatos("ars");

        Map<String, Double> moneda = metodo.valorMonedas(prueba1);

        System.out.println(moneda);
    }
}