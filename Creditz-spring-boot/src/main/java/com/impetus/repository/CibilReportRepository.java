package com.impetus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.impetus.model.CibilReport;;

/**
 * Repository to fetch data from CIBIL Records
 */
@Repository
public interface CibilReportRepository extends JpaRepository<CibilReport, String> {

	/**
	 * Select data from the CIBIL report using pan card as primary key
	 * 
	 * @param panCard Applicants pan card
	 */
	@Query("SELECT cr FROM cibil_Report cr WHERE cr.panCard = :panCard")
	CibilReport findByPanCard(String panCard);

}
