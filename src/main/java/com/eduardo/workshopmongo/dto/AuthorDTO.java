package com.eduardo.workshopmongo.dto;

import com.eduardo.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(User obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }
}
