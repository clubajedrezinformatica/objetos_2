package ar.edu.unlp.info.oo2.biblioteca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JacksonExporter implements Exporter {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String exportar(List<Socio> socios) {
        try {
            return mapper.writeValueAsString(socios);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al serializar socios a JSON", e);
        }
    }
}
