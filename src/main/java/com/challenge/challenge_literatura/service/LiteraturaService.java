package com.challenge.challenge_literatura.service;

import com.challenge.challenge_literatura.repository.LiteraturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiteraturaService {

    @Autowired
    private LiteraturaRepository literaturaRepository;

}
