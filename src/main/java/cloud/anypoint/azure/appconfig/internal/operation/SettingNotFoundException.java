package cloud.anypoint.azure.appconfig.internal.operation;

import cloud.anypoint.azure.appconfig.api.ConnectorError;
import org.mule.runtime.extension.api.exception.ModuleException;

public class SettingNotFoundException extends ModuleException {
    public SettingNotFoundException(String key, String label) {
        super("Setting not found (key=" + key + ", label=" + label + ")", ConnectorError.SETTING_NOT_FOUND);
    }
    public SettingNotFoundException(String key, String label, Throwable cause) {
        super("Setting not found (key=" + key + ", label=" + label + ")", ConnectorError.SETTING_NOT_FOUND, cause);
    }
}
