package cloud.anypoint.azure.appconfig.internal.operation;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import cloud.anypoint.azure.appconfig.api.SettingAttributes;
import cloud.anypoint.azure.appconfig.internal.connection.AzureAppConfigurationConnection;
import cloud.anypoint.azure.appconfig.internal.datasense.SettingErrorTypeProvider;
import com.azure.core.exception.HttpResponseException;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpCookie;


// docs:
// https://github.com/Azure/azure-sdk-for-java/tree/main/sdk/appconfiguration/azure-data-appconfiguration#retrieve-a-configuration-setting
public class AzureAppConfigurationOperations {
    private final Logger LOGGER = LoggerFactory.getLogger(AzureAppConfigurationOperations.class);

    @Throws(SettingErrorTypeProvider.class)
    @MediaType(value = ANY, strict = false)
    public void getSetting(@Connection AzureAppConfigurationConnection connection,
                           String key,
                           @Optional String label,
                           CompletionCallback<String, SettingAttributes> callback) {
        connection.getSetting(key, label)
                .onErrorMap(
                        e -> (e instanceof HttpResponseException),
                        e -> {
                            HttpResponseException exception = (HttpResponseException) e;
                            switch (exception.getResponse().getStatusCode())
                            {
                                case 404: return new SettingNotFoundException(key, label, e);
                                case 401: return new UnauthorizedException(connection.getEndpoint(), key, e);
                                default: return e;
                            }
                        })
                .subscribe(setting -> {
                    SettingAttributes attributes = new SettingAttributes();
                    attributes.setKey(setting.getKey());
                    attributes.setLabel(setting.getLabel());
                    attributes.setLastModified(setting.getLastModified().toInstant());
                    attributes.setETag(setting.getETag());
                    attributes.setTags(setting.getTags());
                    org.mule.runtime.api.metadata.MediaType contentType =
                            org.mule.runtime.api.metadata.MediaType.parse(setting.getContentType());
                    callback.success(Result.<String, SettingAttributes>builder()
                            .output(setting.getValue())
                            .mediaType(contentType)
                            .attributes(attributes)
                            .build());
                }, callback::error);
    }

}
