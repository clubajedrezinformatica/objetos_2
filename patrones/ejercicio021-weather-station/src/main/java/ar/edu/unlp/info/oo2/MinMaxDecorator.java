package ar.edu.unlp.info.oo2;

public class MinMaxDecorator extends Aspecto {
    public MinMaxDecorator(WeatherData wrapped) {
        super(wrapped);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Minimo: " + (int)this.calcularMinimo() + " Maximo: " + (int)this.calcularMaximo();
    }

    private double calcularMinimo() {
        return this.getTemperaturas().stream().mapToDouble(Double::doubleValue).min().orElse(0);
    }

    private double calcularMaximo() {
        return this.getTemperaturas().stream().mapToDouble(Double::doubleValue).max().orElse(0);
    }
}
