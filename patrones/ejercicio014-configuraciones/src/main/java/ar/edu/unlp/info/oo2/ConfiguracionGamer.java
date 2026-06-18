package ar.edu.unlp.info.oo2;

public class ConfiguracionGamer extends Configuracion {
    public ConfiguracionGamer(Catalogo catalogo){
        super(catalogo);
    }

    @Override 
    protected Componente crearProcesador(){
        Componente procesador = catalogo.getComponente("Procesador Gamer");
        Componente padTermico = catalogo.getComponente("Pad Térmico");
        Componente cooler = catalogo.getComponente("Cooler");

        return new Componente(
            "Procesador Gamer",
            procesador.getDescripcion() + " + " + padTermico.getDescripcion() + " + " + cooler.getDescripcion(),
            procesador.getPrecio() + padTermico.getPrecio() + cooler.getPrecio(),
            procesador.getConsumo() + padTermico.getConsumo() + cooler.getConsumo()); 
    }

    @Override 
    protected Componente crearMemoria(){
        Componente memoria1 = catalogo.getComponente("Memoria RAM 32GB");
        Componente memoria2 = catalogo.getComponente("Memoria RAM 32GB");

        return new Componente("Memoria RAM Dual", memoria1.getDescripcion() + " + " + memoria2.getDescripcion(), memoria1.getPrecio() + memoria2.getPrecio(), memoria1.getConsumo() + memoria2.getConsumo());
    }

    @Override 
    protected Componente crearDisco(){
        Componente disco1 = catalogo.getComponente("SSD 500GB");
        Componente disco2 = catalogo.getComponente("SSD 1TB");
        return new Componente("Disco Dual", disco1.getDescripcion() + " + " + disco2.getDescripcion(), disco1.getPrecio() + disco2.getPrecio(), disco1.getConsumo() + disco2.getConsumo());
    }

    @Override 
    protected Componente crearTarjeta(){
        return catalogo.getComponente("RTX 4090");
    }

    @Override 
    protected Componente crearGabinete(double consumoParcial){
        int potenciaFuente = (int) Math.ceil(consumoParcial * 1.5);
        Componente gabineteBase = catalogo.getComponente("Gabinete Gamer");
        Componente fuente = catalogo.getComponente("Fuente " + potenciaFuente + " w");

        return new Componente("Gabinete Gamer + Fuente", 
            gabineteBase.getDescripcion() + " + " + fuente.getDescripcion(),
            gabineteBase.getPrecio() + fuente.getPrecio(),
            gabineteBase.getConsumo() + fuente.getConsumo());
    }
}
