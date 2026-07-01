package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherStationTest {
    @Test 
    public void ejemplo5FuncionaCorrectamente() {
        WeatherData estacion = new WeatherDataStub();
        WeatherData estacionConDecorators = new MinMaxDecorator(new PromedioDecorator(new CelsiusDecorator(estacion)));
        String esperado = "Temperatura C: 30; Presion atmosf: 1008; Radiacion solar: 200; Promedio: 30; Minimo: 27 Maximo: 32";
        assertEquals(esperado, estacionConDecorators.displayData());
    }
}
