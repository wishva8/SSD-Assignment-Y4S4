package com.ihub.janus.app.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ihub.janus.app.config.Constants;
import com.ihub.janus.app.service.MessageService;
import com.ihub.janus.app.service.UserService;
import com.ihub.janus.data.entity.Message;
import com.ihub.janus.data.entity.User;
import com.ihub.janus.data.view.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.*;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/message")
public class MessageController {

    /** The user service. */
    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/", headers = Constants.ApiVersion.V1)
    @JsonView(Views.Role.class)
    public ResponseEntity<Message> create(@Valid @RequestBody Message message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        Base64.Encoder encoder = Base64.getMimeEncoder();
        String str =  message.getDescription();
        String encodeString  =  encoder.encodeToString(str.getBytes());

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();
        //Getting the private key from the key pair
        PrivateKey privKey = pair.getPrivate();

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        //Initialize the signature
        sign.initSign(privKey);
        byte[] bytes = "msg".getBytes();

        //Adding data to the signature
        sign.update(bytes);


        //Calculating the signature
        byte[] signature = sign.sign();
        String digitalSign = signature.toString();
        message.setDigitalSign(digitalSign);
        message.setDescription(encodeString);
        Message obj = messageService.create(message);

        return new ResponseEntity<Message>(obj, HttpStatus.OK);
    }

    @JsonView(Views.Message.class)
    @GetMapping(value = "/", headers = Constants.ApiVersion.V1)
    public ResponseEntity<List<Message>> getAll() {

        Base64.Decoder decoder = Base64.getDecoder();

        List<Message> obj = messageService.getAll();
        return new ResponseEntity<List<Message>>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", headers = Constants.ApiVersion.V1)
    public ResponseEntity<Void> delete(@PathVariable("id") @RequestParam Long id) {


        messageService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
