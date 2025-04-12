package co.com.asuarezr.dtos;

import jakarta.validation.constraints.NotBlank;

public record ResponseUserDto(

        String name,

        String lastname,

        String email
) { }
