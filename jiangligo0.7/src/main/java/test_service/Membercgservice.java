package test_service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.MembercgMapper;
import test_pojo.Membercg;
@Service
public class Membercgservice {
@Autowired
	private MembercgMapper membercgMapper;
	
public List<Membercg> selectbymeid(int memberid){
	return membercgMapper.selectbymeid(memberid);
}

public void cginsert(int member_id,int goods_id){
	membercgMapper.insert(member_id, goods_id);
}
public void del(int id){
	membercgMapper.delete(id);
}
}
