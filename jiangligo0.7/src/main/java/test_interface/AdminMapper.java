package test_interface;

import java.util.List;

import test_pojo.Admin;


public interface AdminMapper {
void insert(Admin admin);
void delete(int id);
void update(Admin admin);
Admin selectByID(Admin admin);
List selectpage(final int begin,final int size);
void insertbyid(Admin admin);
}
