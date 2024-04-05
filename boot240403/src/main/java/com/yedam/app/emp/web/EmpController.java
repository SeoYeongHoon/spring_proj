package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	// GET  : 조회, (등록용)빈페이지
	// POST : 데이터 조작(등록, 수정, 삭제)
	
	// 전체 조회
	@GetMapping("empList")
	public String empList(Model model) { // Model: Request + Response
		List<EmpVO> list = empService.empList();	// 1. 해당 기능 수행 Service
		model.addAttribute("empList", list);		// 2. 클라이언트에 전달할 데이터 담기
		return "emp/list";							// 3. 데이터를 출력할 페이지 선택
		// prefix: classpath:/templates/
		// subfix: .html
	}
	
	// 단건 조회
	@GetMapping("empInfo")	// Command 객체: QueryString
	public String empInfo(EmpVO empVo, Model model) {
		EmpVO infoVO = empService.empInfo(empVo);
		model.addAttribute("empInfo", infoVO);
		return "emp/info";
	}
	
	// 등록(페이지): GET
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "emp/insert";
	}
	
	// 등록(처리): POST
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eId = empService.empInsert(empVO);
		String uri = null;
		if (eId > -1) {
			uri = "redirect:empInfo?employeeId=" + eId;
		} else {
			uri = "empList";
		}
		return uri;
	}
}
