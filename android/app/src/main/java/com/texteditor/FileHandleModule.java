package com.texteditor;
//https://stackoverflow.com/questions/14376807/read-write-string-from-to-a-file-in-android
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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

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
        String path=reactContext.getFilesDir().getAbsolutePath();
        File directory = new File(path);
        List<File>files = Arrays.asList(directory.listFiles());
        List<String>ListOfFiles = new ArrayList<>();

        Log.d("files_kira","***** file list ****");

        for(File item : files)
        {
                Log.d(item.getName(),item.getName());
                ListOfFiles.add(item.getName());

        }
        return ListOfFiles;
    }
    @ReactMethod
    public void getNote(String filename)
    {//TODO: need to think of unique way to define file names like using unique id an index that have details about the file using its unique id. s
        //for now its filename

        String result;
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
                    result = stringBuilder.toString();


                }

        }
        catch (Exception ex)
        {
            Log.e("Error exception: ", ex.toString());
        }


    }
    @ReactMethod
    public void WriteFile(String title,String content,Promise promise)
    {
        String result="error in WriteFile";
        String filename ="mytext12.txt";
        try{
            Log.d("kira","trying to scan files");

                OutputStream out;
                OutputStreamWriter output = new OutputStreamWriter(reactContext.openFileOutput(filename,reactContext.MODE_PRIVATE));
                output.write("initiate first line writting to file dude.");
                output.write("inititate second line dude");
                output.close();
             result= String.format("%s,%s", reactContext.getFilesDir(), filename);
            promise.resolve(result);


        }
        catch (Exception ex)
        {
              promise.reject("ERROR_CANT_SAVE_FILE_MOSHE",ex);


        }




    }


}


