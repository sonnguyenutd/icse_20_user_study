package com.roncoo.pay.permission.exception;

import com.roncoo.pay.common.core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 管�?�系统�?��?模�?�异常.
 *
 * 龙果学院：www.roncoo.com
 * 
 * @author：shenjialong
 */
public class PermissionException extends BizException {
	private static final long serialVersionUID = -5371846727040729628L;
	private static final Logger logger = LoggerFactory.getLogger(PermissionException.class);
	/** 该用户没有分�?�?��?��?��? */
	public static final Integer PERMISSION_USER_NOT_MENU = 1001;
	/** 根�?�角色查询�?��?�出现错误 **/
	public static final Integer PERMISSION_QUERY_MENU_BY_ROLE_ERROR = 1002;
	/** 分�?�?��?��?��?时，角色�?能为空 **/
	public static final Integer PERMISSION_ASSIGN_MENU_ROLE_NULL = 1003;
	/** 对接龙果平�?�用户体系异常 **/
	public static final Integer RONCOO_NETWORK_EXCEPTION = 1004;

	public PermissionException() {
	}

	public PermissionException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public PermissionException(int code, String msg) {
		super(code, msg);
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public PermissionException newInstance(String msgFormat, Object... args) {
		return new PermissionException(this.code, msgFormat, args);
	}

	public PermissionException print() {
		logger.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
