package com.idits.tercerproyecto;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
	}

	
}
