package ConversorDeMonedas;

import ConversorDeMonedas.apiConvertidor.ApiConvertidor;
import ConversorDeMonedas.model.DatosConsulta;

public class Main {
    public static void main(String[] args) {

        ApiConvertidor prueba = new ApiConvertidor();

        DatosConsulta prueba1 = prueba.GetDatos("usd");

        System.out.println(prueba1);
    }
}