package net.sf.anathema.character.reporting.sheet.util;

import net.sf.anathema.character.reporting.sheet.pageformat.IVoidStateFormatConstants;
import net.sf.anathema.character.reporting.util.Bounds;
import net.sf.anathema.character.reporting.util.Position;

import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;

public class VirtueFlawBoxEncoder {

  private final PdfTraitEncoder traitEncoder;

  public VirtueFlawBoxEncoder(BaseFont baseFont) {
    this.traitEncoder = PdfTraitEncoder.createMediumTraitEncoder(baseFont);
  }
  
  public float getBoxHeight() {
    return traitEncoder.getTraitHeight();
  }

  public Bounds encode(PdfContentByte directContent, Bounds bounds, int currentLimit) {
    return new Bounds(bounds.x, bounds.y, bounds.width, bounds.height - encodeHeight(directContent, bounds, currentLimit));
  }

  public float encodeHeight(PdfContentByte directContent, Bounds bounds, int currentLimit) {
    float traitBaseLine = bounds.getMaxY() - traitEncoder.getTraitHeight();
    float padding = IVoidStateFormatConstants.PADDING / 2.0f;
    Position traitPosition = new Position(bounds.x + padding, traitBaseLine);
    return traitEncoder.encodeSquaresCenteredAndUngrouped(directContent, traitPosition, bounds.width - 2 * padding, currentLimit, 10);
  }
}