package com.hmp.userservice.service;

import com.hmp.userservice.VO.Department;
import com.hmp.userservice.VO.ResponseTemplateVO;
import com.hmp.userservice.entity.User;
import com.hmp.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("Inside of saveUser of UserService");
        return userRepository.save(user);
    }
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside of getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
       // Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(),Department.class);
       //it enables you can run on any port
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+
                        user.getDepartmentId(),
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
