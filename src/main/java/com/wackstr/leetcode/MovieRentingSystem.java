package com.wackstr.leetcode;

import java.util.*;

/*
2025-09-21 1912
 */
public class MovieRentingSystem {
    private final Map<Integer, List<int[]>> unrentedMovies;
    private final List<int[]> rentedMovies;
    private final Map<Integer, Map<Integer, Integer>> moviePrice;

    public MovieRentingSystem(int n, int[][] entries) {
        rentedMovies = new ArrayList<>();
        unrentedMovies = new HashMap<>();
        moviePrice = new HashMap<>();
        for(int[] entry : entries){
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];
            List<int[]> list = unrentedMovies.computeIfAbsent(movie, k -> new ArrayList<>());
            moviePrice.computeIfAbsent(movie, k -> new HashMap<>()).put(shop, price);
            int[] shopPrice = {shop, price};
            list.add(getMovieIndex(list, shopPrice), shopPrice);

        }
    }

    public List<Integer> search(int movie) {
        List<int[]> shops = unrentedMovies.getOrDefault(movie, new ArrayList<>());
        return shops.stream().map(t -> t[0]).limit(5).toList();
    }

    public void rent(int shop, int movie) {
        List<int[]> shops = unrentedMovies.get(movie);
        int price = moviePrice.get(movie).get(shop);
        int[] shopPrice = {shop, price};
        shops.remove(getMovieIndex(shops, shopPrice));
        int[] entry = {shop, movie, price};
        int index = getEntryIndex(entry, rentedMovies);
        rentedMovies.add(index, entry);
    }

    public void drop(int shop, int movie) {
        List<int[]> shops = unrentedMovies.get(movie);
        int price = moviePrice.get(movie).get(shop);
        int[] shopPrice = {shop, price};
        shops.add(getMovieIndex(shops, shopPrice), shopPrice);
        int[] entry = {shop, movie, price};
        int index = getEntryIndex(entry, rentedMovies);
        rentedMovies.remove(index);
    }

    public List<List<Integer>> report() {
        return rentedMovies.stream().map(t -> List.of(t[0], t[1])).limit(5).toList();
    }

    private static int getMovieIndex(List<int[]> movies, int[] shopPrice){
        int i = Collections.binarySearch(movies, shopPrice, MovieRentingSystem::compareShopPrice);
        return i >= 0 ? i : -(i+1);
    }

    private static int getEntryIndex(int[] entry, List<int[]> rentedMovies) {
        int i = Collections.binarySearch(rentedMovies, entry, MovieRentingSystem::compareEntry);
        return i >= 0 ? i : -(i+1);
    }

    private static int compareEntry(int[] a, int[] b) {
        return a[2] == b[2] ?
                (a[0] == b[0] ?  a[1] - b[1] : a[0] - b[0])
                : a[2] - b[2];
    }

    private static int compareShopPrice(int[] a, int[] b) {
        return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
    }

    public static void main(String[] args) {
        MovieRentingSystem sol = new MovieRentingSystem(
                3,
                new int[][]{
                        {0,1,5},
                        {0,2,6},
                        {0,3,7},
                        {1,1,4},
                        {1,2,7},
                        {2,1,5}
                }
        );
        System.out.println(sol.search(1));
        sol.rent(0,1);
        sol.rent(1,2);
        System.out.println(sol.report());
        sol.drop(1,2);
        System.out.println(sol.search(2));

    }
}
