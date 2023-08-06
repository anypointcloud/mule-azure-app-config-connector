package cloud.anypoint.azure.appconfig.internal.datasense;

import cloud.anypoint.azure.appconfig.api.ConnectorError;
import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import java.util.HashSet;
import java.util.Set;

public class SettingErrorTypeProvider implements ErrorTypeProvider {
    @Override
    public Set<ErrorTypeDefinition> getErrorTypes() {
        Set<ErrorTypeDefinition> errorTypes = new HashSet<>();
        errorTypes.add(ConnectorError.SETTING_NOT_FOUND);
        errorTypes.add(ConnectorError.UNAUTHORIZED);
        return errorTypes;
    }
}
