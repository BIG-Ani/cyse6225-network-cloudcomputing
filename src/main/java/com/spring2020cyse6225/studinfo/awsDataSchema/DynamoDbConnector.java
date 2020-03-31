package com.spring2020cyse6225.studinfo.awsDataSchema;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDbConnector {

    static AmazonDynamoDB dynamoDb ;

    public static void init() {
        if (dynamoDb == null) {
//            ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
//            credentialsProvider.getCredentials();

            // create the aws service dynamoDb;
            dynamoDb = AmazonDynamoDBClientBuilder
                    .standard()
//                    .withCredentials(credentialsProvider)
//                    .withRegion(Regions.US_WEST_2)
                    .build();
            System.out.println("I created the client");

//            // using the dynamoDb locally
//            dynamoDb = AmazonDynamoDBClientBuilder
//                    .standard()
//                    .withEndpointConfiguration(
//                            new AwsClientBuilder.EndpointConfiguration(
//                                    "http://localhost:8080",
//                                    "us-west-2"
//                            )
//                    ).build();
//            System.out.println("Created the local DynamoDB client");
        }

    }

    public AmazonDynamoDB getClient() {
        return dynamoDb;
    }
}
