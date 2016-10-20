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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button btnRegistrar, btnLogin, salir;
	EditText usuario, pass;
	LoginDataBaseAdapter loginDataBaseAdapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
	 
		
		usuario=(EditText)findViewById(R.id.usuario);
		pass=(EditText)findViewById(R.id.pass);	
		btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
		btnLogin=(Button)findViewById(R.id.btnLogin);
		salir=(Button)findViewById(R.id.salir);
		btnRegistrar.setOnClickListener(this);
		btnLogin.setOnClickListener(this);
		salir.setOnClickListener(this);
	}

	
			public void onClick(View view) {
	
				
			 if(view==btnRegistrar){
					 Intent intent = new Intent(MainActivity.this, Log_in.class);
					 Bundle bundle = new Bundle();
					 intent.putExtras(bundle);
					 startActivity(intent);
			
				 }
			if(view==btnLogin){
				// get The User name and Password
				String userName=usuario.getText().toString();
				String password=pass.getText().toString();

				// fetch the Password form database for respective user name
				String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

				// check if the Stored password matches with  Password entered by user
				if(password.equals(storedPassword))
				{
					Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(MainActivity.this, Ingreso.class);
					Bundle bundle = new Bundle();
					intent.putExtras(bundle);
					startActivity(intent);

				}
				else
				{
					Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
				}
				
				
				}
				
				 if(view==salir){
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
				 
			}
}