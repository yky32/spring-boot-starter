package com.deloitte.servicename.service;

import com.deloitte.core.exception.BizException;
import com.deloitte.core.response.SystemResponse;
import com.deloitte.servicename.entity.dto.TestResponseDto;
import com.deloitte.servicename.entity.po.Test;
import com.deloitte.servicename.repository.TestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public String get() {
        return "this is A's service layer";
    }

    public TestResponseDto create(String name) {
        Test test = Test.builder()
                .test(name)
                .build();
        test = testRepository.save(test);
        return TestResponseDto.builder()
                .anotherValue(test.getTest())
                .build();
    }
}
