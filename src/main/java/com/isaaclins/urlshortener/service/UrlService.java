package com.isaaclins.urlshortener.service;

import com.isaaclins.urlshortener.model.Url;
import com.isaaclins.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public Url saveUrl(Url url) {
        return urlRepository.save(url);
    }

    public Optional<Url> getUrlByShortUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    public void deactivateUrl(Long id) {
        Optional<Url> url = urlRepository.findById(id);
        url.ifPresent(u -> {
            u.setActive(false);
            urlRepository.save(u);
        });
    }
}