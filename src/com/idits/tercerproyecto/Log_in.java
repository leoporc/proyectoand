package com.idits.tercerproyecto;

import com.idits.tercerproyecto.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Log_in extends Activity {
	
	public EditText nombre;
	public EditText numero;
	public EditText pass;
	
	public String strNombre, strTelefono, strPass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		salir();
	}
	public void salir(){
	Button atras = (Button) findViewById(R.id.volver);
	atras.setOnClickListener(new View.OnClickListener() {
		public void onClick(View view) {
			Intent intent = new Intent(Log_in.this, MainActivity.class);
			Bundle bundle = new Bundle();
			intent.putExtras(bundle);
			startActivity(intent);
			Log_in.this.finish();
		}
	});
	}
}