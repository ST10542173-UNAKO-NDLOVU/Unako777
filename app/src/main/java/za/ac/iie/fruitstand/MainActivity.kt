package za.ac.iie.fruitstand

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    
        //Declarations//
        
        val fruits = arrayOf<String>("Banana", "Orange", "Blueberry", "Strawberry", "Apple",
            "Mango", "Peach", "Lime", "Kiwi", "Necterine")
        
        val prices = arrayOf<Double>(10.00, 15.00, 12.00, 14.00, 15.00, 8.00, 9.00, 10.00, 15.00,
            10.00)

        val tvDisplay = findViewById<TextView>(R.id.tvDisplay)
        val tvReport = findViewById<TextView>(R.id.tvReport)
        val btnReport = findViewById<Button>(R.id.btnReport)

        var displayText = "My fruit list"

        var counter = 0

        while (counter < fruits.size) {
            displayText += "\n" + fruits[counter] + "- R" + "${prices[counter]}"
            counter++
        }

        tvDisplay.text = displayText

        btnReport.setOnClickListener {
            var maximum: Double = 0.00
            var minimum: Double = 100.00
            var Expensive = ""
            var Cheap = ""

            // Use a local counter so we don't rely on the global 'counter' which is already finished
            var reportCounter = 0

            while (reportCounter < prices.size) {
                if (prices[reportCounter] >= maximum){
                    maximum = prices[reportCounter]
                    Expensive = "Most expensive fruit: ${fruits[reportCounter]} ----- (R ${prices[reportCounter]})"
                }
                
                if (prices[reportCounter] <= minimum){
                    minimum = prices[reportCounter]
                    Cheap = "\nLeast expensive fruit: ${fruits[reportCounter]} ----- (R ${prices[reportCounter]})"
                }
                reportCounter++
            }
            tvReport.text = "Total number of fruits: ${fruits.count()} \n ${Expensive} \n${Cheap}"
        //
       //Array is collection of the same type
            //Parralell arrays is when you can corelate the two lists and have same number of elelements
            //Manual example of arrays

            //for loop = var display = "INVENTORY"\n
        // for ( x in 0 <.., fruits.count() -1 ) {
            //var line = fruits [x] = " " = "R " + prices [x]
            //display += line = "\n"
            // tvDisplay.text = display

            //While loop
            //var x = 0
            //var results = "INVENSTORY\n"
            //while (x ,= prices.count  - 1)

            //If you want to find the highest or the lowest
            //var


































        }
    }
}
