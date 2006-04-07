package net.sf.anathema.character.intimacies.presenter;

import javax.swing.Icon;

import net.sf.anathema.character.intimacies.view.IIntimaciesSelectionView;
import net.sf.anathema.character.library.intvalue.IRemovableTraitView;
import net.sf.anathema.character.library.removableentry.presenter.IRemovableEntryTabView;

public interface IIntimaciesView extends IRemovableEntryTabView<IRemovableTraitView> {

  public IIntimaciesSelectionView addSelectionView(String labelText, Icon addIcon);
}