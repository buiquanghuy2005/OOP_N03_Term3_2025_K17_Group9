package com.example.servingwebcontent.manager;

import com.example.servingwebcontent.model.DoiBong;
import com.example.servingwebcontent.repository.DoiBongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DoiBongService {

    @Autowired
    private DoiBongRepository doiBongRepository;

    public DoiBong getDoiBong() {
        return doiBongRepository.findAll().stream().findFirst().orElse(null);
    }

    public void save(DoiBong doiBong) {
        doiBongRepository.save(doiBong);
    }
}
