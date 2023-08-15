package com.example.capstone.user.db;

import com.example.capstone.model.BaseEntity;
import com.example.capstone.point.db.Point;
import com.example.capstone.useraddress.db.UserAddress;
import lombok.*;

import javax.persistence.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "usertable")
public class UserEntity extends BaseEntity implements Principal {
    @Id
    @Column(name = "phonenum", nullable = false, unique = true)
    private String phonenum;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_phonenum"))
    @Column(name = "roles")
    private List<String> roles = new ArrayList<>();

    @Lob
    @Column(name = "profile", nullable = true, unique = false)
    private byte[] profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_state",nullable = false)
    private UserStates userStates = UserStates.MEMBER_ACTIVE;


    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<UserAddress> userAddressList = new ArrayList<>();

    @OneToOne(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Point point;

    public UserEntity(String email) {
        this.email = email;
    }

    public enum  UserStates{
            MEMBER_ACTIVE("활동중"),
            MEMBER_SLEEP("휴면 상태"),
            MEMBER_QUIT("탈퇴 상태");

            @Getter
            private String status;

            UserStates(String status) {
                this.status = status;
            }

    }

    public void addPoint(Point point){
        this.point = point;
        if(point.getUserEntity()!=this){
            point.setUserEntity(this);
        }
    }

    public void addUserAddress(UserAddress userAddress) {
        this.userAddressList.add(userAddress);
        if (userAddress.getUserEntity() != this) {
            userAddress.setUserEntity(this);
        }
    }
    public enum UserEntityRole{
        ROLE_USER,
        ROLE_ADMIN
    }

}
