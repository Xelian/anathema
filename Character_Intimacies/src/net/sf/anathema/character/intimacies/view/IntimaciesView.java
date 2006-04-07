package net.sf.anathema.character.intimacies.view;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.disy.commons.swing.layout.grid.GridDialogLayout;
import net.disy.commons.swing.layout.grid.GridDialogLayoutData;
import net.sf.anathema.character.intimacies.presenter.IIntimaciesView;
import net.sf.anathema.character.library.intvalue.IIntValueDisplayFactory;
import net.sf.anathema.character.library.intvalue.IRemovableTraitView;
import net.sf.anathema.character.library.removableentry.view.AbstractRemovableEntryView;
import net.sf.anathema.character.library.trait.view.ITraitView;
import net.sf.anathema.character.library.trait.view.RearButtonTraitViewWrapper;
import net.sf.anathema.character.library.trait.view.SimpleTraitView;

public class IntimaciesView extends AbstractRemovableEntryView<IRemovableTraitView> implements IIntimaciesView {

  private final JPanel content = new JPanel(new GridDialogLayout(1, false));
  private final JPanel entryPanel = new JPanel(new GridDialogLayout(2, false));
  private final IIntValueDisplayFactory factory;

  public IntimaciesView(IIntValueDisplayFactory factory) {
    this.factory = factory;
  }

  public JComponent getComponent() {
    content.add(entryPanel, GridDialogLayoutData.FILL_HORIZONTAL);
    return content;
  }

  public boolean needsScrollbar() {
    return false;
  }

  public IIntimaciesSelectionView addSelectionView(String labelText, Icon addIcon) {
    IntimaciesSelectionView view = new IntimaciesSelectionView(labelText, addIcon);
    content.add(view.getComponent());
    return view;
  }

  public IRemovableTraitView addEntryView(Icon removeIcon, String string) {
    ITraitView view = new SimpleTraitView(factory, string, 0, 5);
    RearButtonTraitViewWrapper oneButtonView = new RearButtonTraitViewWrapper(view, removeIcon);
    RearButtonTraitViewWrapper twoButtonView = new RearButtonTraitViewWrapper(oneButtonView, removeIcon);
    twoButtonView.addComponents(entryPanel);
    content.revalidate();
    return twoButtonView;
  }
}