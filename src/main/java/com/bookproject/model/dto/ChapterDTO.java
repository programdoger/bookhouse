package com.bookproject.model.dto;

/**
 * Created by Administrator on 2017/2/27.
 */
public class ChapterDTO {
    private String chapterName;
    private String chapterContent;

    public ChapterDTO() {
    }

    public ChapterDTO(String chapterName, String chapterContent) {
        this.chapterName = chapterName;
        this.chapterContent = chapterContent;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    @Override
    public String toString() {
        return "章节名称："+chapterName+"章节内容："+chapterContent;
    }
}
