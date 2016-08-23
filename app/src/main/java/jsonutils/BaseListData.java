/**   
 * @Title: BaseData.java 
 * @Package com.huiweishang.model
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 掌易科技 Jason  
 * @date 2015-08-07
 * @version V1.0   
 */
package jsonutils;

import java.util.List;

/**
 * @ClassName: BaseData
 * @Description:
 * @author Jason
 * @date 2015-08-07
 * 
 */

public class BaseListData<T> extends BaseData {
    /**
     * 
     */
    private static final long serialVersionUID = 1002L;

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
