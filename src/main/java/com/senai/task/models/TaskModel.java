package com.senai.task.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tarefas")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    enum Status {
        EM_ABERTO, PENDENTE, CONCLUIDO, CANCELADO;
    }

    @Column(name = "status")
    private Status status;

    @Column(name = "usuario")
    @ManyToOne
    private UserModel usuario;









}
