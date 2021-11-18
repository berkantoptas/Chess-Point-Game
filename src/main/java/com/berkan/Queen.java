package com.berkan;

public class Queen extends Pieces{

    public Queen(int clr, int x, int y){
        isThreatened = false;
        point = 9.0;
        color = clr;
        indexX = x;
        indexY = y;
        name = "queen";
    }
}
