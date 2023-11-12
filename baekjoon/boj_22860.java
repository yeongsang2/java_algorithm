package baekjoon;

import java.io.BufferedReader;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_22860 {

    static class Folder{

        String name;
        List<Folder> folderList;
        List<String> files;
        public Folder(String name){
            this.name = name;
            this.folderList = new LinkedList<>();
            this.files =  new LinkedList<>();
        }
    }
    static Map<String, Folder> map;
    static int n;
    static int m;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();
        n = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n+m ; i++) {
            st = new StringTokenizer(br.readLine());
            String upperFolder = st.nextToken();
            String name = st.nextToken();
            Integer flag= Integer.parseInt(st.nextToken());

            // 폴더 일 경우
            if(flag == 1){ //갖고 있어
                if(map.containsKey(upperFolder)){
                    map.get(upperFolder).folderList.add(new Folder(name));
                    if(!map.containsKey(name)){
                        map.put(name, new Folder(name));
                    }
                }else {
                    Folder folder = new Folder(upperFolder);
                    map.put(upperFolder, folder);
                    map.get(upperFolder).folderList.add(new Folder(name));
                    if(!map.containsKey(name)){
                        map.put(name, new Folder(name));
                    }
                }
            }else{ // 파일 일경우
                if(map.containsKey(upperFolder)){
                    map.get(upperFolder).files.add(name);
                }else {
                    Folder folder = new Folder(upperFolder);
                    map.put(upperFolder, folder);
                    map.get(upperFolder).files.add(name);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while ( q-- >0 ){
            String s = br.readLine();
            cnt = 0;
            if(s.equals("main")){
                List<String> path = dfs("main", new LinkedList<>());
                sb.append(Integer.toString(path.size()) + " "+ Integer.toString(cnt)).append("\n");
            }else {
                String[] split = s.split("/");
                String search = split[split.length-1];
                List<String> path = dfs(search, new LinkedList<>());
                sb.append(Integer.toString(path.size()) + " "+ Integer.toString(cnt)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static List<String> dfs(String fName, List<String> path){

        Folder folder = map.get(fName);
        List<Folder> folderList = folder.folderList;
        List<String> file = folder.files;

        for (String f : file) {
            if (!path.contains(f)) {
                path.add(f);
            }
            cnt++;
        }

        for (Folder f : folderList){
            Folder nowF = map.get(f.name);
            dfs(nowF.name, path);
        }
        return path;
    }
}
