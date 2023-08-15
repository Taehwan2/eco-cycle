package com.example.capstone.resource.db;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "resource")
public class Resource {
    @Id
    private ObjectId resource_id;

    private String resourceNum;

    private  String name;

    public Resource(String resourceNum, String name, int num, String phonenum, String address, String imagePath, ResourceStates resourceStates) {
        this.resourceNum = resourceNum;
        this.name = name;
        this.num = num;
        this.phonenum = phonenum;
        this.address = address;
        this.imagePath = imagePath;
        this.resourceStates = resourceStates;
    }

    private int num;

    private String phonenum;

    private String address;

    private String imagePath;

    private ResourceStates resourceStates;

    public enum ResourceStates{
        REGESTERED("등록됨"),
        COMPLETED("완료됨");

        @Getter
        private String States;

        ResourceStates(String states) {
            this.States = states;
        }
    }

}
