package com.example.myapp

import android.widget.Toast


class Script(){
    fun randomNumber(max:Int, min:Int):Int{
        val num = (min..max).random()
        return num
    }

    fun initializeNum():Array<Int>{
        var num:Int
        var infoPoints = arrayOf<Int>()
        for(i in 0..1){
            num = randomNumber(11, 1)
            infoPoints += num
        }
        return infoPoints
    }

    fun calculateTotal(dPoints:Int, pPoints:Int, coins:Int, quota:Int):Array<Int>{
        var result = arrayOf<Int>()
        if((21 - dPoints) < (21 - pPoints)){
            result += coins
            result += 0
        }else{
            result += coins + (quota*2)
            result += 1
        }

        return result
    }

    fun newCard(cardList:Array<Int>):Array<Int>{
        val card = randomNumber(11, 1)
        var listCard = cardList
        listCard += card
        return listCard
    }

    fun checkAbove(dPoints: Int, pPoints: Int):Boolean{
        return (21 - dPoints) >= (21 - pPoints)
    }




}