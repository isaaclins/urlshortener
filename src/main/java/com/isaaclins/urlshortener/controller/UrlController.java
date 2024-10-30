package com.isaaclins.urlshortener.controller;

import com.isaaclins.urlshortener.model.Url;
import com.isaaclins.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable("shortUrl") String shortUrl) {
        Url url = urlService.getUrl(shortUrl);
        if (url != null) {
            url.setAccessCount(url.getAccessCount() + 1);
            urlService.saveUrl(url);
            return "redirect:" + url.getLongUrl();
        }
        return "redirect:/";
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam("longUrl") String longUrl, @RequestParam(value = "shortUrl", required = false) String shortUrl, @RequestParam(value = "shortUrl", required = false) String password) {
        if (shortUrl == null || shortUrl.isEmpty()) {
            shortUrl = generateShortUrl();
        }
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortUrl(shortUrl);
        urlService.saveUrl(url);
        return "Shorted URL: " +shortUrl + "\nPassword"+password;
    }

    private String generateShortUrl() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * characters.length());
            shortUrl.append(characters.charAt(index));
        }
        return shortUrl.toString();
    }

}