package com.rizkyjayusman.openapi.controller;

import com.rizkyjayusman.openapi.entity.Error;
import com.rizkyjayusman.openapi.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("/api/users")
@Tag(name = "User API", description = "User API")
@SecurityRequirement(name = "api")
public interface UserApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Get All User List", description= "Get All User List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = Error.class, example = "{\"status\":400,\"message\":\"Bad Request\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":404,\"message\":\"Not Found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":500,\"message\":\"Internal Server Error\"}")))
    })
    List<User> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Get User Detail", description= "Get User by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = Error.class, example = "{\"status\":400,\"message\":\"Bad Request\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":404,\"message\":\"Not Found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":500,\"message\":\"Internal Server Error\"}")))
    })
    User findById(@PathVariable String id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary= "Save User", description= "Create new User")
    User save(@RequestBody User user);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Update User", description= "Update an existing User")
    User update(@PathVariable String id, @RequestBody User user);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary= "Delete User", description= "Delete an existing User")
    void delete(@PathVariable String id);
}
