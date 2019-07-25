package jetbrains.mps.lang.resources.enumMigration;

/*Generated by MPS */

import org.jetbrains.mps.openapi.language.SEnumerationLiteral;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SEnumOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.EnumerationLiteralsIndex;

public class Size_MigrationUtils {
  public static int value(SEnumerationLiteral enummember) {
    switch (enumSwitchIndex_abil6o_a0a0a.indexNullable(enummember)) {
      case 0:
        return 8;
      case 1:
        return 6;
      case 2:
        return 4;
      default:
        return 0;
    }
  }
  public static SEnumerationLiteral fromValue(int value) {
    switch (value) {
      case 8:
        return SEnumOperations.getMember(MetaAdapterFactory.getEnumeration(0x982eb8df2c964bd7L, 0x996311712ea622e5L, 0x15d013b3c3eb278aL, "jetbrains.mps.lang.resources.structure.Size"), 0x15d013b3c3eb278bL, "big");
      case 6:
        return SEnumOperations.getMember(MetaAdapterFactory.getEnumeration(0x982eb8df2c964bd7L, 0x996311712ea622e5L, 0x15d013b3c3eb278aL, "jetbrains.mps.lang.resources.structure.Size"), 0x15d013b3c3eb278cL, "medium");
      case 4:
        return SEnumOperations.getMember(MetaAdapterFactory.getEnumeration(0x982eb8df2c964bd7L, 0x996311712ea622e5L, 0x15d013b3c3eb278aL, "jetbrains.mps.lang.resources.structure.Size"), 0x15d013b3c3eb278fL, "small");
      default:
        return null;
    }
  }
  private static EnumerationLiteralsIndex enumSwitchIndex_abil6o_a0a0a = EnumerationLiteralsIndex.build(0x982eb8df2c964bd7L, 0x996311712ea622e5L, 0x15d013b3c3eb278aL, 0x15d013b3c3eb278bL, 0x15d013b3c3eb278cL, 0x15d013b3c3eb278fL);
}