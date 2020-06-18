/* eslint-disable prettier/prettier */
import React, { useState } from 'react';
import { StyleSheet, View, Button, Alert } from 'react-native';
import Title from './title';
import Content from './content';
import ToastExample from './ToastExample';
import FileHandle from './FileHandle';





export default function App() {


  const [title, setTitle] = useState('Im title text...');
  const [text, setText] = useState('Im content:  text...');



  const WriteToFile = async (data) => {
    try {
      var result = await FileHandle.WriteFile(data);
      console.log('write to file function been called.');
      console.log(result);
    }
    catch (e) {
      console.log('KIRA_ERROR_FILE_WRITE');
      console.error(e);
    }

  };

  function saveNote() {
    Alert.alert(title + ": " + text);
    const note = {
      'id': 'uuid123',//TODO: generate uuid , on the native code it would be used for index
      'title': title,
      'content': text,
      'filename':'fileAmazing2.txt', //TODO: define filename using uuid with date or something.

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
