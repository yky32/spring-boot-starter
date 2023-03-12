package com.deloitte.servicename.endpoint;

import com.deloitte.core.exception.BizException;
import com.deloitte.core.response.R;
import com.deloitte.core.response.Result;
import com.deloitte.core.response.SystemResponse;
import com.deloitte.servicename.entity.dto.TestRequestDto;
import com.deloitte.servicename.entity.dto.TestResponseDto;
import com.deloitte.servicename.service.TestService;
import com.deloitte.servicename.usecase.CreateTestUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
@Slf4j
public class ExampleEndpoint {

    private final CreateTestUseCase createTestUseCase;
    private final TestService testService;

    @GetMapping
    public Result<String> test() {
        return R.success("this is ExampleEndpoint");
    }

    @GetMapping("/error")
    public Result<String> error() {
        // if (false); throw
        throw new BizException(SystemResponse.SYS9999);
    }

    @GetMapping("/use-case")
    public Result<String> useCase() {
        return R.success(createTestUseCase.execute());
    }

    @GetMapping("/service")
    public Result<String> service() {
        return R.success(testService.get());
    }

    @PostMapping
    public Result<TestResponseDto> create(@Valid @RequestBody TestRequestDto dto) {
        return R.success(testService.create(dto.getName()));
    }

}
