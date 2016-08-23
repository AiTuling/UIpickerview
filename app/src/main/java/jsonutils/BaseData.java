/**   
 * @Title: BaseData.java 
 * @Package com.huiweishang.model
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 掌易科技 Jason  
 * @date 2015-08-07
 * @version V1.0   
 */
package jsonutils;

import java.io.Serializable;

/**
 * @ClassName: BaseData
 * @Description:
 * @author Jason
 * @date 2015-08-07
 * 
 */

public class BaseData implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1001L;
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

   
}
