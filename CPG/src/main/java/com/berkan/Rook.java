package com.berkan;

public class Rook extends Pieces{

    public Rook(int clr, int x, int y){
        isThreatened = false;
        point = 5.0;
        color = clr;
        indexX = x;
        indexY = y;
        name = "rook";
    }
}
