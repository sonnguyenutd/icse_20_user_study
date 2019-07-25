package org.jeecgframework.web.system.sms.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MutiLangUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.pojo.base.TSNotice;
import org.jeecgframework.web.system.pojo.base.TSNoticeReadUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.sms.entity.TSSmsEntity;
import org.jeecgframework.web.system.sms.service.TSSmsServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



/**   
 * @Title: Controller
 * @Description: 消�?��?��?记录表
 * @author onlineGenerator
 * @date 2014-09-18 00:01:53
 * @version V1.0   
 *
 */
//@Scope("prototype")
@Controller
@RequestMapping("/tSSmsController")
public class TSSmsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSSmsController.class);

	@Autowired
	private TSSmsServiceI tSSmsService;
	@Autowired
	private SystemService systemService;

	/**
	 * 消�?��?��?记录表列表 页�?�跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSSms")
	public ModelAndView tSSms(HttpServletRequest request) {
		return new ModelAndView("system/sms/tSSmsList");
	}

	/**
	 * easyui AJAX请求数�?�
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TSSmsEntity tSSms,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSSmsEntity.class, dataGrid);
		//查询�?�件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSSms, request.getParameterMap());
		try{
		//自定义追加查询�?�件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSSmsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除消�?��?��?记录表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSSmsEntity tSSms, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tSSms = systemService.getEntity(TSSmsEntity.class, tSSms.getId());
		message = "消�?��?��?记录表删除�?功";
		try{
			tSSmsService.delete(tSSms);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "消�?��?��?记录表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批�?删除消�?��?��?记录表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "消�?��?��?记录表删除�?功";
		try{
			for(String id:ids.split(",")){
				TSSmsEntity tSSms = systemService.getEntity(TSSmsEntity.class, 
				id
				);
				tSSmsService.delete(tSSms);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "消�?��?��?记录表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加消�?��?��?记录表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSSmsEntity tSSms, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "消�?��?��?记录表添加�?功";
		try{
			tSSmsService.save(tSSms);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "消�?��?��?记录表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新消�?��?��?记录表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSSmsEntity tSSms, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "消�?��?��?记录表更新�?功";
		TSSmsEntity t = tSSmsService.get(TSSmsEntity.class, tSSms.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSSms, t);
			tSSmsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "消�?��?��?记录表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 消�?��?��?记录表新增页�?�跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSSmsEntity tSSms, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSSms.getId())) {
			tSSms = tSSmsService.getEntity(TSSmsEntity.class, tSSms.getId());
			req.setAttribute("tSSmsPage", tSSms);
		}
		return new ModelAndView("system/sms/tSSms-add");
	}
	/**
	 * 消�?��?��?记录表编辑页�?�跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSSmsEntity tSSms, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSSms.getId())) {
			tSSms = tSSmsService.getEntity(TSSmsEntity.class, tSSms.getId());
			req.setAttribute("tSSmsPage", tSSms);
		}
		return new ModelAndView("system/sms/tSSms-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("system/sms/tSSmsUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response

	@RequestMapping(params = "exportXls")
	public void exportXls(TSSmsEntity tSSms,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "消�?��?��?记录表";
			// 根�?��?览器进行转�?，使其支�?中文文件�??
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			CriteriaQuery cq = new CriteriaQuery(TSSmsEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSSms, request.getParameterMap());
			
			List<TSSmsEntity> tSSmss = this.tSSmsService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExportParams("消�?��?��?记录表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
					"导出信�?�"), TSSmsEntity.class, tSSmss);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}	 */
	/**
	 * 导出excel 使模�?�
	 * 
	 * @param request
	 * @param response
	 
	@RequestMapping(params = "exportXlsByT")
	public void exportXlsByT(TSSmsEntity tSSms,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "消�?��?��?记录表";
			// 根�?��?览器进行转�?，使其支�?中文文件�??
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			workbook = ExcelExportUtil.exportExcel(new ExportParams("消�?��?��?记录表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
					"导出信�?�"), TSSmsEntity.class, null);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//			MultipartFile file = entity.getValue();// 获�?�上传文件对象
//			ImportParams params = new ImportParams();
//			params.setTitleRows(2);
//			params.setSecondTitleRows(1);
//			params.setNeedSave(true);
//			try {
//				List<TSSmsEntity> listTSSmsEntitys = 
//					(List<TSSmsEntity>)ExcelImportUtil.importExcelByIs(file.getInputStream(),TSSmsEntity.class,params);
//				for (TSSmsEntity tSSms : listTSSmsEntitys) {
//					tSSmsService.save(tSSms);
//				}
//				j.setMsg("文件导入�?功�?");
//			} catch (Exception e) {
//				j.setMsg("文件导入失败�?");
//				logger.error(ExceptionUtil.getExceptionMessage(e));
//			}finally{
//				try {
//					file.getInputStream().close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return j;
	}


	/**
	 * 今天需�?�??醒的�?系统信�?�】
	 * 
	 */
	@RequestMapping(params = "getMsgs")
	@ResponseBody
	public AjaxJson getMsgs(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		List<TSSmsEntity> list = new ArrayList<TSSmsEntity>();
		try {
			String curUser = ResourceUtil.getSessionUser().getUserName();
			String isSend = ResourceUtil.getConfigByName("sms.tip.control");
			if("1".equals(isSend)){
				DataGrid dataGrid = new DataGrid();
				dataGrid.setRows(20);//查出最新20�?�记录
				CriteriaQuery cq = new CriteriaQuery(TSSmsEntity.class, dataGrid);
				cq.eq("esType", "3");
				cq.eq("esReceiver", curUser);
				cq.eq("isRead", 0);
				cq.addOrder("esSendtime", SortDirection.desc);
				cq.add();
				this.tSSmsService.getDataGridReturn(cq, true);
				list = dataGrid.getResults();
				int size = list.size();
				//3.获�?�当�?时间是�?�有�??醒的系统消�?�
				if(size>0){
					for(TSSmsEntity tSSmsEntity:list){
						//查询之�?�，�?�时将该�?�信�?�置为�?已�??醒“
						if("1".equals(tSSmsEntity.getEsStatus())){
							tSSmsEntity.setEsStatus("2");
							this.tSSmsService.saveOrUpdate(tSSmsEntity);
						}
					}
					j.setSuccess(true);
					j.setMsg("您收到系统消�?�，请到�?控制�?��?�】下\"系统消�?�\"�?��?�查看�?");
				} else {
					j.setSuccess(true);
					j.setMsg("");
				}
		    }
		} catch (Exception e) {
			j.setSuccess(false);
			logger.info("获�?��?��?信�?�失败");
		}
		return j;
	}

	/**
	 * 当�?登录人当日�?系统信�?�】详细信�?�
	 * 
	 */
	
	@RequestMapping(params = "getSysInfos")
	public ModelAndView getSysInfos(HttpServletRequest request) {
		
		//1. �?�得系统当�?登录人ID
		String curUser = ResourceUtil.getSessionUser().getUserName();
		//2.查询当�?登录人的消�?�类型为"3",并且在查询的节点之�?�一个�?时内的信�?�
		//当�?时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sdf.format(new Date());
		List<TSSmsEntity> list = this.tSSmsService.getMsgsList(curUser,curDate);
		request.setAttribute("smsList", list);
		
		return new ModelAndView("system/sms/tSSmsDetailList");
	}

	
	/**
	 * 通知列表（阅读）
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goMySmsList")
	public ModelAndView goMySmsList(HttpServletRequest request) {
		return new ModelAndView("system/sms/mySmsList");
	}
	/**
	 * 通知详情
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "goSmsDetail")
	public ModelAndView goSmsDetail(TSSmsEntity tSSms,HttpServletRequest request) {
		if (StringUtil.isNotEmpty(tSSms.getId())) {
			tSSms = this.systemService.getEntity(TSSmsEntity.class, tSSms.getId());
			request.setAttribute("tSSms", tSSms);
			if(tSSms.getIsRead() == 0){
				tSSms.setIsRead(1);
				systemService.saveOrUpdate(tSSms);
			}
		}
		return new ModelAndView("system/sms/mySms-info");
	}
	
	/**
	 * 阅读通知
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "updateSmsRead")
	@ResponseBody
	public AjaxJson updateSmsRead(TSSmsEntity tSSms,HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		try {
			if (StringUtil.isNotEmpty(tSSms.getId())) {
				tSSms = this.systemService.getEntity(TSSmsEntity.class, tSSms.getId());
				if(tSSms.getIsRead() == 0){
					tSSms.setIsRead(1);
					systemService.saveOrUpdate(tSSms);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}
	
	/**
	 * easyui AJAX请求数�?�
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "mydatagrid")
	public void mydatagrid(TSSmsEntity tSSms,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSSmsEntity.class, dataGrid);
		//查询�?�件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSSms, request.getParameterMap());
		String curUser = ResourceUtil.getSessionUser().getUserName();
		try{
		//自定义追加查询�?�件
			cq.eq("esType", "3");
			cq.eq("esReceiver", curUser);
//			cq.eq("isRead", 0);
//			cq.addOrder("isRead", SortDirection.asc);
			cq.addOrder("esSendtime", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSSmsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * �?�得�?�读的消�?�
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "getMessageList")
	@ResponseBody
	public AjaxJson getMessageList(HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		try {
			j.setObj(0);
			List<TSSmsEntity> list = new ArrayList<TSSmsEntity>();
			//1. �?�得系统当�?登录人ID
			String curUser = ResourceUtil.getSessionUser().getUserName();
			//2.查询当�?登录人的消�?�类型为"3"
//			//当�?时间
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String curDate = sdf.format(new Date());		
		
			String isSend = ResourceUtil.getConfigByName("sms.tip.control");
			if("1".equals(isSend)){
				DataGrid dataGrid = new DataGrid();
				dataGrid.setRows(20);//查出最新20�?�记录
				CriteriaQuery cq = new CriteriaQuery(TSSmsEntity.class, dataGrid);
				cq.eq("esType", "3");
				cq.eq("esReceiver", curUser);
				cq.eq("isRead", 0);
				cq.addOrder("esSendtime", SortDirection.desc);
				cq.add();
				this.tSSmsService.getDataGridReturn(cq, true);
//				list = this.tSSmsService.getMsgsList(curUser,curDate);
				list = dataGrid.getResults();
				//将List转�?��?JSON存储
				JSONArray result = new JSONArray();
		        if(list!=null && list.size()>0){
		        	for(int i=0;i<list.size();i++){
		    			JSONObject jsonParts = new JSONObject();
		    			jsonParts.put("id", list.get(i).getId());
		    			jsonParts.put("esTitle", list.get(i).getEsTitle());
		    			jsonParts.put("esSender", list.get(i).getEsSender());
		    			jsonParts.put("esContent", list.get(i).getEsContent());
		    			jsonParts.put("esSendtime", list.get(i).getEsSendtime());
		    			jsonParts.put("esStatus", list.get(i).getEsStatus());
		    			if(list.get(i).getEsSendtime()!=null){
		    				SimpleDateFormat sdformat = new SimpleDateFormat("h:mm a");
		    				jsonParts.put("esSendtimeTxt", sdformat.format(list.get(i).getEsSendtime()));
		    			}
		    			result.add(jsonParts);	
		    		}
		        	j.setObj(list.size());
				}
				
				Map<String,Object> attrs = new HashMap<String, Object>();
				attrs.put("messageList", result);
				String tip = MutiLangUtil.getLang("message.tip");
				attrs.put("tip", tip);
				String seeAll = MutiLangUtil.getLang("message.seeAll");
				attrs.put("seeAll", seeAll);
				j.setAttributes(attrs);
		    }
		} catch (Exception e) {
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * 阅读消�?�(消�?�状�?置�?已�??醒)
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "readMessage")
	@ResponseBody
	public AjaxJson readMessage(String messageId,HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		try {
			if(StringUtil.isNotEmpty(messageId)){
				TSSmsEntity tSSmsEntity = this.systemService.get(TSSmsEntity.class, messageId);
				if(tSSmsEntity!=null){
					tSSmsEntity.setEsStatus("2");
					this.tSSmsService.saveOrUpdate(tSSmsEntity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}
	
	/**
	 * 获�?�消�?�
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "getMsg")
	@ResponseBody
	public AjaxJson getMsg(String msgId,HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		try {
			if(StringUtil.isNotEmpty(msgId)){
				TSSmsEntity tSSmsEntity = this.systemService.get(TSSmsEntity.class, msgId);
				Map<String,Object> attrs = new HashMap<String, Object>();
				attrs.put("msginfo", tSSmsEntity);
				j.setAttributes(attrs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return j;
	}
}