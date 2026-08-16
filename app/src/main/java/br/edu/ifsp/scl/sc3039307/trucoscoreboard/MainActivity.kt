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

    private var teamAPoints = 0
    private var teamBPoints = 0

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
        amb.teamAPointsTv.text = teamAPoints.toString()
        amb.teamBPointsTv.text = teamBPoints.toString()

        if(teamAPoints == 0 && teamBPoints == 0) amb.resetPointsBt.isEnabled = false else amb.resetPointsBt.isEnabled = true

        amb.teamAGamePointTv.visibility = if(teamAPoints == 11) View.VISIBLE else View.GONE
        amb.teamBGamePointTv.visibility = if(teamBPoints == 11) View.VISIBLE else View.GONE

        val teamAHasWon = teamAPoints == 12
        val teamBHasWon = teamBPoints == 12

        amb.teamAGameWinTv.visibility = if (teamAHasWon) View.VISIBLE else View.GONE
        amb.teamBGameWinTv.visibility = if (teamBHasWon) View.VISIBLE else View.GONE

        if(teamAHasWon || teamBHasWon) disablePointsButtons() else enablePointsButtons()
    }

    private fun disablePointsButtons(){
        amb.teamA1PointBt.isEnabled = false
        amb.teamA3PointBt.isEnabled = false
        amb.teamB1PointBt.isEnabled = false
        amb.teamB3PointBt.isEnabled = false
    }

    private fun enablePointsButtons(){
        amb.teamA1PointBt.isEnabled = true
        amb.teamA3PointBt.isEnabled = true
        amb.teamB1PointBt.isEnabled = true
        amb.teamB3PointBt.isEnabled = true
    }
}