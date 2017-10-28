package test_interface;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import test_pojo.Comment;


public interface CommentMapper {
void insert(Comment comment);
void delete(int id);
void update(Comment comment);
Comment selectByID(Comment comment);
List selectpage(final int begin,final int size);
void insertbyid(Comment comment);
}
