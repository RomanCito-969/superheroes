package fp.dual.es.superheroes.servicio.excepciones;

@SuppressWarnings("serial")
public class SuperheroeException extends Exception {
    public SuperheroeException() {
    }

    public SuperheroeException(String mensajeError) {
        super(mensajeError);
    }
}