package net.sf.anathema.character.equipment.creation.presenter.stats.properties;

import javax.swing.Icon;

import net.disy.commons.swing.ui.IObjectUi;
import net.sf.anathema.character.generic.health.HealthType;
import net.sf.anathema.lib.resources.IResources;

public class HealthTypeUi implements IObjectUi {

  private final IResources resources;

  public HealthTypeUi(IResources resources) {
    this.resources = resources;
  }

  public Icon getIcon(Object value) {
    return null;
  }

  public String getLabel(Object value) {
    if (value == null) {
      return "Select";
    }
    HealthType healthType = (HealthType) value;
    return healthType.name();
  }
}