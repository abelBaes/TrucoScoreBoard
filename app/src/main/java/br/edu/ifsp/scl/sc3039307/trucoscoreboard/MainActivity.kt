package br.edu.ifsp.scl.sc3039307.trucoscoreboard

import android.os.Bundle
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
                (++teamAPoints).let{ teamAPointsTv.text = it.toString()}
            }

            teamB1PointBt.setOnClickListener {
                (++teamBPoints).let{ teamBPointsTv.text = it.toString()}
            }
        }
    }
}