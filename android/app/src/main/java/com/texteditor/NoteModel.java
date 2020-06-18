package com.texteditor;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class NoteModel {

    public int _id;
    public String Title;
    public String Content;
    public String FileName;


    public NoteModel(String data)
    {        JSONObject _data=null;

        try{
            _data = new JSONObject(data);
            this._id= Integer.parseInt(_data.get("id").toString());
            this.Content=_data.get("content").toString();
            this.FileName=_data.get("filename").toString();
            this.Title=_data.get("title").toString();
        }
        catch (Exception ex)
        {
            Log.d("note","json convert exeception");
            Log.d("note error details",ex.getMessage());
        }




    }

}
