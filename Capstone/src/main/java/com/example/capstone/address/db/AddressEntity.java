package com.example.capstone.address.db;

import com.example.capstone.useraddress.db.UserAddress;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id",nullable = false,unique = true)
    private Long addressId;

    @Column(name = "nickname",nullable = false)
    private String nickname;

    @Column(name = "zipcode",nullable = false)
    private String zipcode;

    @Column(name = "address1",nullable = false)
    private String address1;

    @Column(name = "address2",nullable = false)
    private String address2;

    @Column(name = "address3",nullable = false)
    private String address3;

    @Column(name = "address4",nullable = false)
    private String address4;

    @Column(name = "address5",nullable = false)
    private String address5;



    @OneToMany(mappedBy = "addressEntity", fetch = FetchType.LAZY)
    private List<UserAddress> userAddressList = new ArrayList<>();

    public void addUserAddress(UserAddress userAddress) {
        this.userAddressList.add(userAddress);
        if (userAddress.getAddressEntity() != this) {
            userAddress.setAddressEntity(this);
        }
    }

}
