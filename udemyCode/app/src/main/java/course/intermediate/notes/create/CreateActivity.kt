package course.intermediate.notes.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import course.intermediate.notes.R
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_TYPE_KEY
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_VALUE_NOTE
import kotlinx.android.synthetic.main.activity_main.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent?.extras?.get(FRAGMENT_TYPE_KEY).run {
            textView.text = if (this == FRAGMENT_VALUE_NOTE) {
                "From Note"
            } else {
                "From Task"
            }
        }

    }
}