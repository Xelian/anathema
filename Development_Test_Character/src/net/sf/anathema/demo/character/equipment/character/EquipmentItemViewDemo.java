package net.sf.anathema.demo.character.equipment.character;

import net.sf.anathema.character.equipment.impl.character.view.EquipmentObjectView;
import de.jdemo.extensions.SwingDemoCase;

public class EquipmentItemViewDemo extends SwingDemoCase {

  public void demo() {
    EquipmentObjectView view = new EquipmentObjectView();
    view.setItemTitle("Title"); //$NON-NLS-1$
    view.setItemDescription("Ganz viel description"); //$NON-NLS-1$
    view.addStats("B�se Waffe: Viel, viel Schaden"); //$NON-NLS-1$
    view.addStats("Abyssal-Waffe: Jetzt auch mit aggrevated Schaden."); //$NON-NLS-1$
    show(view.getTaskGroup());
  }
}