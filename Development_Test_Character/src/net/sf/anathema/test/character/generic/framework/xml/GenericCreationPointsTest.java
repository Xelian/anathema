package net.sf.anathema.test.character.generic.framework.xml;

import net.sf.anathema.character.generic.framework.xml.creation.GenericCreationPoints;
import net.sf.anathema.test.lib.lang.clone.AbstractDeepCloneableTest;

public class GenericCreationPointsTest extends AbstractDeepCloneableTest {

  @Override
  protected GenericCreationPoints createObjectUnderTest() {
    return new GenericCreationPoints();
  }
}