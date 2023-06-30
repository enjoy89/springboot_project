package com.example.springboot_project.domain.test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryTestRepository implements TestRepository {

    // 빈으로 등록될 필요가 없기 때문에 바로 객체 생성
    private final List<Map<String, String>> collectors = new ArrayList<>();

    @Override
    public Long save(Map<String, String> map) {
        // val1 = id
        // val2 = name
        collectors.add(map);
        return Long.valueOf(map.get("val1"));
    }

    @Override
    public Map<String, String> findById(Long id) {
        return collectors.get(id.intValue() - 1);
    }
}
