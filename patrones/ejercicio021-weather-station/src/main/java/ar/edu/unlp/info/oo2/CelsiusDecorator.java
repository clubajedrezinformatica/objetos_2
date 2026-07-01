package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.stream.Collectors;


public class CelsiusDecorator extends Aspecto {
    public CelsiusDecorator(WeatherData wrapped) {
        super(wrapped);
    }

    @Override
    public double getTemperatura() {
        return (wrapped.getTemperatura() - 32) / 1.8;
    }

    @Override 
    public List<Double> getTemperaturas() {
        return wrapped.getTemperaturas().stream()
                .map(temp -> (temp - 32) / 1.8)
                .collect(Collectors.toList());
    }

    @Override
    public String displayData() {
        return "Temperatura C: " + (int)this.getTemperatura() + "; Presion atmosf: " + (int)this.getPresion() + "; Radiacion solar: " + (int)this.getRadiacionSolar() + ";";
    }   
}