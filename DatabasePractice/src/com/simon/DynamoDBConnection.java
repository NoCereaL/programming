package com.simon;
/*
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;

public class DynamoDBConnection {
    public static void main(String[] args) {
        try{
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "eu-west-2"))
                    .build();

            DynamoDB dynamoDB = new DynamoDB(client);

            Table table = dynamoDB.getTable("test");

            Item item = table.getItem("Simon", 10);

            //System.out.println(item);

            System.out.println("Connected");

        }catch (AmazonClientException exception ){
            System.out.println(exception);
            System.out.println("Error");
        }
    }
}
*/