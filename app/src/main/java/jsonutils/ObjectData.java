/*
 * 文 件 名:  ClassData.java
 * 版    权:  深圳汇微商科技有限公司
 * 描    述:  <文件主要内容描述>
 * 作    者:  Andy
 * 创建时间:  2015-8-12 上午11:14:46
 */
package jsonutils;

/**
 * 对象类
 * 
 * @author Andy
 * @version [V1.0, 2015-8-12]
 */
public class ObjectData<T> extends BaseData {
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1003L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
