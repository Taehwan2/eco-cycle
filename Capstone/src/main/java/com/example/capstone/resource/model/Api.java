package com.example.capstone.resource.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Api<T> {
    private T body;
    private Pagination pagination;
}
