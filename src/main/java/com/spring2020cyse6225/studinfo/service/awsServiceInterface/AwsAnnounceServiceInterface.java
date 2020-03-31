package com.spring2020cyse6225.studinfo.service.awsServiceInterface;

import com.spring2020cyse6225.studinfo.awsDataSchema.Announcement;

public interface AwsAnnounceServiceInterface {

    Announcement addAnnouncement(Announcement announcement);

    Announcement deleteAnnouncement(Long announcementId);

    Announcement updateAnnouncement(Long announcementId, Announcement announcement);

    Announcement findAnnouncementById(Long announcementId);
}
