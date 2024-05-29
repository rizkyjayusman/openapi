package com.rizkyjayusman.openapi.controller;

import com.rizkyjayusman.openapi.entity.Company;
import com.rizkyjayusman.openapi.entity.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/companies")
@Tag(name = "Company API", description = "Company Company")
@SecurityRequirement(name = "api")
public interface CompanyApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Get All Company List", description= "Get All Company List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = Error.class, example = "{\"status\":400,\"message\":\"Bad Request\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":404,\"message\":\"Not Found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":500,\"message\":\"Internal Server Error\"}")))
    })
    List<Company> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Get Company Detail", description= "Get Company by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = Error.class, example = "{\"status\":400,\"message\":\"Bad Request\"}"))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":404,\"message\":\"Not Found\"}"))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = Error.class, example ="{\"status\":500,\"message\":\"Internal Server Error\"}")))
    })
    Company findById(@PathVariable String id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary= "Save Company", description= "Create new Company")
    Company save(@RequestBody Company company);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary= "Update Company", description= "Update an existing Company")
    Company update(@PathVariable String id, @RequestBody Company company);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary= "Delete Company", description= "Delete an existing Company")
    void delete(@PathVariable String id);
}
