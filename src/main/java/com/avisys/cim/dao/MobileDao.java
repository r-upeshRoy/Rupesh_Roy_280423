package com.avisys.cim.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avisys.cim.MobileNumber;

public interface MobileDao extends JpaRepository<MobileNumber, Long> {
	


}
