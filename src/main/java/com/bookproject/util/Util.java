package com.bookproject.util;

import com.bookproject.model.dto.ChapterDTO;
import com.bookproject.model.dto.MapDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/2/24.
 */
@Component
public class Util implements IUtil{

    public String getWebAbsolutePath() {
        return System.getProperty("user.dir")+"\\target\\projectbook-1.0-SNAPSHOT";
    }

    public String getProjectAbsolutePath() {
        return System.getProperty("user.dir");
    }

    public String getJavaAbsolutePath() {
        return getProjectAbsolutePath()+"\\src\\main\\java";
    }

    public Document getDocument(String url) {
        int i=0;
        Document document=null;
        do {
            try {
                if(i>0 && i<10) System.out.println("正在进行第"+i+"尝试重新抓取...");
                document = Jsoup.connect(url).get();
                if (document!=null){
                    System.out.println(url + "\t页面抓取成功");
                    return document;
                }
            } catch (IOException e) {
                System.err.println(url + "\t页面抓取失败:ERROR");
            }
            i++;
        }while (document==null && i<10);
        if (document == null) {
            System.err.println(url + "\t页面抓取失败");
            return null;
        }
        return document;
    }

    @Override
    public Document getDocument(String url, String suffix) {
        Document document=null;
        int i=0;
        do {
            try {
                if(i>0 && i<10) System.out.println("正在进行第"+i+"尝试重新抓取...");
                document = Jsoup.connect(url+suffix).get();
                if (document!=null){
                    System.out.println(url+suffix + "\t页面抓取成功");
                    return document;
                }
            } catch (IOException e) {
                System.err.println(url + suffix + "\t页面抓取失败:ERROR");
            }
            i++;
        }while (document==null && i<10);
        if (document == null) {
            System.err.println(url + "\t页面抓取失败");
            return null;
        }
        return document;
    }

    @Override
    public String replaceString(String s) {
        return s.replace("<div style=\"color:#ff6600;font-size:16px\">\n" +
                "  quanxiaoshuo.com（全小说无弹窗）提供高速文字无弹窗的小说，让你阅读更清爽，请记住我们的网址。\n" +
                " <br> \n" +
                " <table style=\"width:100%; text-align:center;\">\n" +
                "  <tbody>\n" +
                "   <tr>\n" +
                "    <td><script type=\"text/javascript\">ad1();</script></td>\n" +
                "    <td><script type=\"text/javascript\">ad2();</script></td>\n" +
                "    <td><script type=\"text/javascript\">ad3();</script></td>\n" +
                "   </tr>\n" +
                "  </tbody>\n" +
                " </table> \n" +
                "</div> ","");
    }


    public Elements select(Document document, String select) {
        if(document==null) return null;
        System.out.println("正在进行匹配中...");
        Elements elements=document.select(select);
        if(elements.size()==0) {
            System.err.println("无匹配");
            return null;
        }
        else System.out.println("找到匹配项：["+elements.size()+"]项");
        return elements;
    }

    public MapDTO getMapDTO(Element element, String attrKey1, String attrKey2) {
        String key=element.attr(attrKey1);
        String value=element.attr(attrKey2);
        if(key==null || value ==null) return null;
        MapDTO chapterDTO=new MapDTO(key,value);
        System.out.println(chapterDTO);
        return chapterDTO;
    }

    public String getAttrbute(Element element, String key) {
        return element.attr(key);
    }


    public List<MapDTO> getAttrList(String url,String suffix, String select, String attrKey1, String attrKey2) {
        List<MapDTO> list=new ArrayList<MapDTO>();
        MapDTO mapDTO=null;
        Document document=getDocument(url);
        Elements elements=select(document,select);
        for (Element element:elements) {
            if(element==null) continue;
            mapDTO=getMapDTO(element,attrKey1,attrKey2);
            if (mapDTO!=null) {
                list.add(mapDTO);
                mapDTO=null;
            }
        }
        return list;
    }

    @Override
    public boolean WriteFile(String Path, String FileName, List<ChapterDTO> list) {
        PrintWriter printWriter=null;
        File file=new File(Path+"\\"+FileName);
        try {
            System.out.println("\n\n开始创建《"+FileName+"》...");
            if(!file.exists()){
                file.createNewFile();
            }
            System.out.println("《"+FileName+"》创建完成");
            printWriter=new PrintWriter(new FileOutputStream(file),true);
            for (ChapterDTO chapterDTO:list) {
                if (chapterDTO==null) continue;
                System.out.print("开始写入："+chapterDTO.getChapterName()+"...");
                printWriter.write(chapterDTO.getChapterName());
                printWriter.flush();
                printWriter.write(chapterDTO.getChapterContent());
                printWriter.flush();
                System.out.print("写入完成！\n");
            }
            System.out.println("\n\n"+FileName+"已经完成写入了！");
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("文件不存在！");
        } catch (IOException e) {
            System.err.print("写入出错！");
        } finally {
            printWriter.close();
        }
        return false;
    }

    public List<MapDTO> getAttrList(String url,String suffix, String select, String attrKey1) {
        List<MapDTO> list=new ArrayList<MapDTO>();
        MapDTO mapDTO=null;
        Document document=getDocument(url+suffix);
        Elements elements=select(document,select);
        for (Element element:elements) {
            if(element==null) continue;
            mapDTO=new MapDTO(element.text(),getAttrbute(element,attrKey1));
            if (mapDTO!=null) {
                list.add(mapDTO);
                System.out.println("找到书籍：《"+mapDTO.getKey()+"》");
                mapDTO=null;
            }
        }
        return list;
    }




    @Test
    public void Test01(){
        List<ChapterDTO> chapterDTOS=new ArrayList();
        String url="http://quanxiaoshuo.com";
        List<MapDTO> list=getAttrList(url,"/qihuan/11/",".list_content .cc2 a","href");
        for (MapDTO mapDTO:list){
            System.out.println("开始抓取书籍：《"+mapDTO.getKey()+"》....");
            Document document=getDocument(url+mapDTO.getValue());
            Elements elements=select(document,".chapter a");
            if(elements!=null) {
                for (Element element : elements) {
                    MapDTO mapDTO1=getMapDTO(element, "title", "href");
                    Document document1=getDocument(url,mapDTO1.getValue());
                    if (document1!=null) {
                        String txt = select(document1, "#content").html();
                        txt=replaceString(txt);
                        System.out.println(txt);
                        chapterDTOS.add(new ChapterDTO(mapDTO1.getKey(),txt));
                    }
                }
            }
            WriteFile(getWebAbsolutePath()+"\\resources\\book",mapDTO.getKey()+".txt",chapterDTOS);
        }
    }
}
