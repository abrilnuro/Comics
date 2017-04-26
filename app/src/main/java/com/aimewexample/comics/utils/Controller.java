package com.aimewexample.comics.utils;

import android.content.Context;
import android.util.Log;

import com.aimewexample.comics.events.SuccessGetCharacter;
import com.aimewexample.comics.events.SuccessGetComics;
import com.aimewexample.comics.events.SuccessGetDetails;
import com.aimewexample.comics.models.Characters;
import com.aimewexample.comics.models.Comics;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aimew on 10/04/2017.
 */

public class Controller {

    private String url = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=bebb06a8e5327a3b48056bb6e834be6b&hash=28bc212aa195713a7996278a2b286d9b&nameStartsWith=";
    private RequestQueue requestQueue;
    private Gson gson;
    private RetryPolicy policy;

    public Controller(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        gson = new Gson();
        policy = new DefaultRetryPolicy(70000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

    public void getCharacters(String character) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url+character, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Log.i("RESPONSE: ", response.toString());
                    JSONObject jsonObjectData = response.getJSONObject("data");
                    JSONArray jsonArray = jsonObjectData.getJSONArray("results");
                    List<Characters> characterList = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Characters character = gson.fromJson(jsonObject.toString(), Characters.class);
                        characterList.add(character);
                        Log.i("CHARACTER: ", character.getName());
                    }
                    App.getBus().post(new SuccessGetCharacter(characterList));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("Error Response", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error Response", error.toString());
            }
        });
        //request
        jsonObjectRequest.setRetryPolicy(policy);
        requestQueue.add(jsonObjectRequest);
    }

    public void getComics(String character, final int position) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url+character, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Log.i("RESPONSE: ", response.toString());
                    JSONObject jsonObjectData = response.getJSONObject("data");
                    JSONArray jsonArrayResults = jsonObjectData.getJSONArray("results");
                    JSONObject jsonObjectCharacter = jsonArrayResults.getJSONObject(position);

                    //obtener la imagen
                    JSONObject jsonObjectImage = jsonObjectCharacter.getJSONObject("thumbnail");
                    String path = jsonObjectImage.getString("path");
                    String extension = jsonObjectImage.getString("extension");
                    String image = path + "." + extension;

                    //obtener el nombre
                    String name = jsonObjectCharacter.getString("name");

                    //obtener la descripcion
                    String description = jsonObjectCharacter.getString("description");

                    //crear el objeto character
                    Characters character = new Characters(name, image, description);


                    App.getBus().post(new SuccessGetDetails(character));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("Error Response", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error Response", error.toString());
            }
        });
        //request
        jsonObjectRequest.setRetryPolicy(policy);
        requestQueue.add(jsonObjectRequest);
    }

    public void getDetails(String character, final int position) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url+character, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Log.i("RESPONSE: ", response.toString());
                    JSONObject jsonObjectData = response.getJSONObject("data");
                    JSONArray jsonArrayResults = jsonObjectData.getJSONArray("results");
                    JSONObject jsonObjectCharacter = jsonArrayResults.getJSONObject(position);
                    JSONObject jsonObjectComics = jsonObjectCharacter.getJSONObject("comics");
                    JSONArray jsonArrayItems = jsonObjectComics.getJSONArray("items");

                    List<Comics> comicList = new ArrayList<>();
                    for (int i = 0; i < jsonArrayItems.length(); i++) {
                        JSONObject jsonObject = jsonArrayItems.getJSONObject(i);
                        Comics comic = gson.fromJson(jsonObject.toString(), Comics.class);
                        comicList.add(comic);
                        Log.i("CHARACTER: ", comic.getName());
                    }
                    App.getBus().post(new SuccessGetComics(comicList));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("Error Response", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error Response", error.toString());
            }
        });
        //request
        jsonObjectRequest.setRetryPolicy(policy);
        requestQueue.add(jsonObjectRequest);
    }
}
