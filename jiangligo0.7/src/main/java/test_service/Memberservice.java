package test_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test_interface.MemberMapper;
import test_pojo.Member;

@Service
public class Memberservice {
	@Autowired
	private MemberMapper memberMapper;

	public List<Member> selectall(int intal, int size) {
		return memberMapper.selectpage(intal, size);
	}

	public int sum() {
		// TODO Auto-generated method stub
		return memberMapper.sum();
	}

	public void changebyid(int id) {
		// TODO Auto-generated method stub
		memberMapper.changebyid(id);
	}

	public Member loginfindname(String name) {
		return memberMapper.loginfindname(name);
	}

	public void insertmember(Member member) {
		memberMapper.insertmember(member);
	}

	public Member loginfindemail(String loginemail) {
		// TODO Auto-generated method stub
		return memberMapper.loginfindemail(loginemail);
	}

	public String findmembername(int id) {
		return memberMapper.findmembername(id);
	}
}
