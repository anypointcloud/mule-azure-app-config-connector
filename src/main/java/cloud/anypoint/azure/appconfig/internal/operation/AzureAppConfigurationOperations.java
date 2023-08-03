package cloud.anypoint.azure.appconfig.internal.operation;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import cloud.anypoint.azure.appconfig.internal.AzureAppConfigurationConfiguration;
import cloud.anypoint.azure.appconfig.internal.connection.AzureAppConfigurationConnection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// docs:
// https://github.com/Azure/azure-sdk-for-java/tree/main/sdk/appconfiguration/azure-data-appconfiguration#retrieve-a-configuration-setting
public class AzureAppConfigurationOperations {
  private final Logger LOGGER = LoggerFactory.getLogger(AzureAppConfigurationOperations.class);

  @MediaType(value = ANY, strict = false)
  public String getSetting(String key, String label) {
    return "value";
  }

}
