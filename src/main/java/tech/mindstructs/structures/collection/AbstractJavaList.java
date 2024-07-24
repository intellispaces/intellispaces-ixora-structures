package tech.mindstructs.structures.collection;

import intellispaces.ixora.mindstructs.structures.collection.CollectionHandle;
import intellispaces.ixora.mindstructs.structures.collection.UnmovableListHandle;
import tech.intellispaces.framework.core.annotation.Mapper;
import tech.intellispaces.framework.core.annotation.ObjectHandle;

import java.util.Collections;

@ObjectHandle("JavaList")
public abstract class AbstractJavaList<E> implements UnmovableListHandle<E> {
  private final java.util.List<E> list;
  private final Class<E> elementDomainClass;

  public AbstractJavaList(java.util.List<E> list, Class<E> elementDomainClass) {
    this.list = Collections.unmodifiableList(list);
    this.elementDomainClass = elementDomainClass;
  }

  @Override
  public java.util.List<E> nativeList() {
    return list;
  }

  @Mapper
  @Override
  public CollectionHandle<? extends E> asCollection() {
    return new JavaCollection<>(list, elementDomainClass);
  }

  @Mapper
  @Override
  public Class<? extends E> elementDomain() {
    return elementDomainClass;
  }

  @Mapper
  @Override
  public E element(int index) {
    return list.get(index);
  }

  @Mapper
  @Override
  public int size() {
    return list.size();
  }
}