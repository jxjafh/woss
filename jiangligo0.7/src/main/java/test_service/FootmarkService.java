package test_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.FootmarkMapper;
import test_pojo.Footmark;

@Service
public class FootmarkService {

	@Autowired
	public FootmarkMapper footmarkMapper;
	
	public List<Footmark> list(int member_id){
		return footmarkMapper.selectByMemberId(member_id);
	}
}
