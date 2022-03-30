package com.First.VO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

public class PageInfo<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private int pageNum;
    private int pageSize;
    private long total;
    private int pages;
    private List<T> list;
    private boolean isFirstPage = false;
    private boolean isLastPage = false;

    public PageInfo(){

    }
    public PageInfo(List<T> list) {
        if(list instanceof Page){
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection){
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
        if (list instanceof Collection) {
            judgePageBoundary();
        }
    }

    private void judgePageBoundary() {
        isFirstPage = pageNum ==1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum(){
        return pageNum;
    }

    public void setPageNum(int pageNum){
        this.pageNum = pageNum;
    }

    public int getPageSize(){
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        System.out.println("Total posts are "+total);
        return total;
    }

    public void setTotal(long totla){
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages){
        this.pages = pages;
    }

    public List<T> getList(){
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage){
        this.isLastPage = isLastPage;
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(pages);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append("}");
        return sb.toString();
    }



    
}
