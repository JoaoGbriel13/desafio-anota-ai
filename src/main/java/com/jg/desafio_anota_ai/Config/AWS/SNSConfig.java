package com.jg.desafio_anota_ai.Config.AWS;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import com.jg.desafio_anota_ai.Utils.TokenManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SNSConfig {
    private static final String ACCESS_KEY = TokenManager.getToken();
    private static final String SECRET_KEY = TokenManager.getSecretToken();
    private static final String REGION = TokenManager.getRegion();
    private static final String ARN = TokenManager.getARN();

    @Bean
    public AmazonSNS amazonSNSBuilder(){
        BasicAWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY,SECRET_KEY);

        return AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(REGION)
                .build();
    }
    @Bean(name = "catalog-events-topic")
    public Topic catalogTopicBuilder(){
        return new Topic().withTopicArn(ARN);
    }
}
