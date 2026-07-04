package ar.edu.unlp.info.oo2.accesobd;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class DatabaseAccessSpy implements DatabaseAccess {
    private List <String> llamadas = new ArrayList<>();

    @Override 
    public int insertNewRow(List<String> rowData) {
        llamadas.add("intertNewRow: " + rowData + ")");
        return 99;
    }

    @Override public Collection<String> getSearchResults(String queryString) {
        llamadas.add("getSearchResults(" + queryString + ")");
        return new ArrayList<>();
    }

    public List<String> getLlamadas() {
        return llamadas;
    }

    public boolean fueInvocado() {
        return !llamadas.isEmpty();
    }
    
}
