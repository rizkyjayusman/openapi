package com.rizkyjayusman.openapi.controller;

import com.rizkyjayusman.openapi.entity.Company;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController implements CompanyApi {
    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public Company findById(String id) {
        return null;
    }

    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public Company update(String id, Company company) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
