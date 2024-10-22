package ConversorDeMonedas;

import ConversorDeMonedas.apiConvertidor.ApiConvertidor;
import ConversorDeMonedas.logicaDeNegocio.Metodos;
import ConversorDeMonedas.model.DatosConsulta;
import ConversorDeMonedas.model.Moneda;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //creamos las instancias de las clases.
        ApiConvertidor apiConvertidor = new ApiConvertidor();
        Metodos metodo = new Metodos();
        Moneda moneda = new Moneda();
        Scanner ingresar = new Scanner(System.in);

        //indicamos variables
        String monedaOrigen;
        String monedaAConvertir;
        double importeACambiar;
        int option = 0;

        //iniciamos con un bucle while
        System.out.println("--------------OPCIONES-----------------");
        System.out.println("1) Realiza cambio");
        System.out.println("2) Historial de cambios realiazdos");
        System.out.println("3) Salir");
        System.out.println("---------------------------------------");
        try {
            option = ingresar.nextInt();
        }catch (Exception e){
            System.out.println("Ingrese la opcion correcta");
        }
        ingresar.nextLine();
        switch (option){
            case 1://pedimos datos al usuario:
                System.out.println("Ingrese el tipo de moneda (Ej: ARS)");
                monedaOrigen = ingresar.nextLine();
                DatosConsulta datos = apiConvertidor.GetDatos(monedaOrigen);
                System.out.println("Ingrese el tipo de cambio (Ej: USD)");
                monedaAConvertir = ingresar.nextLine();
                ingresar.nextLine();
                //guardamos datos de tipo moneda
                try {
                    moneda = metodo.TasaActualDeMoneda(datos,moneda,monedaOrigen,monedaAConvertir);
                }catch (Exception e){
                    System.out.println("No se pudo obtener valores de monedas, verifique datos ingresados");
                }
                System.out.println("Ingrese el importe a cambiar:");
                importeACambiar = ingresar.nextDouble();
                //guardamos el importe en moneda
                moneda.setImporteACambiar(importeACambiar);
                //realizamos conversion
                double cambio = metodo.ConversorMoneda(moneda);
                //guardamos el valor ya redondeado
                moneda.setImporteCambiado(metodo.Redondeo(cambio));
                System.out.println(moneda);
                break;
        }







    }
}