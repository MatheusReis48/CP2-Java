package com.fiap.brinquedos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "🎉 Bem-vindo à API de Brinquedos da FIAP! Use o endpoint /brinquedos para acessar os recursos.";
    }
}
