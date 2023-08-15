package com.example.capstone.useraddress.db;

import com.example.capstone.address.db.AddressEntity;
import com.example.capstone.user.db.UserEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "user_address")
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_address_id",nullable = false,unique = true)
    private Long userAddressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ua_address_id",nullable = false)
    private AddressEntity addressEntity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ua_phonenum",nullable = false)
    private UserEntity userEntity;

//    public void addAddress(AddressEntity addressEntity) {
//        this.addressEntity = addressEntity;
//        if (!this.addressEntity.getUserAddressList().contains(this)) {
//            this.addressEntity.getUserAddressList().add(this);
//        }
//    }


}
