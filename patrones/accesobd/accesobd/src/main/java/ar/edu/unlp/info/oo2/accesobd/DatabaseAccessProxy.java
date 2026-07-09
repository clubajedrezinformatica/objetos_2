package ar.edu.unlp.info.oo2.accesobd;

import java.util.List;
import java.util.Collection;
import java.util.logging.Logger;

public class DatabaseAccessProxy implements DatabaseAccess{
    private DatabaseAccess realSubject; 
    private boolean autenticado = false;
    private static final Logger logger = Logger.getLogger(DatabaseAccessProxy.class.getName());

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
        logger.warning("Acceso autorizado a la base para la inserción de datos");
        return this.realSubject.insertNewRow(rowData);
    }

    @Override 
    public Collection<String> getSearchResults(String queryString) {
        if(!this.isAuthorized()) {
            logger.severe("Intento de acceso no autorizado a la base de datos para la consulta requerida");
            throw new RuntimeException("Usuario no autorizado"); 
        }
        logger.info("Acceso autorizado a la base de datos para la consulta: " + queryString);
        return this.realSubject.getSearchResults(queryString);
    }

    private boolean isAuthorized() {
        return this.autenticado;
    }
}
