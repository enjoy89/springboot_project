package com.example.springboot_project.web.test;

import com.example.springboot_project.service.test.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// RestController 애노테이션 안에 Component 애노테이션이 포함되어 있기 때문에
// 자동으로 빈으로 등록된다.
@RestController
@RequestMapping("/api/latest")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    // Create
    @PostMapping("/test")
    // http://localhost:8080/api/test
    // @RequestBody - 요청을 통해 받아온 객체 정보
    public ResponseEntity<String> create(@RequestBody Map<String, String> map) {
        // map<val1, val2>
        System.out.println("map.val1 = " + map.get("val1"));
        System.out.println("map.val2 = " + map.get("val2"));

        return ResponseEntity.ok("CREATED");
    }

    // Read - 단건 조회
    @GetMapping("/test/{id}")
    // http://localhost:8080/api/test/1
    // @PathVariable - URL에 담긴 요청 변수 정보
    public ResponseEntity<String> read(@PathVariable Long id) {
        System.out.println("id = " + id);

        return ResponseEntity.ok("hello world knu!");
    }

    // Update
    @PutMapping("/test/{id}")
    // http://localhost:8080/api/test/1
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Map<String, String> map) {
        System.out.println("id = " + id);
        System.out.println("map.val1 = " + map.get("val1"));
        System.out.println("map.val2 = " + map.get("val2"));

        return ResponseEntity.ok("UPDATED");
    }

    // Delete
    @DeleteMapping("test/{id}")
    // http://localhost:8080/api/test/1
    public ResponseEntity<String> delete(@PathVariable Long id) {
        System.out.println("id = " + id);

        return ResponseEntity.ok("DELETED");
    }



}
