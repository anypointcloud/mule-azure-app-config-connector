package cloud.anypoint.azure.appconfig.internal.operation;

import cloud.anypoint.azure.appconfig.api.ConnectorError;
import org.mule.runtime.extension.api.exception.ModuleException;

public class UnauthorizedException extends ModuleException {

    public UnauthorizedException(String endpoint, String key, Throwable cause) {
        super("Unauthorized for " + endpoint + "/" + key, ConnectorError.UNAUTHORIZED, cause);
    }
}
