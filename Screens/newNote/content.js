/* eslint-disable prettier/prettier */
import React,{useState} from 'react';
import {StyleSheet,TextInput ,Text,View, Button, Alert} from 'react-native';
import FileHandle from './FileHandle';

export default function App() {
  const [text,setText] = useState('Im content text...');
  const WriteToFile = async (title, content) => {
    try {
      var result = await FileHandle.WriteFile("myTitle", "myContent");
      console.log("write to file function been called.");
      console.log(result);
    }
    catch (e) {
      console.log("KIRA_ERROR_FILE_WRITE");
      console.error(e);
    }

  }

  function saveNote()
  {
    Alert.alert(text);
    //Todo: inoke java function with the title as paramter
    WriteToFile("myTitle", "myContent");

  }


  return (
    <View>

    <TextInput value={text} multiline={true}
      onChangeText={
        (e)=>setText(e)
      }

     />

    <Button
    title="Press here"
    onPress={()=>{
      saveNote();
    }}
    />
    </View>
  );
}

// const styles = StyleSheet.create({
//   title: {
//     fontSize: 91,
//     backgroundColor: 'red',
//     display: 'flex',
//   },
// });
