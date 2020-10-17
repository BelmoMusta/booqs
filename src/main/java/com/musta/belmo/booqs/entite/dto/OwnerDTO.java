package com.musta.belmo.booqs.entite.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OwnerDTO {

    private Long id;

    private String name;

    private String lastName;

    private String address;

    private Set<BookDTO> books;
}
