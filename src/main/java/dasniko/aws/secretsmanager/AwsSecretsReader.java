package dasniko.aws.secretsmanager;

import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class AwsSecretsReader {

    public static void main(String[] args) {
        SecretsManagerClient secretsManager = SecretsManagerClient.create();
        GetSecretValueResponse response = secretsManager.getSecretValue(builder -> builder.secretId(args[0]).build());
        String secretString = response.secretString();
        System.out.println(secretString);
    }

}
