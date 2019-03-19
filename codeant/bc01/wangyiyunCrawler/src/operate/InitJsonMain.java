package operate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import entity.MusicMsg;
import tool.FileTool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Li
 * @date 2019/3/19-17:56
 * 该文件是处理api返回的json数据的,获取歌单里面的id，name
 */
public class InitJsonMain {
    public static void  main(String args[]){
        String path = InitJsonMain.class.getClassLoader().getResource("value.json").getPath();

        String temp = "";

        Map<String, Object> _result = getInitJson(readJsonFile(path));

        temp = getValueFromMap("result", _result).toString();
        _result = getInitJson(temp);

        //这个转换出来的是JSONArray的字符串
        temp = (String) getValueFromMap("tracks", _result).toString();
        //String转JSONArray
        JSONArray j = JSONArray.parseArray(temp);

        //JSONArray转list
        List<MusicMsg> list = new ArrayList<>();

        //每个对象都是纯的音乐的信息
        for(int i = 0; i < j.size();i++){
            list.add(JSON.parseObject(j.get(i).toString(), MusicMsg.class));
        }

        for(MusicMsg m : list){
            System.out.println("id:" + m.getId() + "  name: " + m.getName());
        }

        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        FileTool.write(array.toString(), "./src/init_value.json");

    }

    private static Map<String, Object> getInitJson(String s) {
        return JSON.parseObject(s,Map.class);
    }

    private static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object getValueFromMap(Object key, Map<String, Object> _temp_map){
        return _temp_map.get(key);
    }


}
