package com.minixiao.domain;

/**
 * Created by HealerJean on 2017/3/20.
 */
@Entity
public class Subdomain {
    int id;
    String name;
    String href;
    String subdomain;
    String  createtime;
    public Subdomain() {
    }

    public Subdomain(String name, String href, String subdomain) {
        this.name = name;
        this.href = href;
        this.subdomain = subdomain;
    }

    public Subdomain(int id, String name, String href, String subdomain) {
        this.id = id;
        this.name = name;
        this.href = href;
        this.subdomain = subdomain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public Mnxra(int id, String name, String href, String subdomain, String createtime) {
        this.id = id;
        this.name = name;
        this.href = href;
        this.subdomain = subdomain;
        this.createtime = createtime;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }




}
