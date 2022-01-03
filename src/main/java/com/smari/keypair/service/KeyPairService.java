package com.smari.keypair.service;

import com.jcraft.jsch.JSchException;
import com.smari.keypair.model.SSHKeyPairModel;

import java.io.IOException;

/**
 * @author smari
 */
public interface KeyPairService {
    public SSHKeyPairModel createKeyPair(String passPhrase) throws JSchException, IOException;
}
