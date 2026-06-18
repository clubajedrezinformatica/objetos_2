package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmpresaTest {
    private Empresa empresa; 
    private Catalogo catalogo;
    private Configuracion basica;
    private Configuracion intermedia;
    private Configuracion gamer; 

    @BeforeEach
    public void setUp(){
        empresa = new Empresa();
        catalogo = empresa.getCatalogo();
        basica = new ConfiguracionBasica(catalogo);
        intermedia = new ConfiguracionIntermedia(catalogo);
        gamer = new ConfiguracionGamer(catalogo);
    }

    @Test 
    public void armarEquipoBasicaTieneCincoComponentes(){
        Equipo equipo = basica.armarEquipo();
        assertEquals(5, equipo.tamano());
    }

    @Test 
    public void consumoEquipoBasicoEsLaSumaDeSusComponentes(){
        Equipo equipo = basica.armarEquipo();
        double consumo = equipo.calcularConsumoTotal();
        assertEquals(80.0, consumo, 0.01);
    }

    @Test 
    public void precioEquipoBasicaIncluyeIVA(){
        Equipo equipo = basica.armarEquipo();
        double precio = equipo.calcularPrecioTotal();
        assertEquals(99220.0, precio, 0.01);
    }

    @Test 
    public void presupuestoTieneSolicitanteCorrecto(){
        Presupuesto presupuesto = empresa.crearPresupuesto(basica, "Juan Pérez");
        assertEquals("Juan Pérez", presupuesto.getSolicitante());
    }

    @Test 
    public void presupuestoTieneFechaActual(){
        Presupuesto presupuesto = empresa.crearPresupuesto(basica, "Juan Pérez");
        assertEquals(LocalDate.now(), presupuesto.getFecha());
    }

    @Test 
    public void presupuestoFinalEsCorrecto(){
        Presupuesto presupuesto = empresa.crearPresupuesto(basica, "Juan Pérez");
        double precioEsperado = basica.armarEquipo().calcularPrecioTotal();
        assertEquals(precioEsperado, presupuesto.calcularPrecio(), 0.01);
    }

    @Test 
    public void configuracionGamerTieneFuenteAdecuada() {
        Equipo equipo = gamer.armarEquipo();
        double consumo = equipo.calcularConsumoTotal();
        assertEquals(616.0, consumo, 0.01);
    }

    @Test 
    public void empresaPuedeGenerarPrepuestosDeDistintasConfiguraciones(){
        Presupuesto p1 = empresa.crearPresupuesto(basica, "Cliente A");
        Presupuesto p2 = empresa.crearPresupuesto(gamer, "Cliente B");
        assertNotEquals(p1.calcularPrecio(), p2.calcularPrecio());
    }
}