package com.senai.task.services;

import com.senai.task.dtos.MessageDto;
import com.senai.task.dtos.UserDto;
import com.senai.task.models.UserModel;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    public List<UserDto> listarUsuarios(){

        List<UserDto> listaUserDto = new ArrayList<>();

        List<UserModel> listaUserModel = repository.findAll();

        for (UserModel userModel : listaUserModel){

            UserDto userDto = new UserDto();

            userDto.setNome(userModel.getNome());
            userDto.setEmail(userModel.getEmail());

            listaUserDto.add(userDto);

        }

        return listaUserDto;

    }

    public MessageDto excluirUsuario (String email){

        List<UserModel> listaUserModel = repository.findAll();

        MessageDto messageDto = new MessageDto();
        messageDto.setSucesso(false);
        messageDto.setMensagem("Erro ao excluir");

        UserModel userModel = new UserModel();

        for(UserModel user : listaUserModel){
            if (user.getEmail().equals(email)){
                userModel = user;

            }
            listaUserModel.remove(userModel);
            messageDto.setSucesso(true);
            messageDto.setMensagem("Excluido usuário com sucesso!");

        }

        return messageDto;


    }







}
