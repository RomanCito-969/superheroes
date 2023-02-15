package fp.dual.es.superheroes.servicio;

import java.util.List;

import fp.dual.es.superheroes.persistencia.modelo.Superheroe;
import fp.dual.es.superheroes.servicio.excepciones.SuperheroeException;

public interface ServicioSuperheroes {
    Superheroe seleccionarPorId(Integer id) throws SuperheroeException;

    void insertarSuperheroe(Superheroe usuario) throws SuperheroeException;

    void actualizarSuperheroe(Superheroe usuario) throws SuperheroeException;

    int borrarSuperheroe(Integer id);

    List<Superheroe> getSuperheroes();

}
