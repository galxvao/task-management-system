package com.senai.task.controllers;

import com.senai.task.dtos.MessageDto;
import com.senai.task.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired



    public ResponseEntity<List<TaskDto>> obterTarefas ( ){

    List<TaskDto> lista = new ArrayList<>();


    return (ResponseEntity<List<TaskDto>>) lista;


    }

}
