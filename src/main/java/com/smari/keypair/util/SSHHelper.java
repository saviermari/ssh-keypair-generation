package com.smari.keypair.util;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.smari.keypair.model.SSHKeyPairModel;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author smari
 */
public class SSHHelper {
    public static SSHKeyPairModel generateKeyPair(String passPhrase) throws JSchException, IOException {
        JSch jsch = new JSch();
        KeyPair pair = KeyPair.genKeyPair(jsch, KeyPair.RSA);
        OutputStream privKeyStream = new ByteArrayOutputStream(2048);
        OutputStream pubKeyStream = new ByteArrayOutputStream(2048);
        pair.writePublicKey(pubKeyStream,null);
        if (null == passPhrase || passPhrase.isEmpty()) {
            passPhrase = "default";
        }
        pair.writePrivateKey(privKeyStream, passPhrase.getBytes());

        SSHKeyPairModel keyPairModel = new SSHKeyPairModel();
        keyPairModel.setPassPhrase(passPhrase);
        keyPairModel.setPrivateKey(privKeyStream.toString());
        keyPairModel.setPublicKey(pubKeyStream.toString());
        return keyPairModel;
    }
}
