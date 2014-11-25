package com.android.jorge.volleyexample;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity implements OnClickListener{

	private static String urlJson = "http://enterprisesolutions.com.py/android/ejercicios/login/json.php";
	private Button enviarPregunta;
	private TextView respuesta;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		enviarPregunta = (Button) findViewById(R.id.enviarPregunta);
		respuesta = (TextView) findViewById(R.id.respuesta);
		
		enviarPregunta.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		preguntarSrvidor();
	}

	private void preguntarSrvidor() {
		RequestQueue queue = Volley.newRequestQueue(this);
		
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();
		
		// We Don't override getParams(). 
		// JsonObjectRequest uses third argument in constructor to get post parameters. 
		JSONObject parametros = new JSONObject();
		try {
			parametros.put("tag", "pregunta");
		} catch (Exception e) {
			e.printStackTrace();   
		}

		// Request a string response from the provided URL.
		StringRequest stringRequest = new StringRequest(Request.Method.POST, urlJson, 
				new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						pDialog.hide();
						
						try {
							JSONObject json;
							json = new JSONObject(response);
							respuesta.setText("Respuesta: "+ json.getString("respuesta").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						pDialog.hide();
						respuesta.setText("Respuesta: Fallo al recibir respuesta");
						
					}
				}) {
			@Override
			protected Map<String, String> getParams()
					throws AuthFailureError {
				Map<String, String> parametros = new HashMap<String, String>();
				parametros.put("tag", "respuesta");
				
				return parametros;
			}
		};
				
		queue.add(stringRequest);
	}
}
