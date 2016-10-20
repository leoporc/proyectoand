package com.idits.DondeEstas;



import com.idits.DondeEstas.R;

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
import android.widget.Toast;

public class Log_in extends Activity {
	
	
	EditText nombre, numero, pass;
	Button registrar;
	
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);

		// get Instance  of Database Adapter
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();

		// Get Refferences of Views
		nombre=(EditText)findViewById(R.id.nombre);
		numero=(EditText)findViewById(R.id.numero);
		pass=(EditText)findViewById(R.id.pass);
		registrar=(Button)findViewById(R.id.registrar);
		registrar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				String userName=nombre.getText().toString();
				String telefono=numero.getText().toString();
				String password=pass.getText().toString();
				

				// check if any of the fields are vaccant
				if(userName.equals("")||telefono.equals("")||password.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
						return;
				}
				    // Save the Data in Database
				    loginDataBaseAdapter.insertEntry(userName, telefono, password);
				    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
				
			}
		});
	}
		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();

			loginDataBaseAdapter.close();
		}

}
	
