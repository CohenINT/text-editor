package com.texteditor;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class NoteModel {

    public String  id;
    public String title;
    public String content;
    public String filename;



    public NoteModel(String data)
    {
        JSONObject _data=null;
            Log.d("msg","creating note model instance with data string content.");
        try{
            _data= new JSONObject(data);
            this.id=_data.getString("id");
            this.title=_data.getString("title");
            this.content=_data.getString("content");



        }

        catch (JSONException err)
        {
            Log.d("Json error",err.toString());
        }
        catch (Exception ex)
        {
            Log.d("General error",ex.toString());
        }

    }









}
