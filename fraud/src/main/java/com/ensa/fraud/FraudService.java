package com.ensa.fraud;

import ch.qos.logback.core.net.server.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;


    public boolean isFraud(String customerId) {
        return false;
    }

    public FlagFraudResponse flagClient(String customerId){
        Fraud fraud=Fraud.builder()
                .isFraudulent(false).id(customerId)
                .build();
        this.fraudRepository.save(fraud);
        return new FlagFraudResponse(customerId);
    }

    public List<String> getFlagged(){
        return this.fraudRepository.findAll().stream().filter(Fraud::isFraudulent)
                .toList()
                .stream().map(Fraud::getId).collect(Collectors.toList());
    }

    public List<String> getUnflagged(){
        return this.fraudRepository.findAll().stream().filter(fraud -> !fraud.isFraudulent())
                .toList()
                .stream().map(Fraud::getId).collect(Collectors.toList());
    }
}
