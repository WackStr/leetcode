package com.wackstr.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
2025-03-21
 */
public class PossibleRecipes_2115 {

    public List<String> findAllRecipes(
            String[] recipes,
            List<List<String>> ingredients,
            String[] supplies){

        // for quick lookup once recipes are sorted
        Map<String, List<String>> ingredientMap = new HashMap<>();
        // shows dependencies of recipes only
        Map<String, Set<String>> adjacency = new HashMap<>();
        // in degree of recipe dependence only
        Map<String, Integer> inDegree = new HashMap<>();
        // running set of created supplies
        Set<String> supplySet = new HashSet<>();

        Collections.addAll(supplySet, supplies);

        // build the ingredience map
        int recipeIndex = 0;
        for(List<String> ingredient : ingredients){
            String currRecipe = recipes[recipeIndex];
            ingredientMap.put(currRecipe, ingredient);
            recipeIndex++;
        }

        // initialize in degree as 0
        for(String recipe : recipes){
            inDegree.put(recipe, 0);
        }

        /*
        go through each recipe, if its ingredients contains another recipe
        then update the recipe's in-degree and the ingredient's adjacency
         */
        for(String recipe : recipes){
            for(String ingredient : ingredientMap.get(recipe)){
                if(ingredientMap.containsKey(ingredient)){
                    inDegree.merge(recipe, 1, Integer::sum);
                    adjacency.computeIfAbsent(
                            ingredient,
                            v -> new HashSet<>()).add(recipe);
                }
            }
        }


        /*
        Topological sort of the recipes (Kahn's algorithm).
        Recipes that create cycles will lead to nulls. This works for our case,
        since we will not be able to create those recipes anyway
         */
        String[] sortedRecipe = getSortedRecipes(
                recipes.length,
                adjacency,
                inDegree);

        // creating possible recipes with topologically sorted recipes
        return getPossibleRecipes(
                sortedRecipe,
                ingredientMap,
                supplySet
        );
    }

    public String[] getSortedRecipes(
            int n,
            Map<String, Set<String>> adjacency,
        Map<String, Integer> inDegree) {
        String[] sortedRecipe = new String[n];

        // start a stack with 0 inDegree recipes
        Queue<String> sortStack =
                inDegree.keySet().stream()
                        .filter(recipe -> inDegree.get(recipe) == 0)
                        .collect(Collectors.toCollection(ArrayDeque::new));

        int index = 0;
        while(!sortStack.isEmpty()){
            int size = sortStack.size();
            for(int i = 0; i < size; i++){
                String currRecipe = sortStack.poll();
                /*
                reduce indegree of neighbors by 1
                if the indegree of neighbor reaches 0, then add to stack.
                 */
                if(adjacency.containsKey(currRecipe)){
                    for(String adjRecipe : adjacency.get(currRecipe)){
                        if(inDegree.merge(adjRecipe,
                                -1, Integer::sum) == 0) {
                            sortStack.add(adjRecipe);
                        }
                    }
                }
                // add the recipe
                sortedRecipe[index++] = currRecipe;
            }
        }
        return sortedRecipe;
    }

    private List<String> getPossibleRecipes(
            String[] sortedRecipe,
            Map<String, List<String>> ingredientMap,
            Set<String> supplySet
    ){
        List<String> possibleRecipes = new ArrayList<>();

        // go through non-null recipes in topological order
        for(String recipe : sortedRecipe){
            if(recipe != null) {
                // check if all ingredients exist
                boolean canMakeRecipe = true;
                for (String ingredient : ingredientMap.get(recipe)) {
                    if (!supplySet.contains(ingredient)) {
                        canMakeRecipe = false;
                        break;
                    }
                }
                //  add to supply ingredients and return list if possible
                if (canMakeRecipe) {
                    possibleRecipes.add(recipe);
                    supplySet.add(recipe);
                }
            }
        }

        return possibleRecipes;
    }

    public static void main(String[] args) {
        String[] recipes = {"ju","fzjnm","x","e","zpmcz","h","q"};
        List<List<String>> ingredients = List.of(
                List.of("d"),
                List.of("hveml","f","cpivl"),
                List.of("cpivl","zpmcz","h","e","fzjnm","ju"),
                List.of("cpivl","hveml","zpmcz","ju","h"),
                List.of("h","fzjnm","e","q","x"),
                List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),
                List.of("f","hveml","cpivl")
            );
        String[] supplies = {"f","hveml","cpivl","d"};
        PossibleRecipes_2115 sol = new PossibleRecipes_2115();
        System.out.println(sol.findAllRecipes(
                recipes,
                ingredients,
                supplies
        ));

    }
}
