package com.senai.task.dtos;

import com.senai.task.models.TaskModel;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {

    private Long id;
    private String nome;
    private String descricao;
    private Date dataAgendamento;
    enum Status {
        EM_ABERTO, EM_ANDAMENTO, CONCLUIDO, CANCELADO;
    }
    private Status status;
    private String emailUsuario;



}
