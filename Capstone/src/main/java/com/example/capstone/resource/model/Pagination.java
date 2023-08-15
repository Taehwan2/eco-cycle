package com.example.capstone.resource.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
    private Integer page;
    private Integer size;
    private Integer cuurentElement;
    private Integer totalpage;
    private Long totalElemnet;
}
