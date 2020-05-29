package dasniko.aws.secretsmanager;

import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class AwsSecretsReader {

    public static void main(String[] args) {
        SecretsManagerClient secretsManager = SecretsManagerClient.builder()
            .httpClientBuilder(UrlConnectionHttpClient.builder())
            .build();
        String secretString = secretsManager
            .getSecretValue(builder -> builder.secretId(args[0]).build())
            .secretString();
        System.out.println(secretString);
    }

}
