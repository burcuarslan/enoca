package com.example.enoca.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) // aynı isimde birden fazla field varsa hata vermesin
                .setMatchingStrategy(MatchingStrategies.LOOSE); // responsta her şeyi maplemese de olur

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD); // requestte her şeyi maplemeli
        return this.modelMapper;
    }
}
