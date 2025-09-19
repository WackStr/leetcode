package com.wackstr.leetcode;

/*
2025-09-19 3484
 */
public class Spreadsheet {

    private final int[] val;
    private static final int WIDTH = ('Z' - 'A') + 1;

    public Spreadsheet(int rows) {
        val = new int[WIDTH *rows];
    }

    public void setCell(String cell, int value) {
        val[getIndex(cell)] = value;
    }

    public void resetCell(String cell) {
        val[getIndex(cell)] = 0;
    }

    public int getValue(String formula) {
        int val1;
        int val2;
        int separator = formula.indexOf('+');
        val1 = parseToken(formula.substring(1, separator));
        val2 = parseToken(formula.substring(separator+1));
        return val1 + val2;
    }

    private int parseToken(String token) {
        return isReference(token) ?
                val[getIndex(token)] :
                Integer.parseInt(token);
    }

    private boolean isReference(String token) {
        char c = token.charAt(0);
        return c >= 'A' && c <= 'Z';
    }

    private static int getIndex(String cell){
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1))-1;
        return row* WIDTH + col;
    }

    public static void main(String[] args) {
        Spreadsheet sol = new Spreadsheet(3);
        System.out.println(sol.getValue("=5+7"));
        sol.setCell("A1", 10);
        System.out.println(sol.getValue("=A1+6"));
        sol.setCell("B2", 15);
        System.out.println(sol.getValue("=A1+B2"));
        sol.resetCell("A1");
        System.out.println(sol.getValue("=A1+B2"));
    }
}
