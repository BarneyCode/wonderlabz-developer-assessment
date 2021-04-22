package com.barney.wonderlabzdeveloperassessmentcore.convertors;

import com.barney.wonderlabzdeveloperassessmentcore.models.Customer;
import com.barney.wonderlabzdeveloperassessmentcore.models.Transaction;
import com.barney.wonderlabzdeveloperassessmentcore.models.dto.TransactionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 22/4/2021
 * Time        : 00:52
 */
@Component
public class TransactionDTOConvertor  implements Converter<TransactionDTO, Transaction> {
    @Override
    public Transaction convert(TransactionDTO transactionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(transactionDTO, Transaction.class);
    }
}
