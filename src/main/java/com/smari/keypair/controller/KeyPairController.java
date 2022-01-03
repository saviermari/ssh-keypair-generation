package com.smari.keypair.controller;

import com.jcraft.jsch.JSchException;
import com.smari.keypair.model.SSHKeyPairModel;
import com.smari.keypair.service.KeyPairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/rest/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class KeyPairController {
    @Autowired
    private KeyPairService service;

    @PostMapping
    @RequestMapping("/keyPairs")
    public SSHKeyPairModel createKeyPair(@RequestBody SSHKeyPairModel model) throws JSchException, IOException {
        return service.createKeyPair(model.getPassPhrase());
    }
}
