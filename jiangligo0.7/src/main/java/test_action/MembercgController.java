package test_action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test_service.Membercgservice;

@Controller
@RequestMapping("/membercg")
public class MembercgController {

	@Autowired
	private Membercgservice membercgService;
	
	@RequestMapping("/del")
	public String del(int id){
		membercgService.del(id);
		return "forward:/goods/collection.do";
	}
}
