package intellispaces.ixora.structures.association;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.ixora.structures.collection.Collection;

import java.util.Collections;
import java.util.Map;

@ObjectHandle(value = MapDomain.class, name = "JavaMapHandleImpl")
abstract class JavaMapHandle<K, V> implements UnmovableMap<K, V> {
  private final java.util.Map<K, V> map;
  private final Type<K> keyType;
  private final Type<V> valueType;

  JavaMapHandle(java.util.Map<K, V> map, Class<K> keyClass, Class<V> valueClass) {
    this.map = Collections.unmodifiableMap(map);
    this.keyType = Types.of(keyClass);
    this.valueType = Types.of(valueClass);
  }

  JavaMapHandle(java.util.Map<K, V> map, Type<K> keyType, Type<V> valueType) {
    this.map = Collections.unmodifiableMap(map);
    this.keyType = keyType;
    this.valueType = valueType;
  }

  @Override
  public Type<MapDomain<K, V>> domain() {
    return Types.of(MapDomain.class, keyType, valueType);
  }

  @Override
  public Collection<KeyValuePair<K, V>> keyValuePairs() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public Map<K, V> nativeMap() {
    return map;
  }
}
