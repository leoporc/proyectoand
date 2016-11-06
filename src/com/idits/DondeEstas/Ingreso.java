package com.idits.DondeEstas;



import com.idits.DondeEstas.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Ingreso extends Activity {
	
    public TextView textoSalida;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingreso);
        textoSalida = (TextView) findViewById(R.id.textView1);
		traeContactos();
	}

	 public void traeContactos() {

	        String numeroTelefono = null;
	        String email = null;

	        Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
	        String _ID = ContactsContract.Contacts._ID;
	        String NOMBRE = ContactsContract.Contacts.DISPLAY_NAME;
	        String TIENE_NUMERO = ContactsContract.Contacts.HAS_PHONE_NUMBER;

	        Uri URI_TelefonoContent = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
	        String ID_CONTACTO = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
	        String NUMERO = ContactsContract.CommonDataKinds.Phone.NUMBER;

	        Uri Email_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
	        String EmailCONTACTO_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
	        String DATA = ContactsContract.CommonDataKinds.Email.DATA;

	        StringBuffer output = new StringBuffer();

	        ContentResolver contentResolver = getContentResolver();

	        Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null);

	        // Por cada contacto en el telefono
	        if (cursor.getCount() > 0) {

	            while (cursor.moveToNext()) {

	                String contact_id = cursor.getString(cursor.getColumnIndex(_ID));
	                String nombre = cursor.getString(cursor.getColumnIndex(NOMBRE));

	                int tieneNumeroTelefono = Integer.parseInt(cursor.getString(cursor.getColumnIndex(TIENE_NUMERO)));

	                if (tieneNumeroTelefono > 0) {

	                    output.append("n Nombre:" + nombre);

	                    // por cada numero de contacto
	                    Cursor cursorTelefono = contentResolver.query(URI_TelefonoContent, null, ID_CONTACTO + " = ?",
	                            new String[] { contact_id }, null);

	                    while (cursorTelefono.moveToNext()) {
	                        numeroTelefono = cursorTelefono.getString(cursorTelefono.getColumnIndex(NUMERO));
	                        output.append("n Teléfono:" + numeroTelefono);

	                    }

	                    cursorTelefono.close();

	                    // por cada mail del contacto
	                    Cursor emailCursor = contentResolver.query(Email_URI, null, EmailCONTACTO_ID + " = ?",
	                            new String[] { contact_id }, null);

	                    while (emailCursor.moveToNext()) {

	                        email = emailCursor.getString(emailCursor.getColumnIndex(DATA));

	                        output.append("nEmail:" + email);

	                    }

	                    emailCursor.close();
	                }

	                output.append("n");
	            }

	            textoSalida.setText(output);
	        }
	    }

}
