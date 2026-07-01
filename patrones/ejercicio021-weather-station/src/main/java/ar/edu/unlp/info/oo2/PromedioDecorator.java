package ar.edu.unlp.info.oo2;

public class PromedioDecorator extends Aspecto {
    public PromedioDecorator(WeatherData wrapped) {
        super(wrapped);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Promedio: " + (int)this.calcularPromedio() + ";";
    }
    
    private double calcularPromedio() {
        return (int)this.getTemperaturas().stream().mapToDouble(Double::doubleValue).average().orElse(0); 

    }
}
