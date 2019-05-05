package main.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    SUCCESS("Success"), ERROR("Error");

    private String name;
}
