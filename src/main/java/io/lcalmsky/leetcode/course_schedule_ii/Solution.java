package io.lcalmsky.leetcode.course_schedule_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] subsequentCourses = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      subsequentCourses[prerequisite[0]]++;
      map.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
    }
    System.out.println("map = " + map);
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (subsequentCourses[i] == 0) {
        queue.offer(i);
      }
    }
    System.out.println("queue = " + queue);
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int course = queue.poll();
      result.add(course);
      if (!map.containsKey(course)) {
        continue;
      }
      for (Integer next : map.get(course)) {
        if (--subsequentCourses[next] == 0) {
          queue.offer(next);
        }
      }
    }
    if (result.size() != numCourses) {
      return new int[0];
    }
    int[] answer = new int[result.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }
}

class AnotherSolution {

  boolean hasCycle = false;
  boolean[] visited;
  boolean[] onPath;
  List<Integer> result;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] map = buildGraph(numCourses, prerequisites);
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    result = new ArrayList<>();
    int[] res = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      traverse(map, i);
    }
    if (hasCycle) {
      return new int[]{};
    }
    Collections.reverse(result);
    for (int i = 0; i < numCourses; i++) {
      res[i] = result.get(i);
    }
    return res;
  }

  public void traverse(List<Integer>[] map, int current) {
    if (hasCycle) {
      return;
    }
    if (onPath[current]) {
      hasCycle = true;
      return;
    }
    if (visited[current]) {
      return;
    }
    visited[current] = true;
    onPath[current] = true;
    for (int next : map[current]) {
      traverse(map, next);
    }
    result.add(current);
    onPath[current] = false;
  }

  public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
    List<Integer>[] arrayLists = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      arrayLists[i] = new ArrayList<>();
    }
    for (int[] pair : prerequisites) {
      arrayLists[pair[1]].add(pair[0]);
    }
    return arrayLists;
  }
}