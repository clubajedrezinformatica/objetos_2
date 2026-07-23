package ar.edu.unlp.info.oo2.biblioteca;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

public class JsonExporter implements Exporter {
    @Override
    public String exportar(List<Socio> socios) {
        JSONArray array = new JSONArray();
        for (Socio socio : socios) {
            JSONObject json = new JSONObject();
            json.put("nombre", socio.getNombre());
            json.put("email", socio.getEmail());
            json.put("legajo", socio.getLegajo());
            array.add(json);
        }
        return array.toJSONString();
    }
}