package ConversorDeMonedas.logicaDeNegocio;

import ConversorDeMonedas.model.DatosConsulta;
import ConversorDeMonedas.model.HistorialDeConversiones;
import ConversorDeMonedas.model.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Metodos {

    //metodo redondear decimar en 2 digitos
    public BigDecimal Redondeo(Double numero){

        BigDecimal valor = new BigDecimal(numero);

        BigDecimal valorRedondeado = valor.setScale(2, RoundingMode.HALF_UP);

        return valorRedondeado;
    }

    //metodo para formatear fecha y hora
    public String formatearFechaYHora(LocalDateTime fechaYhora){
        //definimos formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        //formateamos la fecha y hora
         String fechaFormateada = fechaYhora.format(formato);

        return fechaFormateada;
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

    //metodo que guarda los datos en un gson
    public void guardarOperacionDeCambio(List<Moneda> moneda) throws IOException {

        //creamos el el gson con formato JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //creamos el archivo
        FileWriter escritura = new FileWriter("HistorialDeConverciones.title()"+".json");
        escritura.write(gson.toJson(moneda));
        escritura.close();
    }

    //metodo para leer el json de historial de conversiones.
    public void leerHisotorialDeConversiones(String rutaDelArchivo){

        try{
            // Leer el contenido del archivo JSON
            String json = new String(Files.readAllBytes(Paths.get(rutaDelArchivo)));

            // creamos una lista de tipo HistorialDeConversiones
            Type historialDeConversion = new TypeToken<List<HistorialDeConversiones>>(){}.getType();
            // Creamos una lista de HistorialDeConversiones a partir del JSON
            List<HistorialDeConversiones> historial = new Gson().fromJson(json, historialDeConversion);

            // Mostrar los datos
            for (HistorialDeConversiones ver : historial) {
                ver.MostarDatos();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo .JSON");
        }
    }
}



