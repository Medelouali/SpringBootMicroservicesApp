package com.ensa.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("FRAUD")
public interface FeignClientInterface {
    @RequestMapping(path = "api/v1/frauds/flagged", method = RequestMethod.GET)
    public List<String> getFlagged();

    @RequestMapping(path = "api/v1/frauds/unflagged", method = RequestMethod.GET)
    public List<String> getUnflagged();

    @RequestMapping(path = "api/v1/frauds/flag/{customerId}", method = RequestMethod.GET)
    public FlagFraudResponse flagClient(@PathVariable("customerId") String customerId);
}
