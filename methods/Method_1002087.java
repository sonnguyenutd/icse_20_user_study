/** 
 * ????
 * @author stylefeng
 * @Date 2019-03-13
 */
@ResponseBody @RequestMapping("/list") public LayuiPageInfo list(DictTypeParam dictTypeParam){
  return this.dictTypeService.findPageBySpec(dictTypeParam);
}
