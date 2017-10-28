package test_action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test_pojo.Sort;
import test_service.SortService;

@Controller
@RequestMapping("sort")
public class SortController {

	@Autowired
	private SortService sortService;
	
	@RequestMapping("list")
	@ResponseBody
	public List<Sort> listSort(){
		return sortService.listSort();
	}
	
}
