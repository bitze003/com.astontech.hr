package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

public interface AddressService {
    Iterable<Address> listAllAddress();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    Iterable<Address> saveAddressList(Iterable<Address> addressIterable);

    void deleteAddress(Integer id);
}
