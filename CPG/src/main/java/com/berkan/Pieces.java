package com.berkan;

public class Pieces {
    protected boolean isThreatened;
    protected double point;
    protected int color; //0 white 1 black
    protected int indexX;
    protected int indexY;
    protected String name;

    private boolean checkRight(Pieces[][] board){
        for(int j = indexY + 1; j < 8 ; j++){
            if(board[indexX][j] != null){
                if(board[indexX][j].color != color){
                    if(board[indexX][j].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[indexX][j].name == "rook"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[indexX][j].name == "king"){
                        if(j == (indexY + 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[indexX][j].name == "bishop")
                        break;
                    else if(board[indexX][j].name == "knight")
                        break;
                    else if(board[indexX][j].name == "pawn")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkLeft(Pieces[][] board){
        for(int j = indexY - 1; j >= 0 ; j--){
            if(board[indexX][j] != null){
                if(board[indexX][j].color != color){
                    if(board[indexX][j].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[indexX][j].name == "rook"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[indexX][j].name == "king"){
                        if(j == (indexY - 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[indexX][j].name == "bishop")
                        break;
                    else if(board[indexX][j].name == "knight")
                        break;
                    else if(board[indexX][j].name == "pawn")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkDown(Pieces[][] board){
        for(int i = indexX + 1 ; i < 8 ; i++){
            if(board[i][indexY] != null){
                if(board[i][indexY].color != color){
                    if(board[i][indexY].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][indexY].name == "rook"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][indexY].name == "king"){
                        if(i == (indexX + 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[i][indexY].name == "bishop")
                        break;
                    else if(board[i][indexY].name == "knight")
                        break;
                    else if(board[i][indexY].name == "pawn")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkUp(Pieces[][] board){
        for(int i = indexX - 1; i >= 0 ; i--){
            if(board[i][indexY] != null){
                if(board[i][indexY].color != color){
                    if(board[i][indexY].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][indexY].name == "rook"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][indexY].name == "king"){
                        if(i == (indexX - 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[i][indexY].name == "bishop")
                        break;
                    else if(board[i][indexY].name == "knight")
                        break;
                    else if(board[i][indexY].name == "pawn")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkRightDown(Pieces[][] board){
        for(int i = indexX + 1 , j = indexY + 1; (i < 8) && (j < 8) ; i++, j++){
            if(board[i][j] != null){
                if(board[i][j].color != color){
                    if(board[i][j].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "bishop"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "king"){
                        if(i == (indexX + 1) && j == (indexY + 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "pawn"){
                        if(color == 1){
                            if(i == (indexX + 1) && j == (indexY + 1)){
                                isThreatened = true;
                                return true;
                            }
                            else
                                break;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "knight")
                        break;
                    else if(board[i][j].name == "rook")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkLeftDown(Pieces[][] board){
        for(int i = indexX + 1 , j = indexY - 1; (i < 8) && (j >= 0) ; i++, j--){
            if(board[i][j] != null){
                if(board[i][j].color != color){
                    if(board[i][j].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "bishop"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "king"){
                        if(i == (indexX + 1) && j == (indexY - 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "pawn"){
                        if(color == 1){
                            if(i == (indexX + 1) && j == (indexY - 1)){
                                isThreatened = true;
                                return true;
                            }
                            else
                                break;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "knight")
                        break;
                    else if(board[i][j].name == "rook")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkRightUp(Pieces[][] board){
        for(int i = indexX - 1 , j = indexY + 1; (i >= 0) && (j < 8) ; i--, j++){
            if(board[i][j] != null){
                if(board[i][j].color != color){
                    if(board[i][j].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "bishop"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "king"){
                        if(i == (indexX - 1) && j == (indexY + 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "pawn"){
                        if(color == 0){
                            if(i == (indexX - 1) && j == (indexY + 1)){
                                isThreatened = true;
                                return true;
                            }
                            else
                                break;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "knight")
                        break;
                    else if(board[i][j].name == "rook")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkLeftUp(Pieces[][] board){
        for(int i = indexX - 1 , j = indexY - 1; (i >= 0) && (j >= 0) ; i--, j--){
            if(board[i][j] != null){
                if(board[i][j].color != color){
                    if(board[i][j].name == "queen"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "bishop"){
                        isThreatened = true;
                        return true;
                    }
                    else if(board[i][j].name == "king"){
                        if(i == (indexX - 1) && j == (indexY - 1)){
                            isThreatened = true;
                            return true;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "pawn"){
                        if(color == 0){
                            if(i == (indexX - 1) && j == (indexY - 1)){
                                isThreatened = true;
                                return true;
                            }
                            else
                                break;
                        }
                        else
                            break;
                    }
                    else if(board[i][j].name == "knight")
                        break;
                    else if(board[i][j].name == "rook")
                        break;
                }
                else
                    break;
            }
            else
                continue;
        }
        return false;
    }
    private boolean checkKnight1(Pieces[][] board){
        int x = indexX - 2;
        int y = indexY - 1;
        if(x >= 0 && y >= 0)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight2(Pieces[][] board){
        int x = indexX - 2;
        int y = indexY + 1;
        if(x >= 0 && y < 8)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight3(Pieces[][] board){
        int x = indexX - 1;
        int y = indexY + 2;
        if(x >= 0 && y < 8)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight4(Pieces[][] board){
        int x = indexX + 1;
        int y = indexY + 2;
        if(x < 8 && y < 8)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight5(Pieces[][] board){
        int x = indexX + 2;
        int y = indexY + 1;
        if(x < 8 && y < 8)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight6(Pieces[][] board){
        int x = indexX + 2;
        int y = indexY - 1;
        if(x < 8 && y >= 0)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight7(Pieces[][] board){
        int x = indexX + 1;
        int y = indexY - 2;
        if(x < 8 && y >= 0)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }
    private boolean checkKnight8(Pieces[][] board){
        int x = indexX - 1;
        int y = indexY - 2;
        if(x >= 0 && y >= 0)
            if(board[x][y] != null)
                if(board[x][y].color != color)
                    if(board[x][y].name == "knight"){
                        isThreatened = true;
                        return true;
                    }
        return false;
    }

    public void checkThreats(Pieces[][] board){
        if(checkRight(board))
            return;
        if(checkLeft(board))
            return;
        if(checkDown(board))
            return;
        if(checkUp(board))
            return;
        if(checkRightDown(board))
            return;
        if(checkLeftDown(board))
            return;
        if(checkRightUp(board))
            return;
        if(checkLeftUp(board))
            return;
        if(checkKnight1(board))
            return;
        if(checkKnight2(board))
            return;
        if(checkKnight3(board))
            return;
        if(checkKnight4(board))
            return;
        if(checkKnight5(board))
            return;
        if(checkKnight6(board))
            return;
        if(checkKnight7(board))
            return;
        if(checkKnight8(board))
            return;

        //sa???? solu ??st?? alt?? y??n??nde ta?? var m???
        //  var --> bu ta?? kendi rengiyle ayn?? m???(ilk ??arpt??????)
        //          evet  --> break;
        //          hay??r --> bu ta?? vezir/kale/??ah m???
        //                  vezir --> isThreatened = true, return;
        //                  kale  --> isThreatened = true, return;
        //                  ??ah   --> bu ta?? hemen bir sonraki karede mi bulunuyor?
        //                          evet  --> isThreatened = true, return;
        //                          hay??r --> break;
        //                  fil   --> break;
        //                  at    --> break;
        //                  piyon --> break;
        //  yok --> continue;
        ////
        //sa????st?? sol??st?? sa??alt?? solalt?? y??n??nde ta?? var m???
        //  var --> bu ta?? kendi rengiyle ayn?? m???(ilk ??arpt??????)
        //          evet  --> break;
        //          hay??r --> bu ta?? vezir/fil/??ah m???
        //                  vezir --> isThreatened = true, return;
        //                  fil   --> isThreatened = true, return;
        //                  ??ah   --> bu ta?? hemen bir sonraki karede mi bulunuyor?
        //                          evet  --> isThreatened = true, return;
        //                          hay??r --> break;
        //                  piyon --> sa??alt??/solalt?? i??in kendi rengi siyah m???
        //                          evet  --> bu ta?? hemen bir sonraki karede mi bulunuyor?
        //                                  evet  --> isThreatened = true, return;
        //                                  hay??r --> break;
        //                          hay??r --> break;
        //                        --> sa????st??/sol??st?? i??in kendi rengi beyaz m???
        //                          evet  --> bu ta?? hemen bir sonraki karede mi bulunuyor?
        //                                  evet  --> isThreatened = true, return;
        //                                  hay??r --> break;
        //                          hay??r --> break;
        //                  at    --> break;
        //                  kale  --> break;
        //  yok --> continue;
        ////
        //8 y??nl?? at kontrol??
        ////board d??????na ta??ma durumu
    }
}
