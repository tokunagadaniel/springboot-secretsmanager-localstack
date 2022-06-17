package br.com.tokunaga.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretManagerConfig {
    @Value("${aws.region}")
    private String region;

    @Value("${aws.sm.endpoint}")
    private String endpoint;

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.access.key}")
    private String secretKey;

    @Bean
    public AWSSecretsManager awsSecretsManager() {
        return AWSSecretsManagerClientBuilder.standard()
                .withEndpointConfiguration(endpointConfiguration())
                .withCredentials(credentialsProvider())
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration endpointConfiguration() {
        return new AwsClientBuilder.EndpointConfiguration(endpoint, region);
    }

    private AWSStaticCredentialsProvider credentialsProvider() {
        return new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(accessKey, secretKey)
        );
    }
}
