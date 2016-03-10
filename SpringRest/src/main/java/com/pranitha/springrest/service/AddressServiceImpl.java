package com.pranitha.springrest.service;

import com.pranitha.springrest.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by naveen on 2/4/16.
 */
public class AddressServiceImpl implements AddressService {

    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public Address findById(int id) {

        String sql="select * from address where address_id=?";

        return (Address) jdbcTemplate.queryForObject(sql, new Object[]{id}, new AddressMapper());
    }

    public void saveAddress(Address address) {

        String sql = "insert into address(address_id,customer_id,city,state,zipcode) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{address.getAddressId(), address.getCustomerId(), address.getCity(), address.getState(),address.getZipcode()});


    }

    public Address updateAddress(Address address) {

        String sql = "update address SET city = ? where address_id = ?";
        jdbcTemplate.update(sql,new Object[]{address.getCity() ,address.getCustomerId()});
        return address;
    }

    public void deleteAddressById(int id) {

        String sql = "delete from address where customer_id = ? ";
        jdbcTemplate.update(sql, new Object[]{id});


    }

    public List<Address> findAllAddress() {

            String sql = "select * from address";
            return jdbcTemplate.query(sql,new AddressMapper());
        }

    public boolean isAddressExist(Address address) {

        return false;
    }



    public static final class AddressMapper implements RowMapper{

        public Address mapRow(ResultSet resultSet, int i) throws SQLException {

            Address address = new Address();

            address.setAddressId(resultSet.getInt("address_id"));
            address.setCustomerId(resultSet.getInt("customer_id"));
            address.setCity(resultSet.getString("city"));
            address.setState(resultSet.getString("state"));
            address.setZipcode(resultSet.getInt("zipcode"));
            return address;

        }

    }



}
