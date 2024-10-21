package ConversorDeMonedas.logicaDeNegocio;

import ConversorDeMonedas.model.DatosConsulta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Metodos {

    //definimos una lista con modenas fijas.
    List<String> monedas = Arrays.asList("ARS","BOB", "BRL", "CLP", "COP","USD");

    //metodo para obtener conversion de monedas.
    public Map<String, Double> valorMonedas(DatosConsulta datosConsulta){

        //definimos un treemap para guardad los datos
        Map<String, Double> valores = new TreeMap<>();
        //iteramos con un forEach para guardar los valores en nuestro map.
        for(String moneda : monedas){
            valores.put(moneda, datosConsulta.conversion_rates().getOrDefault(moneda, 0.0));
        }
        return valores;
    }



}


