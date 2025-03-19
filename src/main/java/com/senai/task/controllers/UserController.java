package com.senai.task.controllers;

import com.senai.task.dtos.MessageDto;
import com.senai.task.dtos.UserDto;
import com.senai.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public ResponseEntity<MessageDto> criarUsuario (@RequestBody UserDto userDto){

        MessageDto messageDto = service.criarUsuario(userDto);

        if(messageDto.isSucesso()){
            return ResponseEntity.ok().body(messageDto);
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(messageDto);
        }

    }
    @PutMapping("user/{email}")
    public ResponseEntity<MessageDto> atualizarUsuario (@PathVariable String email, @RequestBody UserDto userDto){

        MessageDto mensagem = service.atualizarUsuario(userDto, email);

        if(mensagem.isSucesso()){
            return ResponseEntity.ok().body(mensagem);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }

    }





}
