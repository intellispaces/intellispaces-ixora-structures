package intellispaces.ixora.structures.collection;

import intellispaces.common.base.type.Type;
import intellispaces.common.javastatement.type.Types;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;

/**
 * Synonym for the domains NumberListDomain&lt;Integer&gt; and ListDomain&lt;Byte&gt;.
 */
@Domain("019081b8-bfb3-7089-9d6c-6537ab3fca07")
public interface IntegerListDomain extends NumberListDomain<Integer> {

  /**
   * Downgrade mapping.
   */
  @Transition("0190824d-8716-7f90-8c49-fa9a6ee24bcb")
  ListDomain<Integer> asList();

  /**
   * Downgrade mapping.
   */
  @Override
  @Transition("01909080-8b2e-798a-8467-150465a39848")
  CollectionDomain<Integer> asCollection();

  @Override
  default Type<Integer> elementDomain() {
    return Types.of(Integer.class);
  }

  @Override
  Integer element(int index);
}
