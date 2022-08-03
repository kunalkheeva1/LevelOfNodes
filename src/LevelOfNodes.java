import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Pair{
    int node;
    int level;
    Pair(int node, int level){
        this.node = node;
        this.level =level;
    }
}


public class LevelOfNodes{

    static int levelOfNode(ArrayList<ArrayList<Integer>> adj, int v, int x){
        if(x==0){
            return 0;
        }
        Queue<Pair> q =new LinkedList<>();
        Pair pair =new Pair(0,0);
        q.add(pair);

        int [] visited =new int[v];
        for(int i =0; i<v; i++){
            visited[i]=0;
        }

        while(!q.isEmpty()){
            Pair pp = q.remove();
            int current = pp.node;
            int level = pp.level;
            for(int i =0; i<adj.get(current).size(); i++){
                int connection = adj.get(current).get(i);
                if(visited[connection]==0){
                    visited[connection]=1;
                    if(connection ==x){
                        return level +1;
                    }else{
                        Pair pair1 = new Pair(connection, level +1);
                        q.add(pair1);
                    }
                }
            }
        }return -1;




    }






    public static void main(String[] args) {

    }
}
