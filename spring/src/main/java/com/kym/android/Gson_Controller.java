package com.kym.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dto.MemberDTO;

@Controller
public class Gson_Controller {
	Gson gson = new Gson();
	@Autowired @Qualifier("hanul") private SqlSession sql;
	// 로그인 처리를 위한 매핑
	
	@ResponseBody
	@RequestMapping("spr_str")
	public void getAnd_String(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		String param1 =  req.getParameter("param");
		System.out.println("입력받은값" + param1);
		param1 += "Spring에서 다시줌";
		PrintWriter out = res.getWriter();
		out.println(param1);
	}
	
	@ResponseBody
	@RequestMapping("and_login")
	public void and_login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		String aa =  req.getParameter("dto");
		MemberDTO obj =	gson.fromJson(aa,MemberDTO.class );
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", req.getParameter("id"));
		map.put("pw",  req.getParameter("passwd"));
		
		MemberDTO dto = sql.selectOne("member.mapper.and_login", map);

		PrintWriter out = res.getWriter();
		
		String data = gson.toJson(dto);
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
