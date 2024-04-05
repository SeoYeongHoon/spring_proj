package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot240403ApplicationTests {
	@Autowired
	EmpMapper empMapper;

	// 무시하고 싶을 땐 @Test를 주석처리
	// @Test
	void contextLoads() {
	}
	
	// 하나의 메소드를 하나의 케이스로 확인
	@Test
	void empAllList() {
		List<EmpVO> list = empMapper.selectEmpAll();
		assertTrue(!list.isEmpty());
	}
	
//	@Test
//	void empInsert() {
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("Hong");
//		empVO.setEmail("kdHondg@mail.com");
//		empVO.setJobId("IT_PROG");
//		
//		int result = empMapper.insertEmp(empVO);
//		assertEquals(1, result);
//	}
}
