package com.example.springboot_project.domain.test;

import java.util.Map;

public interface TestRepository {

    Long save(Map<String, String> map);
    Map<String, String> findById(Long id);
}
