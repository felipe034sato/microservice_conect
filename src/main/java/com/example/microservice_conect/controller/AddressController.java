package com.example.microservice_conect.controller;

import com.example.microservice_conect.model.Address;
import com.example.microservice_conect.model.AddressResponse;
import com.example.microservice_conect.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value ="{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressResponse> findById(@PathVariable("employeeId") Long id) {
        AddressResponse addressResponse = null;

        addressResponse = addressService.findAddressByEmployeeId(id);

        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

}
