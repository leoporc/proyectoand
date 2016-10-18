package com.idits.DondeEstas;



import com.idits.DondeEstas.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registrarse();
		ingreso();// LLamo a la funcion para el logueo.
		salir();
	}

	public void registrarse() {

		Button Registro = (Button) findViewById(R.id.btnRegistrar);
		Registro.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
			Intent intent = new Intent(MainActivity.this, Log_in.class);
			Bundle bundle = new Bundle();
			intent.putExtras(bundle);
			startActivity(intent);
			
		}
	});
	}
	
	public void ingreso(){
	
	Button Ingreso = (Button) findViewById(R.id.btnLogin);
	Ingreso.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View view) {
		Intent intent = new Intent(MainActivity.this, Ingreso.class);
		Bundle bundle = new Bundle();
		intent.putExtras(bundle);
		startActivity(intent);
		
	}
});
	}
	public void salir() {

		Button Salir = (Button) findViewById(R.id.salir);
		Salir.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setMessage("Seguro que quiere terminar ?").setCancelable(false)
						.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								MainActivity.this.finish();
							}
						}).setNegativeButton("No", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

				AlertDialog alert = builder.create();
				alert.show();
			}
		});
	}
}
