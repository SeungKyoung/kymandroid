package com.kym.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import vo.MemberVO;

@Controller
public class Android_Controller {
	
	@Autowired @Qualifier("hanul") private SqlSession sql;
	// 로그인 처리를 위한 매핑
	@ResponseBody
	@RequestMapping("and_login")
	public void and_login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", req.getParameter("id"));
		map.put("pw",  req.getParameter("passwd"));
		
		MemberVO vo = sql.selectOne("member.mapper.and_login", map);

		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		String data = gson.toJson(vo);
		out.println(data);
	}

	@ResponseBody
	@RequestMapping("and_join")
	public void and_join(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		res.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html");
//		req.setCharacterEncoding("UTF-8");
//
//		MemberDTO vo = new MemberDTO(req.getParameter("id"), req.getParameter("passwd"), req.getParameter("name"),
//				req.getParameter("phonenumber"), req.getParameter("address"));
//
//		ConnJDBC connJDBC = new ConnJDBC();
//		int result = connJDBC.test_join(vo);
//
//		PrintWriter out = res.getWriter();
//		Gson gson = new Gson();
//		String data = gson.toJson(result);
//		out.println(data);
	}

	
}
