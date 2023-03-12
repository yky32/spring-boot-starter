package com.deloitte.servicename.repository;

import com.deloitte.servicename.entity.po.Test;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepositoryImplementation<Test, Long> {
}