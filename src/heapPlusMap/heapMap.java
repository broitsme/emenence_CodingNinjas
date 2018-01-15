package heapPlusMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class heapMap<E> {
    PriorityQueue<E> queue;
    HashSet<E> map;
    heapMap(){
        queue = new PriorityQueue<>();
        map = new HashSet<>();
    }
    void add(E data){
        queue.add(data);
        map.add(data);
    }
    E extractMin(){
     return queue.peek();
    }
}
