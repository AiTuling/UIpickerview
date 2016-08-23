package jsonutils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Andy on 2016/8/23.
 */
public class AssetsUtils {
    /**
     * 从assets文件中获取文件内容，返回String类型
     *
     * @param mContext
     * @param fileName
     * @return
     * @author andy
     */
    public static String getStringDataFromAssets(Context mContext,
                                                 String fileName) {
        try {
            InputStream is = mContext.getAssets().open(fileName);
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            String jsonStr = new String(buffer, "utf-8");

            return jsonStr;

        } catch (Exception e) {
            return null;
        }
    }
}
