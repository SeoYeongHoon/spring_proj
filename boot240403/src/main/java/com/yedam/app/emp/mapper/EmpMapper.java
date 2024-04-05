package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectEmpAll();
	
	// 단건조회
	public EmpVO selectEmp(EmpVO empVO);
	
	// 등록
	public int insertEmp(EmpVO empVO);
	
	// 수정
	public int updateEmp(EmpVO empVO);
	
	// 삭제
	public int deleteEmp(@Param("eid") int employeeId);	
	// @Param("문자"): 매퍼 xml 파일에서 사용되는 #{문자}
	// ex) updateEmp(@Param("emp") EmpVO empVO) 일 시, xml에서는 #{emp.lastName} 이런 식으로 사용
}
