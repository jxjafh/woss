package test_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.AdminMapper;
import test_pojo.Admin;
@Service
public class Adminservice {
	
@Autowired
private AdminMapper adminMapper;

public void insert(Admin admin){
	System.out.println("Userservice");
	adminMapper.insert(admin);
}

}
