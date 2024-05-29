package com.rizkyjayusman.openapi.controller;

import com.rizkyjayusman.openapi.entity.Error;
import com.rizkyjayusman.openapi.entity.Todo;
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

@RequestMapping("/api/todos")
@Tag(name = "Todo API", description = "Todo API")
@SecurityRequirement(name = "api")
public interface TodoApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Get All Todo List", description= "Get All Todo List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = Error.class, example = "{\"status\":400,\"message\":\"Bad Request\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":404,\"message\":\"Not Found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":500,\"message\":\"Internal Server Error\"}")))
    })
    List<Todo> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Get Todo Detail", description= "Get Todo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = Error.class, example = "{\"status\":400,\"message\":\"Bad Request\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":404,\"message\":\"Not Found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":500,\"message\":\"Internal Server Error\"}")))
    })
    Todo findById(@PathVariable String id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary= "Save Todo", description= "Create new Todo")
    Todo save(@RequestBody Todo todo);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Update Todo", description= "Update an existing Todo")
    Todo update(@PathVariable String id, @RequestBody Todo todo);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary= "Delete Todo", description= "Delete an existing Todo")
    void delete(@PathVariable String id);
}
