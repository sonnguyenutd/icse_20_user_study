/** 
 * Associates the specified value with the specified  {@link TransitionId} in this map. If the mappreviously contained a mapping for the key, the old value is replaced by the specified value.
 * @param id {@link TransitionId} with which the specified value is to be associated
 * @param value value to be associated with the specified {@link TransitionId}
 */
void put(TransitionId id,V value){
  if (mIds.put(id,value) == null) {
switch (id.mType) {
case TransitionId.Type.GLOBAL:
      mGlobalIds.put(id.mReference,id);
    break;
case TransitionId.Type.SCOPED:
  final String owner=id.mExtraData;
Map<String,TransitionId> siblingsIds=mScopedIdsByOwner.get(owner);
if (siblingsIds == null) {
siblingsIds=new LinkedHashMap<>();
mScopedIdsByOwner.put(owner,siblingsIds);
}
siblingsIds.put(id.mReference,id);
break;
case TransitionId.Type.AUTOGENERATED:
mAutogeneratedIds.put(id.mReference,id);
break;
default :
throw new RuntimeException("Unknown TransitionId type " + id.mType);
}
}
}
