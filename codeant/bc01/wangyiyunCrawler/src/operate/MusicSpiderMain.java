package operate;

import tool.FileTool;
import tool.URLTool;

import java.util.Scanner;

/**
 * @author Li
 * @date 2019/3/19-12:46
 * 获取api返回的数据，模拟游览器
 */
public class MusicSpiderMain {
    public static void  main(String args[]){


        //id为歌单编号,获取指定歌单的s所有歌曲信息
        String url = "https://music.163.com/api/playlist/detail?id=565454036";

        String _result_str = URLTool.sendGet(url);

        FileTool.write(_result_str, "./src/value.json");
    }



}
