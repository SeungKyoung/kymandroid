package com.kym.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.google.gson.reflect.TypeToken;

import dto.TestDTO;

@Controller
public class Gson_Controller {
	Gson gson = new Gson();
	@Autowired @Qualifier("hanul") private SqlSession sql;
	// 로그인 처리를 위한 매핑
	
	@ResponseBody
	@RequestMapping("spr_gson")
	public void get_Gson(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
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
	@RequestMapping("spr_gsonlist")
	public void getGson_List(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		String aa =  req.getParameter("list");
		ArrayList<TestDTO> list= gson.fromJson(aa, new TypeToken<List<TestDTO>>(){}.getType());
		for (TestDTO testDTO : list) {
			System.out.println(testDTO.getField1());
			System.out.println(testDTO.getField2());
			System.out.println(testDTO.getField3());
			System.out.println("받음");
			testDTO.setField1(testDTO.getField1() + "spr");
			testDTO.setField1(testDTO.getField2() + "spr");
			testDTO.setField1(testDTO.getField3() + "spr");
		}
		aa = gson.toJson(list);
		PrintWriter out = res.getWriter();
		
		String data = gson.toJson(aa);
		out.println(data);
		
	}
	

	
}
