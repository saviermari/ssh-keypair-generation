package com.smari.keypair.service;

import com.jcraft.jsch.JSchException;
import com.smari.keypair.model.SSHKeyPairModel;
import com.smari.keypair.util.SSHHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KeyPairServiceImpl implements KeyPairService{
    @Override
    public SSHKeyPairModel createKeyPair(String passPhrase) throws JSchException, IOException {
        return  SSHHelper.generateKeyPair(passPhrase);
    }
}
