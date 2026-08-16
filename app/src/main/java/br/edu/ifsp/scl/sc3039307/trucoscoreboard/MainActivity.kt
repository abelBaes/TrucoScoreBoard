package br.edu.ifsp.scl.sc3039307.trucoscoreboard

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.sc3039307.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var teamAPoints = 0;
    private var teamBPoints = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        with(amb){
            teamA1PointBt.setOnClickListener {
                teamAPoints += 1
                updateScore()
            }

            teamB1PointBt.setOnClickListener {
                teamBPoints += 1
                updateScore()
            }

            teamA3PointBt.setOnClickListener {
                teamAPoints += 3
                updateScore()
            }

            teamB3PointBt.setOnClickListener {
                teamBPoints += 3
                updateScore()
            }

            resetPointsBt.setOnClickListener {
                teamAPoints = 0
                teamBPoints = 0
                updateScore()
            }
        }
    }

    private fun updateScore(){
        amb.teamAPointsTv.text = teamAPoints.toString();
        amb.teamBPointsTv.text = teamBPoints.toString();
    }
}