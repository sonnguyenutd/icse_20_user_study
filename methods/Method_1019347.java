@GetMapping("/attr/tree") @ApiOperation(value="???????",notes="?????????????????????????????") public CommonResult<List<AdminsProductAttrSimpleVO>> tree(){
  List<ProductAttrSimpleBO> result=productAttrService.getProductAttrList();
  return success(ProductAttrConvert.INSTANCE.convert(result));
}