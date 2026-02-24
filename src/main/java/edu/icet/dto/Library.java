package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Library {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private Integer quantity;
}
