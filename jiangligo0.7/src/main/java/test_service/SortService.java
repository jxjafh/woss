package test_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.SortMapper;
import test_pojo.Sort;

@Service
public class SortService {
	
@Autowired
private SortMapper sortMapper;

public List<Sort> mainpage(){
	return sortMapper.mainpage();
}
public List<Sort> listSort(){
	return sortMapper.selectAll();
}

public Sort findSort(int id){
	return sortMapper.selectByParamaryKey(id);
}
}
