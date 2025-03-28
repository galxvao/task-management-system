package com.senai.task.services;

import com.senai.task.dtos.TaskDto;
import com.senai.task.models.TaskModel;
import com.senai.task.repositories.TaskRepository;
import com.senai.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository


    public List<TaskDto> obterTarefas(){

        List<TaskDto> listaDto = new ArrayList<>();

        List<TaskModel> listaModel =  taskRepository.findAll();

        for (TaskModel taskModel : listaModel){

            TaskDto taskDto = new TaskDto();

            taskDto.setId(taskModel.getId());
            taskDto.setNome(taskModel.getNome());
            taskDto.setDescricao(taskModel.getDescricao());
            taskDto.setData(taskModel.getData());
            taskDto.setStatus(taskModel.getStatus());

            listaDto.add(taskDto);
        }

        return listaDto;
    }

    /*public MessageDto inserirTarefa(Long id, TaskDto taskDto){



    }

*/
}
