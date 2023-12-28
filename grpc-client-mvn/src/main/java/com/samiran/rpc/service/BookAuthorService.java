package com.samiran.rpc.service;

import com.google.protobuf.Descriptors;
import com.samiran.rpc.Author;
import com.samiran.rpc.BookAuthorServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookAuthorService {
//    @Autowired
    @GrpcClient("book-author-rpc")
    private BookAuthorServiceGrpc.BookAuthorServiceBlockingStub bookAuthorServiceImplBase;

    public Map<Descriptors.FieldDescriptor, Object> getAuthor(int id){
        Author authorRequest = Author.newBuilder().setAuthorId(id).build();
        return bookAuthorServiceImplBase.getAuthor(authorRequest).getAllFields();
    }
}
