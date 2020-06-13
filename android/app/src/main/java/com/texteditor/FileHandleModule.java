package com.texteditor;

import androidx.annotation.NonNull;
import java.io.IOException;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import java.io.File;
//TODO: return absolute path of the newly created file back to javascript.

public class FileHandleModule extends  ReactContextBaseJavaModule {
    private  static ReactApplicationContext reactContext;

    FileHandleModule(ReactApplicationContext context)
    {
        super(context);
        reactContext=context;
    }

    @NonNull
    @Override
    public String getName() {
        return "FileHandlePackage";
    }

    @ReactMethod
    public void WriteFile(String title,String content,Promise promise)
    {
        File myFile;
        String result="error in WriteFile";
        String filename ="mytext1.txt";
        try{

            myFile = new File(filename);
             result= String.format("%s,%s", reactContext.getCacheDir(), filename);
            promise.resolve(result);

        }
        catch (Exception ex)
        {
              promise.reject("ERROR_CANT_SAVE_FILE_MOSHE",ex);


        }




    }


}


