package com.example.capstone.useraddress.db;

import com.example.capstone.useraddress.db.UserAddress;
import com.example.capstone.useraddress.model.UserAddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {

    @Query("SELECT new com.example.capstone.useraddress.model.UserAddressDTO(u.name, u.nickname, u.phonenum, u.profile, a.nickname, a.zipcode, a.address1, a.address2, a.address3, a.address4, a.address5) " +
            "FROM user_address ua " +
            "JOIN ua.userEntity u " +
            "JOIN ua.addressEntity a " +
            "WHERE u.phonenum = :phonenum")
    List<UserAddressDTO> findByUserEntityPhonenum(@Param("phonenum") String phonenum);
}
