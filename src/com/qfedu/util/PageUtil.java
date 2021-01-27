package com.qfedu.util;

public class PageUtil {
    private int dateCount;  //数据总条数
    private int pageSize;  //一页有几条数据
    private int pageNo;  //当前页数
    private int pageCount; //总页数

    public PageUtil() {
    }

    public PageUtil(int dateCount, int pageSize, int pageNo, int pageCount) {
        this.dateCount = dateCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.pageCount = pageCount;
    }

    public int getDateCount() {
        return dateCount;
    }

    public void setDateCount(int dateCount) {
        this.dateCount = dateCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageCount() {
        if(dateCount%pageSize==0){
            pageCount= dateCount / pageSize;
        }else {
            pageCount= dateCount / pageSize +1 ;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
