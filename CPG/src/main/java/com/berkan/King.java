package com.berkan;

public class King extends Pieces{

    public King(int clr, int x, int y){
        isThreatened = false;
        point = 100.0;
        color = clr;
        indexX = x;
        indexY = y;
        name = "king";
    }
}
