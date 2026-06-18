package ar.edu.unlp.info.oo2;

public class ConfiguracionIntermedia extends Configuracion {
    
    public ConfiguracionIntermedia(Catalogo catalogo){
        super(catalogo);
    }

    @Override
    protected Componente crearProcesador(){
        return this.catalogo.getComponente("Procesador Intermedio");
    }

    @Override
    protected Componente crearMemoria(){
        return this.catalogo.getComponente("Memoria RAM 16GB");
    }

    @Override
    protected Componente crearDisco(){
        return this.catalogo.getComponente("SSD 500GB");
    }

    @Override
    protected Componente crearTarjeta(){
        return this.catalogo.getComponente("GTX 1650");
    }

    @Override
    protected Componente crearGabinete(double consumoParcial){
        return this.catalogo.getComponente("Gabinete Intermedio + Fuente 800w");
    }   
    
}
