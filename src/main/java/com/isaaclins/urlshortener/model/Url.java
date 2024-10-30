package com.isaaclins.urlshortener.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    @Id
    private Long id;
    private String shortUrl;
    private String longUrl;
    private boolean active;
    private int accessCount;
    private String password;
    private String ipAdresses;
}
