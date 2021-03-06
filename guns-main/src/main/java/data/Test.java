package data;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String filePath = "D:\\self\\WebStorm工作区\\3d-force-graph-demo\\datasets\\data.json";

        FileReader fileReader = new FileReader(filePath);
        String text = fileReader.readString();

        Map dataMap = JSON.parseObject(text, Map.class);
        List<Map<String, Object>> nodes = (List<Map<String, Object>>) dataMap.get("nodes");
        List<Map> links = (List<Map>) dataMap.get("links");

        List<Map<String, Object>> nodes1 = new ArrayList<>();
        List<Map<String, Object>> nodes2 = new ArrayList<>();
        List<Map<String, Object>> nodes3 = new ArrayList<>();
        List<Map<String, Object>> nodes4 = new ArrayList<>();
        for (Map map : nodes) {
            Object type = map.get("type");
            List parentNode = getParentNode(map, links);
            map.put("pid", parentNode);

            if ("Level3".equals(type)) {
                nodes3.add(map);
            } else if ("Level4".equals(type)) {
                nodes4.add(map);
            } else if ("secondLevel".equals(type)) {
                nodes2.add(map);
            } else if ("topLevel".equals(type)) {
                nodes1.add(map);
            }
        }

        List<Position> positions1 = generatePosition(1, nodes1, 0);
        List<Position> positions2 = generatePosition(75, nodes2, Math.PI * 2);
        List<Position> positions3 = generatePosition(150, nodes3, Math.PI / 6);
        List<Position> positions4 = generatePosition(225, nodes4, Math.PI / 8);

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        for (Map map : nodes) {
            Object type = map.get("type");
            Position position = null;
            if ("Level3".equals(type)) {
                position = positions3.get(index3++);
            } else if ("Level4".equals(type)) {
                position = positions4.get(index4++);
            } else if ("secondLevel".equals(type)) {
                position = positions2.get(index2++);
            } else if ("topLevel".equals(type)) {
                position = positions1.get(index1++);
            }
            if (null != position) {
                map.put("fz", position.z);
                map.put("fy", position.y);
                map.put("fx", position.x);
            }
        }

        dataMap.put("nodes", nodes);
        String dataJson = JSON.toJSONString(dataMap);
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(dataJson);
    }

    static Map<String, Position> positionMap = new HashMap<>();

    public static List<Position> generatePosition(double radius, List<Map<String, Object>> nodes, double levelStep) {
        List<Position> positions = new ArrayList<>();
        Map<Position, List<Position>> nodesPostionMap = new HashMap<>();
        for (Map node : nodes) {
            List<String> pids = (List<String>) node.get("pid");
            String pid = "000";
            if (pids.size() > 0) {
                pid = pids.get(0);
            }
            Position parent = positionMap.get(pid);
            List<Position> subPositions = new ArrayList<>();
            if (parent != null) {
                subPositions = nodesPostionMap.get(parent);
                if (subPositions == null) {
                    subPositions = new ArrayList<>();
                }
            }
            Position position = maxDistancePosition(subPositions, radius, parent, levelStep);
            subPositions.add(position);
            if (parent != null) {
                nodesPostionMap.put(parent, subPositions);
            } else {
                positions.add(position);
            }
            positionMap.put(node.get("id").toString(), position);
        }
        for (List<Position> subPositions : nodesPostionMap.values()) {
            positions.addAll(subPositions);
        }
        return positions;
    }

    private static Position maxDistancePosition(List<Position> positions, double r, Position parent, double levelStep) {
        if (positions.size() == 0 && parent != null) {
            Position position = new Position();
            position.x = Math.sin(parent.a) * Math.cos(parent.b) * r;
            position.y = Math.sin(parent.a) * Math.sin(parent.b) * r;
            position.z = Math.cos(parent.a) * r;
            return position;
        }
        double randomA = Math.random() * Math.PI;
        double randomB = Math.random() * Math.PI * 2;
        if (positions.size() == 0) {
            Position position = new Position();
            position.x = Math.sin(randomA) * Math.cos(randomB) * r;
            position.y = Math.sin(randomA) * Math.sin(randomB) * r;
            position.z = Math.cos(randomA) * r;
            position.a = randomA;
            position.b = randomB;
            return position;
        }

        double initA = 0;
        double initB = 0;
        double maxA = Math.PI;
        double maxB = Math.PI * 2;
        if (parent != null) {
            initA = parent.a - levelStep;
            initB = parent.b - levelStep;
            maxA = parent.a + levelStep;
            maxB = parent.b + levelStep;
        }

        boolean flag = true;
        double valueA = 0;
        double valueB = 0;
        while (flag) {
            flag = false;
            valueA = initA + Math.random() * (maxA - initA);
            valueB = initB + Math.random() * (maxB - initB);
            Position p = new Position();
            p.x = Math.sin(valueA) * Math.cos(valueB) * r;
            p.y = Math.sin(valueA) * Math.sin(valueB) * r;
            p.z = Math.cos(valueA) * r;
            for (Position position : positions) {
                double distance = position.distance(p);
                if (distance < 1) {
                    flag = true;
                }
            }
        }
        Position position = new Position();
        position.x = Math.sin(valueA) * Math.cos(valueB) * r;
        position.y = Math.sin(valueA) * Math.sin(valueB) * r;
        position.z = Math.cos(valueA) * r;
        position.a = valueA;
        position.b = valueB;
        return position;

    }

    static class Position {
        double x;
        double y;
        double z;
        double a;
        double b;

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        public double distance(Position p) {

            return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2) + Math.pow((p.z - z), 2));
        }
    }

    private static List<String> getParentNode(Map node, List<Map> links) {
        Object id = node.get("id");
        ArrayList<String> parents = new ArrayList<>();
        for (Map map : links) {
            String target = map.get("target").toString();
            String source = map.get("source").toString();
            if (id.toString().equals(target)) {
                parents.add(source);
            }
        }
        return parents;
    }

}
