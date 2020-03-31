package com.spring2020cyse6225.studinfo.service.awsServiceImp;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.spring2020cyse6225.studinfo.awsDataSchema.Announcement;
import com.spring2020cyse6225.studinfo.awsDataSchema.DynamoDbConnector;
import com.spring2020cyse6225.studinfo.service.awsServiceInterface.AwsAnnounceServiceInterface;

public class AwsAnnounceServiceImp implements AwsAnnounceServiceInterface {

    private static DynamoDbConnector dynamoDb;
    private DynamoDBMapper announceMapper;

    public AwsAnnounceServiceImp() {
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();

        announceMapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    @Override
    public Announcement addAnnouncement(Announcement announcement) {
        if (announcement == null) {
            System.out.println("Please add valid announcement");
            return null;
        } else {
            announceMapper.save(announcement);

            System.out.println("Add new announcement >>\n" + announcement);
            return announcement;
        }
    }

    @Override
    public Announcement deleteAnnouncement(Long announcementId) {
        return null;
    }

    @Override
    public Announcement updateAnnouncement(Long announcementId, Announcement announcement) {
        return null;
    }

    @Override
    public Announcement findAnnouncementById(Long announcementId) {
        return null;
    }
}
