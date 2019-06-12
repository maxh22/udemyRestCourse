package com.valtech.university.udemyrestcourse.service.impl;

import com.valtech.university.udemyrestcourse.UserRepository;
import com.valtech.university.udemyrestcourse.io.entity.UserEntity;
import com.valtech.university.udemyrestcourse.service.UserService;
import com.valtech.university.udemyrestcourse.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setUserId("testUserId");
        userEntity.setEncryptedPassword("testEncryptedPassword");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}