package intellispaces.ixora.data.cursor;

import intellispaces.common.base.type.Type;
import intellispaces.common.base.type.Types;
import intellispaces.framework.core.annotation.Mapper;
import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;

import java.io.InputStream;

@ObjectHandle(ByteCursorDomain.class)
abstract class InputStreamCursorHandle extends AbstractInputStreamCursor implements MovableByteCursor {

  InputStreamCursorHandle(InputStream is) {
    super(is);
  }

  @Mapper
  @Override
  public Type<Byte> elementDomain() {
    return Types.of(Byte.class);
  }

  @Override
  @MapperOfMoving
  public Boolean hasNext() {
    return hasNextElement();
  }

  @Override
  @MapperOfMoving
  public boolean hasNextPrimitive() {
    return hasNextElement();
  }

  @Mapper
  @Override
  public Byte next() {
    return nextElement();
  }

  @Mapper
  @Override
  public byte nextPrimitive() {
    return nextElement();
  }
}
