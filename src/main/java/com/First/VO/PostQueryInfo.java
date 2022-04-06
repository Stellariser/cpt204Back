package com.First.VO;

public class PostQueryInfo {
    private int[] typeList;
    private String query;
    private int pageSize;
    private int pageNumber;


    public PostQueryInfo(int[] typeList, String query, int pageSize, int pageNumber) {
        this.typeList = typeList;
        this.query = query;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public PostQueryInfo() {

    }

    public int[] getTypeList() {
        return typeList;
    }

    public void setTypeList(int[] typeList) {
        this.typeList = typeList;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
