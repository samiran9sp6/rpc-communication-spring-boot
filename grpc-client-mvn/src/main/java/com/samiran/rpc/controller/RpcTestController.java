package com.samiran.rpc.controller;

import com.google.protobuf.Descriptors;
import com.samiran.rpc.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/test")
public class RpcTestController {

    @Autowired
    private BookAuthorService bookAuthorService;
    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable int id){
        return bookAuthorService.getAuthor(id);
    }
}
