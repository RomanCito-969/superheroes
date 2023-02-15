package fp.dual.es.superheroes.persistencia.mapper;

import java.util.List;

import fp.dual.es.superheroes.persistencia.modelo.Superheroe;

public interface SuperheroeMapper {
    int deleteByPrimaryKey(Integer idSuper);

    int insert(Superheroe record);

    int insertSelective(Superheroe record);

    Superheroe selectByPrimaryKey(Integer idSuper);

    int updateByPrimaryKeySelective(Superheroe record);

    int updateByPrimaryKey(Superheroe record);

    List<Superheroe> getSuperheroes();

}