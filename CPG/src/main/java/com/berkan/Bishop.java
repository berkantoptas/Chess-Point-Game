package com.berkan;

public class Bishop extends Pieces{

    public Bishop(int clr, int x, int y){
        isThreatened = false;
        point = 3.0;
        color = clr;
        indexX = x;
        indexY = y;
        name = "bishop";
    }
}
