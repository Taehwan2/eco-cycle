package com.example.capstone.point.db;

import com.example.capstone.user.db.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "point")
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id",nullable = false,unique = true)
    private long pointId;

    @Column(name = "current_points", nullable = true)
    private String currentPoint;

    @Column(name = "accumulated_points",nullable = false)
    private String accumulatedPoints;

    @OneToOne
    @JoinColumn(name = "phonenum")
    private UserEntity userEntity;

    public Point(String currentPoint, String accumulatedPoints, UserEntity userEntity) {
        this.currentPoint = currentPoint;
        this.accumulatedPoints = accumulatedPoints;
        this.userEntity = userEntity;
    }

    public void addUser(UserEntity userEntity){
        this.userEntity = userEntity;
        if(userEntity.getPoint()!=this){
            userEntity.setPoint(this);
        }
    }
}
