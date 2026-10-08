package kasireddymahendrareddy.com.kasireddymahendrareddy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etInput: EditText
    private lateinit var btnAgent: Button
    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInput = findViewById(R.id.etInput)
        btnAgent = findViewById(R.id.btnProcess)
        tvOutput = findViewById(R.id.tvOutput)

        btnAgent.setOnClickListener {

            val userInput = etInput.text.toString().trim()

            if (userInput.isEmpty()) {
                tvOutput.text = "Please enter a message."
                return@setOnClickListener
            }

            tvOutput.text = processAgent(userInput)
        }
    }

    private fun processAgent(input: String): String {

        val text = input.lowercase()

        var intent = "Unknown"
        var action = "Sorry, I don't understand."

        when {

            text.contains("hello") || text.contains("hi") -> {
                intent = "Greeting"
                action = "Hello! Welcome to the AI Agent."
            }

            text.contains("weather") -> {
                intent = "Weather Query"
                action = "Today's weather is Sunny."
            }

            text.contains("time") -> {
                intent = "Time Query"
                action = "Please check your mobile clock."
            }

            text.contains("name") -> {
                intent = "Identity Query"
                action = "I am a Rule-Based AI Agent."
            }

            text.contains("bye") -> {
                intent = "Exit"
                action = "Goodbye! Have a nice day."
            }

            text.contains("help") -> {
                intent = "Help Request"
                action = "You can ask me about weather, time, name or greetings."
            }
        }

        return """
Perception:
User Input = "$input"

Reasoning:
Intent = $intent

Action:
$action
""".trimIndent()
    }
}