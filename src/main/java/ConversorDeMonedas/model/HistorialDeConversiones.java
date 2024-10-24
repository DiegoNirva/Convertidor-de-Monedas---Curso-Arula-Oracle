package ConversorDeMonedas.model;

import java.util.Map;

public record HistorialDeConversiones(  String monedaOrigen,
                                        double ValorMonedaOrigen,
                                        String monedaAConvertir,
                                        double valorMonedaAConvertir,
                                        double ImporteACambiar,
                                        double ImporteCambiado,
                                        String FechaDeConversion) {


public void MostarDatos(){
    System.out.println("----------Fecha y hora: "+ FechaDeConversion + "---------------");
    System.out.println("Moneda: " + monedaOrigen);
    System.out.println("Moneda a convertir: " + monedaAConvertir);
    System.out.println("Tipo de cambio: "+ "$" + valorMonedaAConvertir +" "+ monedaAConvertir);
    System.out.println("Importe a cambiar: "+ "$" + ImporteACambiar +" "+ monedaOrigen);
    System.out.println("Importe a Recibir = "+ "$" + ImporteCambiado +" " + monedaAConvertir);
    System.out.println("---------------------------------------------");

}
}
