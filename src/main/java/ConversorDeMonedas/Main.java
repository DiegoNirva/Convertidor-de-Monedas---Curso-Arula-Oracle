package ConversorDeMonedas;

import ConversorDeMonedas.apiConvertidor.ApiConvertidor;
import ConversorDeMonedas.logicaDeNegocio.Metodos;
import ConversorDeMonedas.model.DatosConsulta;
import ConversorDeMonedas.model.Moneda;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //creamos las instancias de las clases.
        ApiConvertidor apiConvertidor = new ApiConvertidor();
        Metodos metodo = new Metodos();
        Scanner ingresar = new Scanner(System.in);

        //indicamos variables
        String rutaDelJson = "C:\\Users\\Usuario\\OneDrive\\Escritorio\\Cursos\\One Oracle\\java\\Conversor de monedas\\HistorialDeConverciones.title().json";
        String monedaOrigen;
        String monedaAConvertir;
        List<Moneda> listaDeMoneda = new ArrayList<>();
        double importeACambiar;
        int option = 0;

        //iniciamos con un bucle while
        while (option != 3){

            Moneda moneda = new Moneda();

            System.out.println("--------------OPCIONES-----------------");
            System.out.println("1) Realiza cambio");
            System.out.println("2) Historial de cambios realiazdos");
            System.out.println("3) Salir");
            System.out.println("---------------------------------------");
            System.out.println("Ingrese opcion");
            try {
                option = ingresar.nextInt();
            }catch (Exception e){
                System.out.println("Ingrese la opcion correcta");
            }
            ingresar.nextLine();
            switch (option){
                case 1://pedimos datos al usuario:
                    //guardamos fecha y hora de transaccion.
                    LocalDateTime fechaYHora = LocalDateTime.now();
                    moneda.setFechaDeConversion(metodo.formatearFechaYHora(fechaYHora));
                    System.out.println("Ingrese el tipo de moneda (Ej: ARS)");
                    monedaOrigen = ingresar.nextLine();
                    DatosConsulta datos = apiConvertidor.GetDatos(monedaOrigen);
                    System.out.println("Ingrese el tipo de cambio (Ej: USD)");
                    monedaAConvertir = ingresar.nextLine();
                    //guardamos datos de tipo moneda
                    try {
                        moneda = metodo.TasaActualDeMoneda(datos,moneda,monedaOrigen,monedaAConvertir);
                    }catch (Exception e){
                        System.out.println("No se pudo obtener valores de monedas, verifique datos ingresados");
                    }
                    System.out.println("Ingrese el importe a cambiar:");
                    importeACambiar = ingresar.nextDouble();
                    ingresar.nextLine();
                    //guardamos el importe en moneda
                    moneda.setImporteACambiar(importeACambiar);
                    //realizamos conversion
                    double cambio = metodo.ConversorMoneda(moneda);
                    //guardamos el valor ya redondeado
                    moneda.setImporteCambiado(metodo.Redondeo(cambio));
                    System.out.println(moneda);
                    listaDeMoneda.add(moneda);
                    try {
                        metodo.guardarOperacionDeCambio(listaDeMoneda);
                    } catch (IOException e) {
                        System.out.println("No se pudo guardar la conversion.");
                    }
                    break;
                case 2:
                    metodo.leerHisotorialDeConversiones(rutaDelJson);
                    break;
                case 3:
                    break;
                default:
            }
        }






    }
}