package data;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;

import java.util.*;

public class PrepareData {

    public static void main(String[] args) {
        String filePath = "D:\\self\\WebStorm工作区\\3d-force-graph-demo\\datasets\\data.json";

        FileReader fileReader = new FileReader(filePath);
        String text = fileReader.readString();

        Map dataMap = JSON.parseObject(text, Map.class);
        List<Map<String, Object>> nodes = (List<Map<String, Object>>) dataMap.get("nodes");
        List<Map<String, Integer>> links = (List<Map<String, Integer>>) dataMap.get("links");

        int limit = 829;
        String suffix = "有限公司";
        for (int i = 29; i < limit; i++) {
            HashMap<String, Object> node = new HashMap<>();
            node.put("id", i);
            node.put("name", getRandomChar() + suffix);
            node.put("type", "Level4");
            nodes.add(node);
        }

        for (int i = 29; i < limit; i++) {
            Map<String, Object> node = nodes.get(i);
            List<Map<String, Integer>> linkList = getLinks(node);
            links.addAll(linkList);
        }

        dataMap.put("nodes", nodes);
        dataMap.put("links", links);
        String dataJson = JSON.toJSONString(dataMap);

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(dataJson);
    }

    private static int getSonNodeNum(Map<String, Object> node, List<Map<String, Integer>> links) {
        int num = 0;
        Object id = node.get("id");
        for (Map map : links) {
            Object target = map.get("target");
            int source = (int) map.get("source");
            if (source > 15 && id == target) {
                num++;
            }
        }
        return num;
    }

    /**
     * 生成随机关系
     *
     * @author liunanlin
     * @Date 2021/3/4 9:41
     */
    private static List<Map<String, Integer>> getLinks(Map<String, Object> node) {
        ArrayList arrayList = new ArrayList();

        int[] min = {0, 6, 9, 20, 23, 26};
        int[] max = {0, 8, 19, 22, 25, 28};

        int linkNum = getRandomNum(1, 5);
        HashMap<String, Integer> link = new HashMap<>();
        link.put("source", getRandomNum(min[linkNum], max[linkNum]));
        link.put("target", (Integer) node.get("id"));

        if (!arrayList.contains(link)) {
            arrayList.add(link);
        }

        return arrayList;
    }

    /**
     * 获取范围内随机数
     *
     * @author liunanlin
     * @Date 2021/3/4 9:51
     */
    private static int getRandomNum(int min, int max) {
        int random = 0;
        do {
            random = (int) (Math.random() * 100);
        } while (random < min || random > max);
        return random;
    }

    /**
     * 生成两个随机汉字
     *
     * @author liunanlin
     * @Date 2021/3/4 9:33
     */
    private static String getRandomChar() {
        char word1 = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
        char word2 = (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
        String result = String.valueOf(word1) + String.valueOf(word2);
        return result;
    }

}