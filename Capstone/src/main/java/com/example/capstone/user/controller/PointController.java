package com.example.capstone.user.controller;

import com.example.capstone.point.db.Point;
import com.example.capstone.point.model.pointdto;
import com.example.capstone.user.Service.UserService;
import com.example.capstone.user.db.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("point")
public class PointController {
    private final UserService userService;

    @PostMapping("")
    public void changePoint(@RequestBody pointdto pointdto){
        UserEntity userEntity =userService.findOneByPhoneNum(pointdto.getPhonenum());
        Point point = userEntity.getPoint();
        point.setCurrentPoint(point.getCurrentPoint()+1000);
        userEntity.setPoint(point);
        userService.save(userEntity);
    }
}

