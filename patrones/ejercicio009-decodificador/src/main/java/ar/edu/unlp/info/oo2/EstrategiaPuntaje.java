package ar.edu.unlp.info.oo2;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EstrategiaPuntaje implements EstrategiaSugerencia {
    @Override
    public List<Pelicula> sugerir(Decodificador d) {
        return d.getGrilla().stream()
            .filter(p -> !d.getReproducidas().contains(p))
            .sorted(Comparator.comparingDouble(Pelicula::getPuntaje).reversed()
            .thenComparing(Comparator.comparingInt(Pelicula::getEstreno).reversed()))
            .limit(3)
            .collect(Collectors.toList());
    }
    
}
