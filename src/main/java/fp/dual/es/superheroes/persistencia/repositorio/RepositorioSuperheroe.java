package fp.dual.es.superheroes.persistencia.repositorio;

import java.util.List;

import fp.dual.es.superheroes.persistencia.modelo.Superheroe;

public interface RepositorioSuperheroe {
    Superheroe selectByPrimaryKey(Integer idSuper);

    int insertSelective(Superheroe record);

    int updateByPrimaryKeySelective(Superheroe record);

    int deleteByPrimaryKey(Integer idSuper);

    List<Superheroe> getSuperheroes();
}
