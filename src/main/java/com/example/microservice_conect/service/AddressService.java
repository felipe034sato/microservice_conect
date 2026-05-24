package com.example.microservice_conect.service;

import com.example.microservice_conect.model.Address;
import com.example.microservice_conect.model.AddressResponse;
import com.example.microservice_conect.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(Long employeeId) {
        Address address = addressRepository.findAddressById(employeeId);
        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
        return addressResponse;
    }

    public Address create(Address address){
        return addressRepository.save(address);
    }
}
