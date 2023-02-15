package fp.dual.es.superheroes.persistencia.repositorio.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fp.dual.es.superheroes.persistencia.mapper.SuperheroeMapper;
import fp.dual.es.superheroes.persistencia.modelo.Superheroe;
import fp.dual.es.superheroes.persistencia.repositorio.RepositorioSuperheroe;

@Repository
public class RepositorioSuperheroImpl implements RepositorioSuperheroe {

    private SuperheroeMapper mapper;

    public RepositorioSuperheroImpl(SuperheroeMapper superheroeMapper) {
        this.mapper = superheroeMapper;
    }

    @Override
    public Superheroe selectByPrimaryKey(Integer idSuper) {
        return this.mapper.selectByPrimaryKey(idSuper);
    }

    @Override
    public int insertSelective(Superheroe record) {
        return this.mapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Superheroe record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer idSuper) {
        return this.mapper.deleteByPrimaryKey(idSuper);
    }

    @Override
    public List<Superheroe> getSuperheroes() {

        return this.mapper.getSuperheroes();
    }

}
