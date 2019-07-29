package com.parley.parley.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DynamoDBTable(tableName = "roleType")
public class RoleType {



}
