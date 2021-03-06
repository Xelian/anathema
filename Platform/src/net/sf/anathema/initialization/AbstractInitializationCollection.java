package net.sf.anathema.initialization;

import net.sf.anathema.initialization.plugin.IAnathemaPluginManager;
import net.sf.anathema.initialization.plugin.IPluginConstants;

import org.java.plugin.registry.Extension;
import org.java.plugin.registry.Extension.Parameter;

public abstract class AbstractInitializationCollection<T> {

  private static final String PARAM_CLASS = "class"; //$NON-NLS-1$
  private static final String PARAM_TYPE = "type"; //$NON-NLS-1$

  protected final void collectContent(IAnathemaPluginManager pluginManager) throws InitializationException {
    for (Extension extension : pluginManager.getExtension(IPluginConstants.PLUGIN_CORE, getExtensionPointId())) {
      for (Parameter typeParameter : extension.getParameters(PARAM_TYPE)) {
        T itemType = createItemType(typeParameter, extension, pluginManager);
        addItemForTypeParameter(typeParameter, itemType);
      }
    }
  }

  protected abstract void addItemForTypeParameter(Parameter typeParameter, T item);

  protected abstract String getExtensionPointId();

  @SuppressWarnings("unchecked")
  private T createItemType(Parameter typeParameter, Extension extension, IAnathemaPluginManager pluginManager)
      throws InitializationException {
    String className = typeParameter.getSubParameter(PARAM_CLASS).valueAsString();
    try {
      return (T) Class.forName(className, true, pluginManager.getClassLoader(extension)).newInstance();
    }
    catch (Throwable throwable) {
      throw new InitializationException("Failed to create item type from class " + className + ".", throwable); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }
}