package cz.uhk.fim.umtekotlinapp

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailTextView.text = "Hello from Main activity"

        val stingExtra = intent.getStringExtra("key")
        Toast.makeText(this, stingExtra, Toast.LENGTH_SHORT).show()

        confirmButton.setOnClickListener {
            var alertBuilder = AlertDialog.Builder(this)

            alertBuilder.setTitle("Title")
            alertBuilder.setMessage("Opravdu chcete aktivitu ukončit?")
            /*alertBuilder.setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })*/

            alertBuilder.setPositiveButton("Ok") { dialog, _ ->
                //vrácení dat do main activity
                val resultIntent = Intent()
                resultIntent.putExtra("result", "Done!")
                setResult(Activity.RESULT_OK, resultIntent)

                dialog.dismiss()
                finish()
            }

            alertBuilder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

            alertBuilder.create().show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
