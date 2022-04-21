package com.rns.interview.task.rest;

import com.rns.interview.task.service.FileParseService;
import com.rns.interview.task.service.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private TireRepository repository;
    private FileParseService fileParseService;

    @Autowired
    public ApiController(FileParseService fileParseService, TireRepository repository) {
        this.fileParseService = fileParseService;
        this.repository = repository;
    }

    @Transactional
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void submit(@RequestParam("file") MultipartFile file) throws IOException {
        repository.saveAll(fileParseService.process(file.getInputStream()));
    }
}
