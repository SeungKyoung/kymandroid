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

import dto.TestDTO;

@Controller
public class Gson_Controller {
	Gson gson = new Gson();
	@Autowired @Qualifier("hanul") private SqlSession sql;
	// 로그인 처리를 위한 매핑
	
	@ResponseBody
	@RequestMapping("spr_gson")
	public void getAnd_String(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		String aa =  req.getParameter("dto");
		TestDTO fromDTO =	gson.fromJson(aa,TestDTO.class );
		System.out.println(fromDTO.getField1() +fromDTO.getField2() + fromDTO.getField3()  
					+"받음"
				);
		TestDTO toDTO = sql.selectOne("test.mapper.gson_dto", fromDTO);
		PrintWriter out = res.getWriter();
		
		String data = gson.toJson(toDTO);
		out.println(data);
	
	}
	@ResponseBody
	@RequestMapping("spr_strs2")
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
