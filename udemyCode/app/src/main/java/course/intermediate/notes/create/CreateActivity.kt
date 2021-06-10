package course.intermediate.notes.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import course.intermediate.notes.R
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_TYPE_KEY
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_VALUE_NOTE
import course.intermediate.notes.navigation.NavigationActivity.Companion.FRAGMENT_VALUE_TASK

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = ""

        intent?.extras?.get(FRAGMENT_TYPE_KEY).run {
            if (this == FRAGMENT_VALUE_NOTE) {
                createFragment(CreateNotesFragment.newInstance())
            } else if (this == FRAGMENT_VALUE_TASK) {
                createFragment(CreateTaskFragment.newInstance())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_save, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.saveItem -> Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    fun createFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}