package ar.edu.unlp.info.oo2.accesobd;

import java.util.List;
import java.util.Collection;

public class DatabaseAccessProxy implements DatabaseAccess{
    private DatabaseAccess realSubject; 
    private boolean autenticado = false;

    public DatabaseAccessProxy(DatabaseAccess realSubject) {
        this.realSubject = realSubject; 
    }

    public boolean autenticar(String usuario, String password) {
        this.autenticado = "admin".equals(usuario) && "1234".equals(password);
        return this.autenticado;
    }

    @Override 
    public int insertNewRow(List<String> rowData) {
        if(!this.isAuthorized()) {
            throw new RuntimeException("Usuario no autorizado");
        }
        return this.realSubject.insertNewRow(rowData);
    }

    @Override 
    public Collection<String> getSearchResults(String queryString) {
        if(!this.isAuthorized()) {
            throw new RuntimeException("Usuario no autorizado"); 
        }
        return this.realSubject.getSearchResults(queryString);
    }

    private boolean isAuthorized() {
        return this.autenticado;
    }
}
