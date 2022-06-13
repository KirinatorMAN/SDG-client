package com.Generator.Client.service;

import java.util.ArrayList;
import java.util.List;

public class SiteInfo {

    private Long id;
    private String url;

//    private List lis = new ArrayList<>();


    public SiteInfo(Long id, String url) {
//        lis.add(id);
//        lis.add(url);
        this.id = id;
        this.url = url;
    }

    public Long getId() {
//        return (Long) lis.get(0);
        return id;
    }

    public void setId(long id) {
//        this.lis.add(0, id);
        this.id = id;
    }

    public String getUrl() {
//        return (String) lis.get(1);
        return url;
    }

    public void setUrl(String url) {
//        this.lis.add(1,url);
        this.url = url;
    }

//    public List getList() {
//        return lis;
//    }

}