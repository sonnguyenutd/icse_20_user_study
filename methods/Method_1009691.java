public static ByteBuffer read(MappedByteBuffer data,int offset,int length) throws IOException {
  int newPosition=data.position() + offset;
  ByteBuffer block=(ByteBuffer)data.duplicate().order(ByteOrder.LITTLE_ENDIAN).clear().limit(newPosition + length).position(newPosition);
  return block;
}
