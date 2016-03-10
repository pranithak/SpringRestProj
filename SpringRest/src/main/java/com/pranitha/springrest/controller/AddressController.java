package com.pranitha.springrest.controller;

import com.pranitha.springrest.model.Address;
import com.pranitha.springrest.service.AddressService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by naveen on 2/4/16.
 */

@RestController
public class AddressController {

  //  private AddressService addressService;

    @Resource(name="addressService")
    private AddressService addressService;;

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/address" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> listAllAddress(){
        List<Address> addressList = addressService.findAllAddress();
        if(addressList.isEmpty()){
            return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);// 204   You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Address>>(addressList, HttpStatus.OK);
    }

    @RequestMapping(value = "/address/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Address> getAddressId(@PathVariable("id") int id){
        System.out.println("Fetching User with id " + id);
        Address user = addressService.findById(id);
        if(user == null)
        {
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);// 404  You many decide to return HttpStatus.NOT_FOUND

        }
        return new ResponseEntity<Address>(user, HttpStatus.OK); // 200

    }


    @RequestMapping(value = "/address" , method = RequestMethod.POST)
    public ResponseEntity<Void> saveAddress(@RequestBody Address address ,  UriComponentsBuilder ucBuilder){

        if (addressService.isAddressExist(address)) {
            System.out.println("A User with name " + address.getAddressId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT); // 409
        }

        addressService.saveAddress(address);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/address/{id}").buildAndExpand(address.getAddressId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED); // 201
    }


    @RequestMapping(value="/address/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable("id") int id , @RequestBody Address user){

        System.out.println("Updating User " + id);

        Address currentAddress = addressService.findById(id);
        if (currentAddress==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }

        currentAddress.setCity(user.getCity());
        currentAddress.setCustomerId(user.getCustomerId());
        currentAddress.setState(user.getState());
        currentAddress.setZipcode(user.getZipcode());

        addressService.updateAddress(currentAddress);

        return new ResponseEntity<Address>(currentAddress, HttpStatus.OK);
    }

    @RequestMapping(value = "/address/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddressById(@PathVariable("id") int id){
        addressService.deleteAddressById(id);
        return new ResponseEntity<Address>(HttpStatus.OK); // 200

    }



}
