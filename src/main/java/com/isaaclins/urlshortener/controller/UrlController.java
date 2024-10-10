package com.isaaclins.urlshortener.controller;

import com.isaaclins.urlshortener.model.Url;
import com.isaaclins.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/urls")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping
    public Url createUrl(@RequestBody Url url) {
        return urlService.saveUrl(url);
    }

    @GetMapping("/{shortUrl}")
    public Optional<Url> getUrl(@PathVariable String shortUrl) {
        return urlService.getUrlByShortUrl(shortUrl);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateUrl(@PathVariable Long id) {
        urlService.deactivateUrl(id);
    }
}