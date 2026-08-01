package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Union extends ElementoQuimico {

    private final List<ElementoQuimico> elementos = new ArrayList<>();

    public Union(ElementoQuimico... elementos) {
        for (ElementoQuimico elemento : elementos) {
            this.elementos.add(elemento);
        }
    }

    @Override 
    public void agregarElemento(ElementoQuimico elemento) {
        elementos.add(elemento);
    }

    @Override 
    public void eliminarElemento(ElementoQuimico elemento) {
        elementos.remove(elemento);
    }

    @Override 
    public String formula() {
        Map<String, Integer> conteo = new LinkedHashMap<>();
        for (ElementoQuimico e : elementos) {
            conteo.merge(e.formula(), 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            String simbolo = entry.getKey();
            int cantidad = entry.getValue();
            boolean parentesis = cantidad > 1 && simbolo.length() > 1; 
            if (parentesis) {
                sb.append("(");
            }
            sb.append(simbolo);
            if (parentesis) {
                sb.append(")");
            }
            if (cantidad > 1) {
                sb.append(cantidad);
            }
        }
        return sb.toString();
    }

    @Override 
    public int pesoMolecular() {
        return elementos.stream().mapToInt(ElementoQuimico::pesoMolecular).sum();
    }

    @Override 
    public int carga(){
        return elementos.stream().mapToInt(ElementoQuimico::carga).sum();
    }

    @Override 
    public boolean esValida() {
        return elementos.stream().allMatch(ElementoQuimico::esValida) && elementos.stream().filter(ElementoQuimico::esMetal).count() <= 1;
    }

    @Override 
    public boolean esMetal() {
        return elementos.stream().allMatch(ElementoQuimico::esMetal);
    }
    
}
