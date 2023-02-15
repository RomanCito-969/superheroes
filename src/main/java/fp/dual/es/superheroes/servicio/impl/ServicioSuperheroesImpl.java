package fp.dual.es.superheroes.servicio.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fp.dual.es.superheroes.persistencia.modelo.Superheroe;
import fp.dual.es.superheroes.persistencia.repositorio.RepositorioSuperheroe;
import fp.dual.es.superheroes.servicio.ServicioSuperheroes;
import fp.dual.es.superheroes.servicio.excepciones.SuperheroeException;

@Service
@Transactional
public class ServicioSuperheroesImpl implements ServicioSuperheroes {

    private RepositorioSuperheroe repositorio;

    public ServicioSuperheroesImpl(RepositorioSuperheroe repositorioSuperheroe) {
        super();
        this.repositorio = repositorioSuperheroe;
    }

    @Override
    public Superheroe seleccionarPorId(Integer id) throws SuperheroeException {
        try {
            Superheroe superheroe = this.repositorio.selectByPrimaryKey(id);
            return superheroe;
        } catch (EmptyResultDataAccessException e) {
            throw new SuperheroeException("No se ha encontreda superheroe.");
        }

    }

    @Override
    public void insertarSuperheroe(Superheroe superheroe) throws SuperheroeException {
        try {
            Superheroe superheroeExiste = this.repositorio.selectByPrimaryKey(superheroe.getIdSuper());
            if (superheroeExiste != null) {
                throw new SuperheroeException("Ya existe un superhéroe con "
                        + "el identificador " + superheroe.getIdSuper());
            }
        } catch (EmptyResultDataAccessException e) {
            throw new SuperheroeException("");
        }

    }

    @Override
    public void actualizarSuperheroe(Superheroe usuario) throws SuperheroeException {

        this.repositorio.updateByPrimaryKeySelective(usuario);
    }

    @Override
    public int borrarSuperheroe(Integer id) {
        return this.repositorio.deleteByPrimaryKey(id);
    }

    @Override
    public List<Superheroe> getSuperheroes() {
        return this.repositorio.getSuperheroes();
    }

}
