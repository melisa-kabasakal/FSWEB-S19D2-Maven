package com.workintech.s18d4.dao;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository <Address, Long>{

}
