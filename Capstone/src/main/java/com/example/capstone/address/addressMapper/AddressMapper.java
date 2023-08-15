package com.example.capstone.address.addressMapper;

import com.example.capstone.address.db.AddressEntity;
import com.example.capstone.address.model.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressEntity AddressDtoToAddressEntity(AddressDto addressDto);
}
