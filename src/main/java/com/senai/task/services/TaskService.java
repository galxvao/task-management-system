package com.senai.task.services;

import com.senai.task.dtos.TaskDto;
import com.senai.task.models.TaskModel;
import com.senai.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;


    public List<TaskDto> obterTarefas(){

        List<TaskDto> listaDto = new ArrayList<>();

        List<TaskModel> listaModel =  repository.findAll();

        for (TaskModel taskModel : listaModel){

            TaskDto taskDto = new TaskDto();

            taskDto.setId(taskModel.getId());
            taskDto.setNome(taskModel.getNome());
            taskDto.setData(taskModel.getData());
            taskDto.setStatus(taskModel.getStatus()); // Aprender como utilizar o enum
        }
    }


}
