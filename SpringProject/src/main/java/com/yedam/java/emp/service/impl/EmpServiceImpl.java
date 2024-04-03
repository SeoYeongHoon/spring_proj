package com.yedam.java.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	// 필드 주입 방식
	@Autowired
	EmpMapper empMapper;

//	생성자 주입 방식(안정적임)
//  @Autowired
//	public EmpServiceImpl(EmpMapper empMapper) {
//		this.empMapper = empMapper;
//	}

	@Override
	public List<EmpVO> empAllList() {
		return empMapper.selectEmpAll();
	}

}
