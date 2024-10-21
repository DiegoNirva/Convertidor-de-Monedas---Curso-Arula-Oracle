package ConversorDeMonedas.model;

import java.util.Map;

public record DatosConsulta(Map<String, Double> conversion_rates) {
}
