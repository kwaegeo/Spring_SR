package com.NoChu.service;

import com.NoChu.dto.Chart;
import com.NoChu.service.API_service.Crawling;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class chartService {

    @Autowired
    private Crawling crawling;

    public List<Chart> crawl(){

        return crawling.kpop십곡();
    }
}
