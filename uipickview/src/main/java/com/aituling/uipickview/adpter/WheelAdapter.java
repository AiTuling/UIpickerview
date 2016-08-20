package com.aituling.uipickview.adpter;

/**
 * 适配器基类
 * Created by Andy on 2016/8/20.
 */
public interface WheelAdapter<T>{

    /**
     * Gets items count
     * @return items size
     */
    int getItemsCount();

    /**
     * Gets a wheel item by index.
     * @param index the item index
     * @return the wheel item text or null
     */
    T getItem(int index);

    /**
     * Gets maximum item length. It is used to determine the wheel width.
     * If -1 is returned there will be used the default wheel width.
     * @param o
     * @return the maximum item length or -1
     */
    int indexOf(T o);
}
