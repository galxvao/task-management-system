package com.senai.task.services;

import com.senai.task.dtos.MessageDto;
import com.senai.task.dtos.UserDto;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class UserService {

    @Autowired
    UserRepository repository;

    public MessageDto criarUsuario(UserDto userDto) {

        MessageDto messageDto = new MessageDto();
        UserModel user = new UserModel();

        Optional<UserModel> userOptional = repository.findByEmail(userDto.getEmail());
        messageDto.setSucesso(false);
        messageDto.setMensagem("Usuário já existente");

        if (userOptional.isEmpty()) {

            user.setNome(userDto.getNome());
            user.setEmail(userDto.getEmail());

            messageDto.setSucesso(true);
            messageDto.setMensagem("Usuário criado com sucesso!");

            repository.save(user);

            return messageDto;
        }


        return messageDto;
    }

    public MessageDto atualizarUsuario (UserDto usuarioAtualizar, String email){

        Optional<UserModel> usuarioOptional = repository.findByEmail(email);

        MessageDto mensagem = new MessageDto();

        mensagem.setMensagem("Usuário não encontrado.");
        mensagem.setSucesso(false);

        UserModel usuarioModel =  usuarioOptional.get();

        if(usuarioModel.getEmail().equals(usuarioAtualizar.getEmail())){

            usuarioModel.setNome(usuarioAtualizar.getNome());
            usuarioModel.setEmail(usuarioAtualizar.getEmail());

            repository.save(usuarioModel);

            mensagem.setSucesso(true);
            mensagem.setMensagem("Usuário atualizado com sucesso!");
        }

        return mensagem;

    }







}
