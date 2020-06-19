/* eslint-disable prettier/prettier */
import React, { useState } from 'react';
import { StyleSheet, View, Button } from 'react-native';
import Title from './title';
import Content from './content';
import ToastExample from './ToastExample';
import FileHandle from './FileHandle';





export default function App() {


  const [title, setTitle] = useState('Im title text...');
  const [text, setText] = useState('Im content:  text...');


  const LoadNotes = async () => {
    try {

      let result = await FileHandle.GetNotesList();
      console.log("GetNotesList invoked.  check result ");
      console.log(result);
      //TODO: parse result to it's subjective class object, to use in upcoming components.
      
    }
    catch (e) {
      console.log("error, no notes found");
      console.log(e);


    }
  };
  const LoadNote = async (filename = '18.06.2020-13:34:54.json') => {

    try {
      let result = await FileHandle.getNote(filename);
      console.log('LoadNote() invoked. check result: ');
      console.log(result);
    }
    catch (e) {

      console.log('error with loading note');
      console.log(e);
    }

  };
  const WriteToFile = async (data) => {
    try {
      let result = await FileHandle.WriteFile(data);
      console.log('write to file function been called.');
      console.log(result);
    }
    catch (e) {
      console.log('KIRA_ERROR_FILE_WRITE');
      console.error(e);
    }

  };



  function saveNote() {
    const note = {
      'id': 'uuid123',//TODO: generate uuid , on the native code it would be used for index
      'title': title,
      'content': text,

    };
    console.log(JSON.stringify(note));

    //Todo: inoke java function with the title as paramter
    WriteToFile(JSON.stringify(note));

  }


  ToastExample.show('Awesome', ToastExample.SHORT);
  return (
    <View>
      <Title setTitleValue={setTitle} />
      <Content setContentValue={setText} />

      <Button
        title="Press here"
        onPress={() => {
          saveNote();
        }}
      />
    </View>
  );









}

const styles = StyleSheet.create({
  title: {
    fontSize: 91,
    backgroundColor: 'red',
    display: 'flex',
  },
});
