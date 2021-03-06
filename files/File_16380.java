package org.hswebframework.web.controller.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hswebframework.web.authorization.Permission;
import org.hswebframework.web.authorization.annotation.Authorize;
import org.hswebframework.web.controller.message.ResponseMessage;
import org.hswebframework.web.entity.form.DynamicFormColumnEntity;
import org.hswebframework.web.logging.AccessLogger;
import org.hswebframework.web.service.form.DynamicFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 动�?表�?�
 *
 * @author hsweb-generator-online
 */
@RestController
@RequestMapping("${hsweb.web.mappings.dynamic-form-column:dynamic/form/column}")
@Authorize(permission = "dynamic-form", description = "动�?表�?�管�?�")
@Api(value = "动�?表�?�管�?�",tags = "动�?表�?�-表�?�管�?�")
public class DynamicFormColumnController {

    private DynamicFormService dynamicFormService;

    @Autowired
    public void setDynamicFormService(DynamicFormService dynamicFormService) {
        this.dynamicFormService = dynamicFormService;
    }

    @PatchMapping("/batch")
    @Authorize(action = Permission.ACTION_ADD)
    @ApiOperation("�?存多个表�?�列")
    public ResponseMessage<List<String>> add(@RequestBody List<DynamicFormColumnEntity> columnEntities) {
        return ResponseMessage.ok(dynamicFormService.saveOrUpdateColumn(columnEntities));
    }

    @PatchMapping
    @Authorize(action = Permission.ACTION_ADD)
    @ApiOperation("�?存表�?�列")
    public ResponseMessage<String> add(@RequestBody DynamicFormColumnEntity columnEntity) {
        return ResponseMessage.ok(dynamicFormService.saveOrUpdateColumn(columnEntity));
    }

    @DeleteMapping
    @Authorize(action = Permission.ACTION_DELETE)
    @ApiOperation("删除列")
    public ResponseMessage<List<DynamicFormColumnEntity>> delete(@ApiParam(value = "�?删除的列id,多个列以,分割", example = "1,2,3")
                                                                 @RequestParam String ids) {
        return ResponseMessage.ok(dynamicFormService.deleteColumn(Arrays.asList(ids.split("[,]"))));
    }

    @GetMapping("/{formId}")
    @Authorize(action = Permission.ACTION_GET)
    @ApiOperation("获�?�表�?�的所有列")
    public ResponseMessage<List<DynamicFormColumnEntity>> getByFormId(@PathVariable String formId) {
        return ResponseMessage.ok(dynamicFormService.selectColumnsByFormId(formId));
    }

}
