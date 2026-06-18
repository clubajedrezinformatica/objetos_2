package ar.edu.unlp.info.oo2;

public class ConfiguracionBasica extends Configuracion {

    public ConfiguracionBasica(Catalogo catalogo){
        super(catalogo);
    }

    @Override
    protected Componente crearProcesador(){
        return this.catalogo.getComponente("Procesador Básico");
    }

    @Override
    protected Componente crearMemoria(){
        return this.catalogo.getComponente("Memoria RAM 8GB");
    }

    @Override
    protected Componente crearDisco(){
        return this.catalogo.getComponente("HDD 500GB");
    }

    @Override
    protected Componente crearTarjeta(){
        return this.catalogo.getComponente("");
    }

    @Override
    protected Componente crearGabinete(double consumoParcial){
        return this.catalogo.getComponente("Gabinete Estándar");
    }   
}