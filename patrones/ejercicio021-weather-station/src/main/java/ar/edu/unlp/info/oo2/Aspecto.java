package ar.edu.unlp.info.oo2;

import java.util.List;

public abstract class Aspecto implements WeatherData{
    protected WeatherData wrapped;

    public Aspecto(WeatherData wrapped) {
        this.wrapped = wrapped;
    }

    @Override 
    public double getTemperatura() {
        return wrapped.getTemperatura();
    }

    @Override 
    public double getPresion() {
        return wrapped.getPresion();
    }

    @Override 
    public double getRadiacionSolar() {
        return wrapped.getRadiacionSolar();
    }

    @Override 
    public List<Double> getTemperaturas() {
        return wrapped.getTemperaturas();   
    }

    @Override
    public String displayData() {   
        return wrapped.displayData();
    }
}