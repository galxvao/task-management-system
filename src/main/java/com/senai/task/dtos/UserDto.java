package com.senai.task.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @Email
    @NotBlank(message = "O email não pode estar em branco")
    private String email;

}
