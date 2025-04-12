package co.com.asuarezr.dtos;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(

         String name,

         String lastname,

         String email
) { }
