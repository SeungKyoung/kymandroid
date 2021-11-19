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
public class String_Controller {
	
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
	@RequestMapping("spr_strs")
	public void getAnd_Strings(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		int size = Integer.parseInt(req.getParameter("size")+"" ) ;
		for (int i = 0; i < size; i++) {
			System.out.println("입력받은값" + req.getParameter("param"+i));
		}
		
	}

	
}
