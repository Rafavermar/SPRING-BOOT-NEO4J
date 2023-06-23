package dev.rafael.springbootneo4j.controllers;

import dev.rafael.springbootneo4j.DTO.UserDTO;
import dev.rafael.springbootneo4j.request.CreateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

@Tag(name = "2. Users", description = "User management")
public interface UserControllerSwagger {

    @Operation(summary = "Get logged-in user details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                            schema = @Schema(implementation = String.class))})
    })
    ResponseEntity<String> loggedInUser( Principal principal);

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDTO.class))})
    })
    ResponseEntity<UserDTO> signUp( CreateUserRequest request);
}

