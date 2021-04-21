package com.barney.wonderlabzdeveloperassessmentcore.convertors;

import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 23:02
 */
@Component
public class CustomerDTOConvertor implements Converter<CustomerDTO, Customer> {

    @Override
    public Customer convert(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(customerDTO, Customer.class);
    }
}
