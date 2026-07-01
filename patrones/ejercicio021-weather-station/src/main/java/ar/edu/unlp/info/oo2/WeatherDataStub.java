package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.ArrayList;

public class WeatherDataStub implements WeatherData {
    @Override
    public double getTemperatura() {
        return 86.0;
    }

    @Override 
    public double getPresion() {
        return 1008.0;
    }

    @Override 
    public double getRadiacionSolar() {
        return 200.0;
    }

    @Override 
    public List<Double> getTemperaturas() {
        List<Double> temperaturas = new ArrayList<>();
        temperaturas.add(81.6);
        temperaturas.add(87.8);
        temperaturas.add(90.6);
        return temperaturas;
    }

    @Override 
    public String displayData() {
        return "Temperatura F: " + (int)this.getTemperatura() + "; Presion atmosf: " + (int)this.getPresion() + "; Radiacion solar: " + (int)this.getRadiacionSolar() + ";";
    }
}
