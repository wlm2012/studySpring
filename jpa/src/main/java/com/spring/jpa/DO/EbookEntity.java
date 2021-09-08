package com.spring.jpa.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ebook", schema = "study")
public class EbookEntity {
    private long id;
    private long category1Id;
    private long category2Id;
    private String cover;
    private String description;
    private int docCount;
    private String name;
    private int viewCount;
    private int voteCount;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category1id")
    public long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(long category1Id) {
        this.category1Id = category1Id;
    }

    @Basic
    @Column(name = "category2id")
    public long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(long category2Id) {
        this.category2Id = category2Id;
    }

    @Basic
    @Column(name = "cover")
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "doc_count")
    public int getDocCount() {
        return docCount;
    }

    public void setDocCount(int docCount) {
        this.docCount = docCount;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "view_count")
    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "vote_count")
    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EbookEntity that = (EbookEntity) o;
        return id == that.id && category1Id == that.category1Id && category2Id == that.category2Id && docCount == that.docCount && viewCount == that.viewCount && voteCount == that.voteCount && Objects.equals(cover, that.cover) && Objects.equals(description, that.description) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category1Id, category2Id, cover, description, docCount, name, viewCount, voteCount);
    }
}
