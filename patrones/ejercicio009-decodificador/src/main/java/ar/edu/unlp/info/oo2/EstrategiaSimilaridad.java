package ar.edu.unlp.info.oo2;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EstrategiaSimilaridad implements EstrategiaSugerencia {
    @Override
    public List<Pelicula> sugerir(Decodificador d) {
        return d.getReproducidas().stream()
            .flatMap(p -> p.getSimilares().stream())
            .distinct()
            .filter(p -> !d.getReproducidas().contains(p))
            .sorted(Comparator.comparingInt(Pelicula::getEstreno).reversed())
            .limit(3)
            .collect(Collectors.toList());
    }
    
}
