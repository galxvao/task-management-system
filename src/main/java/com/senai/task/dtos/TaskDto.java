package com.senai.task.dtos;


import com.senai.task.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {

    private Long id;

    @NotBlank(message = "O nome da tarefa não pode estar em branco" )
    private String nome;

    @NotBlank(message = "A descrição da tarefa não pode estar em branco")
    private String descricao;

    @NotNull(message = "A data de agendamento não pode ser nula")
    private Date data;

    @NotNull(message = "O status da tarefa não pode ser nulo")
    private Status status;

    @NotBlank(message = "O e-mail do usuário não pode estar em branco.")
    @Email(message = "O e-mail do usuário deve ser válido.")
    private String emailUsuario;

    private String mensagem;






}
