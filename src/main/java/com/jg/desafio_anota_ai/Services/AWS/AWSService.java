package com.jg.desafio_anota_ai.Services.AWS;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AWSService {
    private final AmazonSNS snsClient;
    private final Topic catalogTopic;

    public AWSService(AmazonSNS snsClient,@Qualifier("catalog-events-topic") Topic catalogTopic) {
        this.snsClient = snsClient;
        this.catalogTopic = catalogTopic;
    }

    public void publish(MessageDTO message){
        snsClient.publish(catalogTopic.getTopicArn(), message.message());
    }
}
