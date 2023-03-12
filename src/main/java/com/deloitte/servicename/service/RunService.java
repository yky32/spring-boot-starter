package com.deloitte.servicename.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RunService {

    public String get() {
        return "this is B's service layer";
    }
}
