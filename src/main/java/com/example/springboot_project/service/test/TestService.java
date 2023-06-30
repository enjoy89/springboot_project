package com.example.springboot_project.service.test;

import java.util.Map;

public interface TestService {

    // 테스트 생성 - Create
    Long joinTest(Map<String, String> map);

    // 테스트 단건 조회 - Read
    Map<String, String> findTestById(Long id);
}
