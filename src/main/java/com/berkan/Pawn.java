package com.berkan;

public class Pawn extends Pieces{

    public Pawn(int clr, int x, int y){
        isThreatened = false;
        point = 1.0;
        color = clr;
        indexX = x;
        indexY = y;
        name = "pawn";
    }
}
