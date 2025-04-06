package co.com.asuarezr.dtos;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
         @NotBlank
         String name,

         @NotBlank
         String lastname,

         @NotBlank
         String email
) { }
