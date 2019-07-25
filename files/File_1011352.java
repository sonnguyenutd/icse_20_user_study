package jetbrains.mps.lang.sharedConcepts.enumMigration;

/*Generated by MPS */

import org.jetbrains.mps.openapi.language.SEnumerationLiteral;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SEnumOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.EnumerationLiteralsIndex;

public class Options_DefaultCustom_MigrationUtils {
  public static String value(SEnumerationLiteral enummember) {
    switch (enumSwitchIndex_uytbh4_a0a0a.indexNullable(enummember)) {
      case 0:
        return null;
      case 1:
        return "custom";
      default:
        return null;
    }
  }
  public static SEnumerationLiteral fromValue(String value) {
    if (value == null) {
      return SEnumOperations.getMember(MetaAdapterFactory.getEnumeration(0x13744753c81f424aL, 0x9c1bcf8943bf4e86L, 0x10e811b985dL, "jetbrains.mps.lang.sharedConcepts.structure.Options_DefaultCustom"), 0x10e811b985eL, "default_");
    }
    switch (value) {
      case "custom":
        return SEnumOperations.getMember(MetaAdapterFactory.getEnumeration(0x13744753c81f424aL, 0x9c1bcf8943bf4e86L, 0x10e811b985dL, "jetbrains.mps.lang.sharedConcepts.structure.Options_DefaultCustom"), 0x10e811e894dL, "custom_");
      default:
        return null;
    }
  }
  private static EnumerationLiteralsIndex enumSwitchIndex_uytbh4_a0a0a = EnumerationLiteralsIndex.build(0x13744753c81f424aL, 0x9c1bcf8943bf4e86L, 0x10e811b985dL, 0x10e811b985eL, 0x10e811e894dL);
}