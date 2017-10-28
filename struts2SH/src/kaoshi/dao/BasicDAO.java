package kaoshi.dao;

import java.util.List;

public interface BasicDAO {
 void create(Object o);
 void update(Object o);
 void delete(Object o);
 List findByid(final Integer id,final String hql);
 List findAll(Object o);
 List load(Class clazz);
 List findByAtt(String sql,Object []parameters);
//·ÖÒ³
public List all(final int pageNumber,final int pageSize,String sql);
}
