package dasniko.aws.secretsmanager;

import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class AwsSecretsReader {

    public static void main(String[] args) {
        if (args.length > 1) {
            throw new RuntimeException("Wrong number of arguments provided, only one argument allowed.");
        }
        String arg = args[0];
        if (arg.equals("--version") || arg.equals("-v")) {
            System.out.println("AWS Secrets Reader by @dasniko, version 1.2");
        } else {
            readSecret(arg);
        }
    }

    private static void readSecret(String secretName) {
        String secretString;
        try (SecretsManagerClient secretsManager = SecretsManagerClient.builder()
            .httpClientBuilder(UrlConnectionHttpClient.builder())
            .build()) {
            secretString = secretsManager
                .getSecretValue(builder -> builder.secretId(secretName).build())
                .secretString();
        }
        System.out.println(secretString);
    }

}
