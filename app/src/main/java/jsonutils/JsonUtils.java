package jsonutils;


import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/***
 * @author Andy
 * @version [1.0, 2016年8月10日]
 */
public class JsonUtils {
    private final static String TAG = "JsonUtils";

    /***
     * 获取String data中的list数据
     *
     * @param jsonData
     * @return 若解析出错，则返回空
     * @author andy
     */
    public static <T> List<T> getListData(String jsonData, Class<T> clazz) {
        List<T> listData = new ArrayList<T>();
        try {
            Gson mGson = new Gson();
            Type type = JsonUtils.getGsonType(BaseListData.class, clazz);
            BaseListData<T> mBaseListData = mGson.fromJson(jsonData, type);
            mGson.fromJson(jsonData, mBaseListData.getClass());
            listData = mBaseListData.getData();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return listData;
    }

    /***
     * 获取String data中的数据,
     *
     * @param jsonData
     * @return 若解析出错，则返回空
     * @author andy
     */
    public static <T> T getObjectData(String jsonData, Class<T> clazz) {
        T mTData = null;
        try {
            Gson mGson = new Gson();
            Type type = JsonUtils.getGsonType(ObjectData.class, clazz);
            ObjectData<T> mObjectData = mGson.fromJson(jsonData, type);
            mGson.fromJson(jsonData, mObjectData.getClass());
            mTData = mObjectData.getData();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
        return mTData;
    }

    public static <T> ParameterizedType getGsonType(final Class<T> clazz,
                                                    final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return clazz;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
