package com.texteditor;

import androidx.annotation.NonNull;
import java.io.IOException;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.io.File;
//TODO: return absolute path of the newly created file back to javascript.

public class FileHandleModule extends  ReactContextBaseJavaModule {


    @NonNull
    @Override
    public String getName() {
        return "FileHandlePackage";
    }

    @ReactMethod
    public void WriteFile(String title,String content)
    {
        File myFile;
        String filename ="mytext1.txt";
        try{

            myFile = new File(filename);

        }
        catch (IOException ex)
        {
                System.out.println("error");
        }

    }


}


