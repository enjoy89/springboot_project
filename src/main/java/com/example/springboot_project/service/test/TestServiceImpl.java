package com.example.springboot_project.service.test;

import com.example.springboot_project.domain.test.TestRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    //
    @Override
    public Long joinTest(Map<String, String> map) {
        return testRepository.save(map);
    }

    @Override
    public Map<String, String> findTestById(Long id) {
        return testRepository.findById(id);
    }
}
