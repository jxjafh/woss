package jxlg.xyh.dao;

import java.util.List;

public interface BasicDAO  {
public void save(Object obj);
public void delete(Object obj);
public void Update(Object obj);
public List findByid(String sql,Object []parameters);

public void delete(String sql,Object []parameters);
public void Update(String sql,Object []parameters);
//find总方法
public List find(String sql,Object []parameters);
//分页
public List all(final int pageNumber,final int pageSize,String sql);
}
