@NativeType("b3SharedMemoryCommandHandle") public static long b3InitChangeDynamicsInfo(@NativeType("b3PhysicsClientHandle") long physClient){
  if (CHECKS) {
    check(physClient);
  }
  return nb3InitChangeDynamicsInfo(physClient);
}
