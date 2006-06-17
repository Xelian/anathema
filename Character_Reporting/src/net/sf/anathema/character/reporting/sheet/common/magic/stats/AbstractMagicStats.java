package net.sf.anathema.character.reporting.sheet.common.magic.stats;

import net.sf.anathema.character.generic.framework.magic.stringbuilder.MagicInfoStringBuilder;
import net.sf.anathema.character.generic.framework.reporting.datasource.CharmDataSource;
import net.sf.anathema.character.generic.magic.IMagic;
import net.sf.anathema.lib.resources.IResources;
import net.sf.anathema.lib.util.IIdentificate;
import net.sf.anathema.lib.util.Identificate;

public abstract class AbstractMagicStats<T extends IMagic> implements IMagicStats {
  private final T magic;

  public AbstractMagicStats(T magic) {
    this.magic = magic;
  }

  public IIdentificate getName() {
    return new Identificate(magic.getId());
  }

  public String getCostString(IResources resources) {
    MagicInfoStringBuilder infoBuilder = CharmDataSource.createMagicInfoStringBuilder(resources);
    return infoBuilder.createCostString(magic);
  }

  protected final T getMagic() {
    return magic;
  }
}