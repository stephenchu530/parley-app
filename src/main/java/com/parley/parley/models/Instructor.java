package com.parley.parley.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@DynamoDBTable(tableName = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

}
