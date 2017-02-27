package com.bookproject.util;

import com.bookproject.model.dto.ChapterDTO;
import com.bookproject.model.dto.MapDTO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/24.
 */
public interface IUtil {
    /**
     * 获取基于webapp的绝对路径
     * @return
     */
    String getWebAbsolutePath();

    /**
     * 获取当前项目根目录的绝对路径
     * @return
     */
    String getProjectAbsolutePath();

    /**
     * 获取基于类路径的绝对路径
     * @return
     */
    String getJavaAbsolutePath();
    /**
     * 获取包含该地址内容的Dom文档
     * @return
     */
    Document getDocument(String url);

    /**
     * 抓取页面
     * @param url
     * @param suffix
     * @return
     */
    Document getDocument(String url,String suffix);

    /**
     * 替换文档
     * @param s
     * @return
     */
    String replaceString(String s);
    /***
     * 装饰Jsoup的select方法加入成功和失败的提示
     */
    Elements select(Document document,String select);

    /**
     * 抓取章节名  和对应的URL地址
     * @param element
     * @return
     */
    MapDTO getMapDTO(Element element, String attrKey1, String attrKey2);

    /**
     * 抓取一个节点一个属性的值
     * @param element
     * @param attrKey1
     * @return
     */
    String getAttrbute(Element element, String attrKey1);

    /**
     * 抓取一个URL（url+suffix）中匹配select选择器的所有节点的attKey1和attrKey2的value值
     * @param url
     * @param suffix
     * @param select
     * @param attrKey1
     * @param attrKey2
     * @return
     */
    List<MapDTO> getAttrList(String url,String suffix, String select, String attrKey1, String attrKey2);

    /**
     * @param Path 写入文件的路径
     * @param FileName 文件的名称（书籍名称）
     * @param list 包含整本书所有章节和内容的List集合
     * @return boolean 是否写入成功
     */
    boolean WriteFile(String Path, String FileName, List<ChapterDTO> list);

}
