package com.example.myapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.coroutines.awaitAll
import java.util.Objects

class StartingMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting_main)
        var coins:Int = 1000000
        val inputQuota = findViewById<EditText>(R.id.inputQuota)


        val mediaplayer = MediaPlayer.create(this, R.raw.cardsound)


        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val startTxt = AnimationUtils.loadAnimation(this, R.anim.txtstart)

        val totalPlayerPoints = findViewById<TextView>(R.id.totalPlayerPoints)
        val totalDealerPoints = findViewById<TextView>(R.id.totalDealerPoints)

        val saldo = findViewById<TextView>(R.id.totalCoins)
        saldo.text = "Saldo $coins"
        
        val resultWin = findViewById<TextView>(R.id.idWin)
        resultWin.visibility = View.INVISIBLE
        val resultLose = findViewById<TextView>(R.id.idLose)
        resultLose.visibility = View.INVISIBLE

        val pThirdCard = findViewById<ImageView>(R.id.p_card3)
        pThirdCard.visibility = View.INVISIBLE

        val pFourthCard = findViewById<ImageView>(R.id.p_card4)
        pFourthCard.visibility = View.INVISIBLE

        val pFifthCard = findViewById<ImageView>(R.id.p_card5)
        pFifthCard.visibility = View.INVISIBLE

        val dThirdCard = findViewById<ImageView>(R.id.d_card3)
        dThirdCard.visibility = View.INVISIBLE

        val dFourthCard = findViewById<ImageView>(R.id.d_card4)
        dFourthCard.visibility = View.INVISIBLE

        val dFifthCard = findViewById<ImageView>(R.id.d_card5)
        dFifthCard.visibility = View.INVISIBLE


        val pNum1 = findViewById<TextView>(R.id.p_num1)

        val pNum2 = findViewById<TextView>(R.id.p_num2)

        val pNum3 = findViewById<TextView>(R.id.p_num3)
        pNum3.visibility = View.INVISIBLE

        val pNum4 = findViewById<TextView>(R.id.p_num4)
        pNum4.visibility = View.INVISIBLE

        val pNum5 = findViewById<TextView>(R.id.p_num5)
        pNum5.visibility = View.INVISIBLE

        val dNum1 = findViewById<TextView>(R.id.d_num1)

        val dNum2 = findViewById<TextView>(R.id.d_num2)

        val dNum3 = findViewById<TextView>(R.id.d_num3)
        dNum3.visibility = View.INVISIBLE

        val dNum4 = findViewById<TextView>(R.id.d_num4)
        dNum4.visibility = View.INVISIBLE

        val dNum5 = findViewById<TextView>(R.id.d_num5)
        dNum5.visibility = View.INVISIBLE

        val startButton = findViewById<Button>(R.id.startButton)

        val btnCard = findViewById<Button>(R.id.btnCarta)
        btnCard.visibility = View.INVISIBLE

        val btnStop = findViewById<Button>(R.id.btnStop)
        btnStop.visibility = View.INVISIBLE




        val script = Script()
        var pList = arrayOf<Int>()
        var dList = arrayOf<Int>()
        var countCard:Int = 2
        var pPoints:Int = 0
        var dPoints:Int = 0
        var dCount = 2




        startButton.setOnClickListener{
            val quota:String = inputQuota.text.toString()
            coins -= quota.toInt()

            val view: View? = this.currentFocus
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            if (view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }

            saldo.text = "Saldo $coins"
            totalPlayerPoints.text = "0"
            dPoints = 0
            pPoints = 0
            dCount = 0
            startButton.visibility = View.INVISIBLE
            totalDealerPoints.visibility = View.INVISIBLE
            btnCard.visibility = View.VISIBLE
            btnStop.visibility = View.VISIBLE
            dNum3.visibility = View.INVISIBLE
            dNum4.visibility = View.INVISIBLE
            dNum5.visibility = View.INVISIBLE
            pNum3.visibility = View.INVISIBLE
            pNum4.visibility = View.INVISIBLE
            pNum5.visibility = View.INVISIBLE
            resultWin.visibility = View.INVISIBLE
            resultLose.visibility = View.INVISIBLE
            inputQuota.visibility = View.INVISIBLE
            dThirdCard.visibility = View.INVISIBLE
            dFourthCard.visibility = View.INVISIBLE
            dFifthCard.visibility = View.INVISIBLE
            pThirdCard.visibility = View.INVISIBLE
            pFourthCard.visibility = View.INVISIBLE
            pFifthCard.visibility = View.INVISIBLE
            countCard = 2

            pList = script.initializeNum()
            dList = script.initializeNum()




            var elem = pList.elementAt(0).toString()
            if(elem == "1"){
                elem = "A"
            }

            if(elem == "10"){
                val check = script.randomNumber(1,0)
                if(check == 0){
                    elem = "Q"
                }
                if(check == 1){
                    elem = "K"
                }
            }

            if(elem == "11"){
                elem = "J"
            }
            pNum1.visibility = View.VISIBLE
            pNum1.text = elem
            pNum1.startAnimation(ttb)


            elem = pList.elementAt(1).toString()
            if(elem == "1"){
                elem = "A"
            }

            if(elem == "10"){
                val check = script.randomNumber(1,0)
                if(check == 0){
                    elem = "Q"
                }
                if(check == 1){
                    elem = "K"
                }
            }

            if(elem == "11"){
                elem = "J"
            }
            pNum2.text = elem
            pNum2.visibility = View.VISIBLE
            pNum2.startAnimation(ttb)


            elem = dList.elementAt(0).toString()
            if(elem == "1"){
                elem = "A"
            }

            if(elem == "10"){
                val check = script.randomNumber(1,0)
                if(check == 0){
                    elem = "Q"
                }
                if(check == 1){
                    elem = "K"
                }
            }

            if(elem == "11"){
                elem = "J"
            }
            dNum1.text = elem
            dNum1.visibility = View.VISIBLE
            dNum1.startAnimation(ttb)

            elem = dList.elementAt(1).toString()
            if(elem == "1"){
                elem = "A"
            }

            if(elem == "10"){
                val check = script.randomNumber(1,0)
                if(check == 0){
                    elem = "Q"
                }
                if(check == 1){
                    elem = "K"
                }
            }

            if(elem == "11"){
                elem = "J"
            }
            dNum2.text = "?"

            pPoints += pList.elementAt(0) + pList.elementAt(1)
            dPoints += dList.elementAt(0) + dList.elementAt(1)

            totalPlayerPoints.text = "Punti: $pPoints"
            totalDealerPoints.text = "Punti: $dPoints"
        }





        btnStop.setOnClickListener{
            btnCard.visibility = View.INVISIBLE
            val quota:String = inputQuota.text.toString()
            totalDealerPoints.visibility = View.VISIBLE
            var checkAbove:Boolean = script.checkAbove(dPoints, pPoints)
            dNum2.text = dList.elementAt(1).toString()
            dNum2.visibility = View.VISIBLE
            dNum2.startAnimation(ttb)
            while (checkAbove){
                dList = script.newCard(dList)
                dCount+= 1
                if (dCount == 3){
                    dNum3.visibility = View.VISIBLE
                    dThirdCard.visibility = View.VISIBLE
                    var elem = dList.elementAt(dCount - 1).toString()
                    if(elem == "1"){
                        elem = "A"
                    }

                    if(elem == "10"){
                        val check = script.randomNumber(1,0)
                        if(check == 0){
                            elem = "Q"
                        }
                        if(check == 1){
                            elem = "K"
                        }
                    }
                    if(elem == "11"){
                        elem = "J"
                    }
                    dNum3.text = elem
                    dNum3.startAnimation(ttb)
                    dPoints += dList.elementAt(dCount - 1)
                }
                if (dCount == 4){
                    dNum4.visibility = View.VISIBLE
                    dFourthCard.visibility = View.VISIBLE
                    var elem = dList.elementAt(dCount - 1).toString()
                    if(elem == "1"){
                        elem = "A"
                    }

                    if(elem == "10"){
                        val check = script.randomNumber(1,0)
                        if(check == 0){
                            elem = "Q"
                        }
                        if(check == 1){
                            elem = "K"
                        }
                    }
                    if(elem == "11"){
                        elem = "J"
                    }
                    dNum4.text = elem
                    dNum4.startAnimation(ttb)
                    dPoints += dList.elementAt(dCount - 1)
                }
                if (dCount == 5){
                    dNum5.visibility = View.VISIBLE
                    dFifthCard.visibility = View.VISIBLE
                    var elem = dList.elementAt(dCount - 1).toString()
                    if(elem == "1"){
                        elem = "A"
                    }

                    if(elem == "10"){
                        val check = script.randomNumber(1,0)
                        if(check == 0){
                            elem = "Q"
                        }
                        if(check == 1){
                            elem = "K"
                        }
                    }
                    if(elem == "11"){
                        elem = "J"
                    }
                    dNum5.text = elem
                    dNum5.startAnimation(ttb)
                    dPoints += dList.elementAt(dCount - 1)
                }
                if (dPoints > 21){
                    resultWin.visibility = View.VISIBLE
                    totalDealerPoints.text = "Punti $dPoints"
                    checkAbove = script.checkAbove(dPoints, pPoints)
                    coins += (quota.toInt())*2
                    break
                }
                if(dCount > 5){
                    resultWin.visibility = View.VISIBLE
                    Toast.makeText(this, "You win", Toast.LENGTH_LONG).show()
                    totalDealerPoints.text = "Punti $dPoints"
                    break
                }
                checkAbove = script.checkAbove(dPoints, pPoints)
                totalDealerPoints.text = "Punti $dPoints"
            }


            if (dPoints <= 21){
                val result = script.calculateTotal(dPoints, pPoints, coins, quota.toInt())
                val check = result.elementAt(1)

                startButton.startAnimation(startTxt)
                startButton.visibility = View.VISIBLE

                if(check == 0){
                    resultLose.visibility = View.VISIBLE
                    coins = result.elementAt(0)
                }else{
                    resultWin.visibility = View.VISIBLE
                    coins = result.elementAt(0)
                }
                btnStop.visibility = View.INVISIBLE
            }
            saldo.text = "Saldo $coins"

            startButton.visibility = View.VISIBLE
            inputQuota.hint = "Inserire Quota e premere Start"
            
            inputQuota.visibility = View.VISIBLE
            btnStop.visibility = View.INVISIBLE

            
        }

        btnCard.setOnClickListener{
            mediaplayer!!.start()
            pList = script.newCard(pList)
            countCard += 1
            if (countCard == 3){
                pNum3.visibility = View.VISIBLE
                pThirdCard.visibility = View.VISIBLE
                var elem = pList.elementAt(countCard - 1).toString()
                if(elem == "1"){
                    elem = "A"
                }

                if(elem == "10"){
                    val check = script.randomNumber(1,0)
                    if(check == 0){
                        elem = "Q"
                    }
                    if(check == 1){
                        elem = "K"
                    }
                }

                if(elem == "11"){
                    elem = "J"
                }
                pNum3.text = elem
                pNum3.startAnimation(ttb)
                pPoints += pList.elementAt(countCard - 1)
            }
            if (countCard == 4){
                pNum4.visibility = View.VISIBLE
                pFourthCard.visibility = View.VISIBLE
                var elem = pList.elementAt(countCard - 1).toString()
                if(elem == "1"){
                    elem = "A"
                }

                if(elem == "10"){
                    val check = script.randomNumber(1,0)
                    if(check == 0){
                        elem = "Q"
                    }
                    if(check == 1){
                        elem = "K"
                    }
                }

                if(elem == "11"){
                    elem = "J"
                }
                pNum4.text = elem
                pNum4.startAnimation(ttb)
                pPoints += pList.elementAt(countCard - 1)
            }
            if (countCard == 5){
                pNum5.visibility = View.VISIBLE
                pFifthCard.visibility = View.VISIBLE
                var elem = pList.elementAt(countCard - 1).toString()
                if(elem == "1"){
                    elem = "A"
                }

                if(elem == "10"){
                    val check = script.randomNumber(1,0)
                    if(check == 0){
                        elem = "Q"
                    }
                    if(check == 1){
                        elem = "K"
                    }
                }

                if(elem == "11"){
                    elem = "J"
                }
                pNum5.text = elem
                pNum5.startAnimation(ttb)
                pPoints += pList.elementAt(countCard - 1)
            }
            if (pPoints > 21){
                btnCard.visibility = View.INVISIBLE
                btnStop.visibility = View.INVISIBLE
                dNum3.visibility = View.INVISIBLE
                dNum4.visibility = View.INVISIBLE
                dNum5.visibility = View.INVISIBLE
                dThirdCard.visibility = View.INVISIBLE
                dFourthCard.visibility = View.INVISIBLE
                dFifthCard.visibility = View.INVISIBLE
                startButton.visibility = View.VISIBLE
                resultLose.visibility = View.VISIBLE
                inputQuota.visibility = View.VISIBLE
                
            }
            totalPlayerPoints.text = pPoints.toString()

        }
    }
}


