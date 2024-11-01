package com.jg.desafio_anota_ai.Utils;

import io.github.cdimascio.dotenv.Dotenv;

public class TokenManager {
    private static Dotenv dotenv = Dotenv.load();

    public static String getToken(){
        return dotenv.get("aws-key");
    }
    public static String getSecretToken(){
        return dotenv.get("aws-secretKey");

    }
    public static String getRegion(){
        return dotenv.get("aws.region");
    }
    public static String getARN(){
        return dotenv.get("aws.sns.topic.catalog.arn");
    }
}
