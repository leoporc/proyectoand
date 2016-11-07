package com.idits.DondeEstas;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.idits.DondeEstas.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	
	Button btnRegistrar, btnLogin, salir;
	EditText usuario, numero, pass;
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
		//salir=(Button)findViewById(R.id.salir);
		btnRegistrar.setOnClickListener(this);
		btnLogin.setOnClickListener(this);
		//salir.setOnClickListener(this);
	}
	
	
	
    
   /** private class BuscarDatos extends AsyncTask<Void, Void, Boolean> {
    	protected Boolean doInBackground(Void... params) {
    	// TODO: attempt authentication against a network service.
    	HttpClient httpClient = new DefaultHttpClient();
    	HttpPost post = new HttpPost("http://192.168.1.34:8080/Servidor_Usuarios/Login");
    	post.setHeader("content-type", "application/json");
    	try
    	{
    	//Construimos el objeto cliente en formato JSON
    	JSONObject dato = new JSONObject();
    	dato.put("nombre", usuario.getText().toString());
    	dato.put("numero", numero.getText().toString());
    	dato.put("pass", pass.getText().toString() );
    	StringEntity entity = new StringEntity(dato.toString());
    	post.setEntity(entity);
    	HttpResponse resp = httpClient.execute(post);
    	resultado = EntityUtils.toString(resp.getEntity());
    	}
    	catch(Exception ex)
    	{ Log.e("ServicioRest","Error!", ex); return false; }
    	return true;
    	}
    	
    **/
    
    
    /**
     public List<Animal> readJsonStream(InputStream in) throws IOException {
        // Nueva instancia JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return leerArrayAnimales(reader);
        } finally {
            reader.close();
        }
    }
    **/
    
    
    
    
    
    
    
    
	
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
					Toast.makeText(MainActivity.this, "Felicitaciones: Login Correcto", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(MainActivity.this, Ingreso.class);
					Bundle bundle = new Bundle();
					intent.putExtras(bundle);
					startActivity(intent);

				}
				else
				{
					Toast.makeText(MainActivity.this, "Usuario o contraseña no corresponde", Toast.LENGTH_LONG).show();
				}
				
				
				}
				
//				 if(view==salir){
//						AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//						builder.setMessage("Seguro que quiere terminar ?").setCancelable(false)
//								.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//									public void onClick(DialogInterface dialog, int id) {
//										MainActivity.this.finish();
//									}
//								}).setNegativeButton("No", new DialogInterface.OnClickListener() {
//									public void onClick(DialogInterface dialog, int id) {
//										dialog.cancel();
//									}
//								});
//
//						AlertDialog alert = builder.create();
//						alert.show();
//				 }
				 
			}
}