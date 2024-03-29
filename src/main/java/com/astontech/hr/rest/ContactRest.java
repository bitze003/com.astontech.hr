package com.astontech.hr.rest;

import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.AddressService;
import com.astontech.hr.services.ContactService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")

public class ContactRest {

    private Logger log = Logger.getLogger(ContactRest.class);

    @Autowired
    private AddressService addressService;
    @Autowired
    private ContactService contactService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public Iterable<Contact> getAll(){
        return contactService.listAllContacts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getById(@PathVariable int id){
        return contactService.getContactById(id);
    }

    @RequestMapping(value= "/", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact contact) {
        System.out.println("save");
        System.out.println(contact.toString());
        addressService.saveAddress(contact.getAddress());

        return contactService.saveContact(contact);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id ) {
        boolean result = false;
        try {
            contactService.deleteContact(id);
            result = true;
        } catch (Exception ex) {
            log.info(ex);
        }
        System.out.println("delete");
        return result;
    }
}
