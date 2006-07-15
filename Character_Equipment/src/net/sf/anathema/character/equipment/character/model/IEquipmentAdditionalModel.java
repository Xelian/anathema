package net.sf.anathema.character.equipment.character.model;

import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModel;
import net.sf.anathema.character.generic.equipment.weapon.IArmour;
import net.sf.anathema.character.generic.equipment.weapon.IWeapon;

public interface IEquipmentAdditionalModel extends IAdditionalModel, IEquipmentObjectCollection {

  public IWeapon[] getPrintWeapons();

  public IArmour[] getPrintArmours();

  public IArmour getTotalPrintArmour(int lineCount);
}