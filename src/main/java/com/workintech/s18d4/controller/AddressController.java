package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.save(address);
    }
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        address.setId(id);
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public Address deleteAddress(@PathVariable Long id) {
        return addressService.delete(id);
    }
}
