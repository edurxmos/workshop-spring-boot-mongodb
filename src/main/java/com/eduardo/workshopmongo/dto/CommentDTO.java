package com.eduardo.workshopmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;

}
