package com.ensa.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/frauds")
@AllArgsConstructor
public class FraudController {
    private final FraudService fraudService;

    @RequestMapping(path = "flagged", method = RequestMethod.GET)
    public List<String> getFlagged(){
        return this.fraudService.getFlagged();
    }

    @RequestMapping(path = "unflagged", method = RequestMethod.GET)
    public List<String> getUnflagged(){
        return this.fraudService.getUnflagged();
    }

    @RequestMapping(method = RequestMethod.GET, path = "flag/{customerId}")
    public FlagFraudResponse flagClient(@PathVariable("customerId") String customerId){
        return this.fraudService.flagClient(customerId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{customerId}")
    public boolean isFraud(@PathVariable("customerId") String customerId){
        return this.fraudService.isFraud(customerId);
    }


}
