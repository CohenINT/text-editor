/* eslint-disable prettier/prettier */
import React,{useState} from 'react';
import {StyleSheet,TextInput ,Text,View, Button, Alert} from 'react-native';



export default function App() {
  const [text,setText] = useState('Im content text...');


  function saveNote()
  {
    Alert.alert(text);
    
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
