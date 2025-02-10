package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFolder {

    public static class FolderNode {
        Map<String, FolderNode> children;
        boolean bound;
        String val;
        String rep;

        public FolderNode(String val, String rep){
            this.val = val;
            this.rep = rep;
            this.children = new HashMap<>();
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Map<String, FolderNode> folderNodes = mapToFolderNodes(folder);
        List<String> ans = new ArrayList<>();
        for (FolderNode node : folderNodes.values()) {
            List<String> rootFolders = getRootFolders(node);
            ans.addAll(rootFolders);
        }
        return ans;
    }

    private List<String> getRootFolders(FolderNode node) {
        List<String> ans = new ArrayList<>();
        if (node.bound) {
            ans.add(node.rep);
        } else if (node.children != null && !node.children.isEmpty()) {
            for (FolderNode child : node.children.values()) {
                List<String> childRep = getRootFolders(child);
                if (!childRep.isEmpty()) {
                    ans.addAll(childRep);
                }
            }
        }
        return ans;
    }

    private Map<String, FolderNode> mapToFolderNodes(String[] folder) {
        Map<String, FolderNode> parentLayer = new HashMap<>();
        for (String currFolder : folder) {
            String[] tokens = currFolder.substring(1).split("/");
            FolderNode finalNode = addTokensToLayer(null, parentLayer, tokens);
            finalNode.bound = true;
        }
        return parentLayer;
    }

    private FolderNode addTokensToLayer(
            FolderNode parentNode,
            Map<String, FolderNode> parentLayer,
            String[] tokens) {
        FolderNode root =
                addTokenToLayer(null, parentLayer, tokens[0]);
        if(tokens.length == 1){
            return root;
        }else{
            FolderNode currNode = root;
            for(int i = 1; i < tokens.length; i++){
                currNode = addTokenToLayer(currNode, currNode.children, tokens[i]);
            }
            return currNode;
        }
    }

    private FolderNode addTokenToLayer(
            FolderNode parentNode,
            Map<String, FolderNode> currLayer,
            String token) {
        if(currLayer.containsKey(token)){
            return currLayer.get(token);
        }
        String rep;
        if(parentNode == null){
            rep = String.format("/%s", token);
        }else{
            rep = String.format("%s/%s", parentNode.rep, token);
        }
        FolderNode node = new FolderNode(token, rep);
        currLayer.put(token, node);
        return node;
    }

    public static void main(String[] args) {
        RemoveSubFolder sol = new RemoveSubFolder();
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> mainFolders = sol.removeSubfolders(folder);
        System.out.println(mainFolders);
    }
}
