package com.idits.DondeEstas;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.idits.DondeEstas.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
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
	
//	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);

		// Instancia de Adaptador BD
	//	loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	//	loginDataBaseAdapter=loginDataBaseAdapter.open();

		// Referencia a las vistas
		nombre=(EditText)findViewById(R.id.nombre);
		numero=(EditText)findViewById(R.id.numero);
		pass=(EditText)findViewById(R.id.pass);
		registrar=(Button)findViewById(R.id.registrar);
		registrar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				String userName=nombre.getText().toString();
				String telefono=numero.getText().toString();
				String password=pass.getText().toString();
				new ExecuteTask().execute(userName,telefono, password);
				

				// Chequear si los datos estan todos completos
				if(userName.equals("")||telefono.equals("")||password.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Campo Vacante", Toast.LENGTH_LONG).show();
						return;
				}
				    // Guardar en BD
					
				  //  loginDataBaseAdapter.insertEntry(userName, telefono, password);
				   // Toast.makeText(getApplicationContext(), "Cuenta creada satifactoriamente ", Toast.LENGTH_LONG).show();
				   // Intent intent = new Intent(Log_in.this, MainActivity.class);
					// Bundle bundle = new Bundle();
					// intent.putExtras(bundle);
					// startActivity(intent);
				
			}
		});
	}
	
	 class ExecuteTask extends AsyncTask<String, Integer, String>
     {

         @Override
         protected String doInBackground(String... params) {
             
             PostData(params);
             return null;
         }
         
         @Override
         protected void onPostExecute(String result) {
         }
         
     }
	 
	 public void PostData(String[] valuse) {
         try
         {
         HttpClient httpClient=new DefaultHttpClient();
        // HttpPost httpPost=new HttpPost("http://10.0.2.2:8080/Servidor_Usuarios/Registro");
         HttpPost httpPost=new HttpPost("http://192.168.1.119:8080/Servidor_Usuarios/Registro");
         
         List<NameValuePair> list=new ArrayList<NameValuePair>();
         list.add(new BasicNameValuePair("nombre", valuse[0]));
         list.add(new BasicNameValuePair("numero",valuse[1]));
         list.add(new BasicNameValuePair("pass",valuse[2]));
         httpPost.setEntity(new UrlEncodedFormEntity(list));
         httpClient.execute(httpPost);
       
         }
         catch(Exception e)
         
         {
            // System.out.println(e);
             e.printStackTrace();
         }
         
     }
	//	@Override
	//	protected void onDestroy() {
			// TODO Auto-generated method stub
//			super.onDestroy();

	//		loginDataBaseAdapter.close();
	//	}

}
	
