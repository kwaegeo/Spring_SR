package com.NoChu.service;

import com.NoChu.controller.Api.Crawling;
import com.NoChu.dto.Chart;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class chartService {

    @Autowired
    private Crawling crawling;

    public List<Chart> 국십(){

        return crawling.목록();
    }
}
