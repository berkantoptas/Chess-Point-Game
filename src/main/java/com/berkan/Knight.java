package com.berkan;

public class Knight extends Pieces{

    public Knight(int clr, int x, int y){
        isThreatened = false;
        point = 3.0;
        color = clr;
        indexX = x;
        indexY = y;
        name = "knight";
    }
}
