package com.texteditor;
//https://stackoverflow.com/questions/14376807/read-write-string-from-to-a-file-in-android
import android.util.JsonReader;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import com.google.gson.Gson;
import  com.texteditor.NoteModel;

//TODO: return absolute path of the newly created file back to javascript.

public class FileHandleModule extends  ReactContextBaseJavaModule {
    private  static ReactApplicationContext reactContext;
    private static File directory_path;

    FileHandleModule(ReactApplicationContext context)
    {
        super(context);
        directory_path=context.getFilesDir();
        reactContext=context;
    }

    @NonNull
    @Override
    public String getName() {
        return "FileHandlePackage";
    }


    public List<String>getFilesList()
    {
        String path=directory_path.getAbsolutePath();
        File directory = new File(path);
        List<File>files = Arrays.asList(directory.listFiles());
        List<String>ListOfFiles = new ArrayList<String>();

        Log.d("Note_files","***** list of notes ****");

        for(File item : files)
        {

                if(item.isFile()&&item.getName().endsWith(".json")) {
                    Log.d("item",item.getName());
                    ListOfFiles.add(item.getName());

                }
        }
        return ListOfFiles;
    }


    @ReactMethod
    public void GetNotesList(Promise promise)
    {
       List<String> file_list =  getFilesList();
       List<String>Notes_List = new ArrayList<String>();

       Log.d("loading notes","****notes list****");
       for(String item : file_list)
       {
            String temp=  LoadNote(item);
            Log.d("current_item",temp);
            if(temp!=""&&temp!=null)
             Notes_List.add(temp );

       }

       if(Notes_List!=null)
       {
           //TODO: pick a way to send back the data to react native
           promise.resolve(Notes_List.toString());
       }

       else{
           promise.reject("No notes were found.",new Exception("NO_NOTES_FOUND"));
       }




    }


    private String LoadNote(String filename)
    {
        String result="";
        try{

            InputStream input = reactContext.openFileInput(filename);
            if(input!=null)
            {
                InputStreamReader inputRead = new InputStreamReader(input);
                BufferedReader buffreader = new BufferedReader(inputRead);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while((receiveString = buffreader.readLine()) != null){
                    stringBuilder.append("\n").append(receiveString);

                }

                input.close();
              return stringBuilder.toString() ;


            }

        }
        catch (Exception ex)
        {
            Log.e("Error exception: ", ex.toString());
        }

        return result;
    }
    @ReactMethod
    public void getNote(String filename,Promise promise)
    {
       String note = LoadNote(filename);

       if(note==""||note==null)
       {
           Log.e("Error","error in loading note "+filename);
           promise.reject("ERROR LOADING NOTE- "+filename,new Exception("ERROR LOADING NOTE"));
           return;
       }
       promise.resolve(note);







    }





    @ReactMethod
    public void WriteFile(String data_json, Promise promise)
    {
        Log.d("Note","write to file invoked");
        String result="error in WriteFile";
        NoteModel note = new NoteModel(data_json);
        String filename="";
        filename=GenerateFilename();

        getFilesList();
        if(note == null)
        {
            promise.reject("ERROR_JSON_CONVERT", new Exception("ERROR JSON CONVERT"));
        }

        try{
                Log.d("kira","trying to scan files");

                OutputStream out;
                OutputStreamWriter output = new OutputStreamWriter(reactContext.openFileOutput(filename,reactContext.MODE_PRIVATE));
                output.write(data_json);
                Log.d("save",data_json);

                output.close();
                result= "Note saved. "+filename;
                promise.resolve(result);


        }
        catch (Exception ex)
        {
              promise.reject("ERROR_CANT_SAVE_FILE_MOSHE",ex);
        }




    }

    private String GenerateFilename() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
        return ft.format(date)+".json";
    }


}


