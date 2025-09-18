package com.wackstr.leetcode;

import java.util.*;

/*
2025-09-18 3408
 */
public class TaskManager_3408 {
    public record Task(int TaskId, int Priority){}
    private final Map<Integer, Integer> taskUserMap;
    private final PriorityQueue<Task> taskQueue;
    private final Map<Integer, Integer> taskPriorityMap;

    public TaskManager_3408(List<List<Integer>> tasks) {
        taskUserMap = new HashMap<>();
        taskPriorityMap = new HashMap<>();
        taskQueue = new PriorityQueue<>(
                (a,b) -> a.Priority() == b.Priority() ?
                        b.TaskId() - a.TaskId() :
                        b.Priority() - a.Priority());
        for(List<Integer> task : tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int taskPriority = task.get(2);
            Task currTask = new Task(taskId, taskPriority);
            taskPriorityMap.put(taskId, taskPriority);
            taskUserMap.put(taskId, userId);
            taskQueue.offer(currTask);
        }

    }

    public void add(int userId, int taskId, int priority) {
        taskUserMap.put(taskId, userId);
        taskPriorityMap.put(taskId, priority);
        taskQueue.offer(new Task(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        taskPriorityMap.put(taskId, newPriority);
        taskQueue.offer(new Task(taskId, newPriority));
    }

    public void rmv(int taskId) {
        taskPriorityMap.remove(taskId);
        taskUserMap.remove(taskId);
    }

    public int execTop() {
        if(taskPriorityMap.isEmpty()) return -1;
        while(!taskQueue.isEmpty()){
            Task task = taskQueue.poll();
            if(taskPriorityMap.containsKey(task.TaskId()) &&
                    taskPriorityMap.get(task.TaskId()) == task.Priority()){
                int userId = taskUserMap.get(task.TaskId());
                rmv(task.TaskId());
                return userId;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TaskManager_3408 tm = new TaskManager_3408(
                List.of(
                        List.of(1,101,10),
                        List.of(2, 102, 20),
                        List.of(3, 103, 15))
        );
        tm.add(4, 104, 5);
        tm.edit(102, 8);
        System.out.println(tm.execTop());
        tm.rmv(101);
        tm.add(5, 105, 15);
        System.out.println(tm.execTop());
    }
}
