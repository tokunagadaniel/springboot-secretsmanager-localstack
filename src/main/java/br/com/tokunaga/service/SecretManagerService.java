package br.com.tokunaga.service;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecretManagerService implements Service {

    private final AWSSecretsManager awsSecretsManager;

    public String get(String secretName) {
        try {
            GetSecretValueResult getSecretValueResponse = awsSecretsManager.getSecretValue(new GetSecretValueRequest().withSecretId(secretName));

            if (getSecretValueResponse == null) {
                throw new RuntimeException("getSecretValueResponse is null");
            }

            return getSecretValueResponse.getSecretString();
        } catch (Exception e) {
            throw new RuntimeException("The request had invalid params: " + e.getMessage());
        }
    }
}
