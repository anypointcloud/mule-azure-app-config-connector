package cloud.anypoint.azure.appconfig.internal.connection;

import com.azure.core.credential.TokenCredential;
import com.azure.data.appconfiguration.ConfigurationAsyncClient;
import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import com.azure.data.appconfiguration.models.ConfigurationSetting;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * Following practices defined here https://docs.mulesoft.com/mule-sdk/1.1/define-configurations-and-connection-providers#connection-object-must-not-expose-nor-be-the-inner-client
 */
public final class AzureAppConfigurationConnection {
  private static Logger logger = LoggerFactory.getLogger(AzureAppConfigurationConnection.class);

  private final ConfigurationAsyncClient client;
  public AzureAppConfigurationConnection(TokenCredential credential, String endpoint) {
      this.client = new ConfigurationClientBuilder()
            .credential(credential)
            .endpoint(endpoint)
            .buildAsyncClient();
  }

  public void invalidate() {
    // do something to invalidate this connection!
  }

  public void getSetting(String key, String label, Consumer<ConfigurationSetting> consumer) {
      client.getConfigurationSetting(key, label)
              .subscribe(consumer);
  }
}
